package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.models.Grades;
import vn.edu.iuh.fit.repositories.*;
import vn.edu.iuh.fit.responses.ResponesCourseSectionsRegistered;
import vn.edu.iuh.fit.responses.ResponesGrades;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradesService {
    @Autowired
    private GradesRepository gradesRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseSectionRepository courseSectionRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;


    public String create(
            String studentId,
            String courseSectionId,
            String courseId,
            String lectureTheoryId,
            String lecturePracticeId,
            String semester
    ){
        Course course = courseRepository.findById(Long.parseLong(courseId)).get();
        if(gradesRepository.findCreditsOfSemesterByStudentId(Long.parseLong(studentId), semester).get(0) != null){
            if(Long.parseLong(gradesRepository.findCreditsOfSemesterByStudentId(Long.parseLong(studentId), semester).get(0)[0]+"") + course.getCredits() > 30){
                return "credits cannot be greater than 30";
            }
        }
        if(course.getPrerequisiteId() != null){
            if(gradesRepository.findPrerequisiteByStudentIdAndCourseId(Long.parseLong(studentId), course.getPrerequisiteId().getId()) == null){
                return "You have not completed the prerequisite course";
            }
        }
        if(Long.parseLong(scheduleRepository.findScheduleByStudentIdSemesterLectureTheoryAndLecturePractice(Long.parseLong(courseSectionId), Long.parseLong(lectureTheoryId), Long.parseLong(lecturePracticeId), semester, Long.parseLong(studentId)).get(0)[0]+"") > 0){
            return "Class schedules clash";
        }

        Grades grades = new Grades();
        grades.setStudentId(userRepository.findById(Long.parseLong(studentId)).get());
        grades.setCourseSectionId(courseSectionRepository.findById(Long.parseLong(courseSectionId)).get());
        grades.setCourseId(course);
        grades.setLectureTheoryId(userRepository.findById(Long.parseLong(lectureTheoryId)).get());
        grades.setLecturePracticeId(userRepository.findById(Long.parseLong(lecturePracticeId)).get());
        grades.setSemester(semester);
        scheduleRepository.updateStudentEnrollmentNumberByTypeTheory(Long.parseLong(courseSectionId), Long.parseLong(lectureTheoryId));
        scheduleRepository.updateStudentEnrollmentNumberByTypePractice(Long.parseLong(courseSectionId), Long.parseLong(lecturePracticeId));
        gradesRepository.save(grades);
        return "Success";
    }

    public List<ResponesGrades> findGradesByStudentId(Long studentId){
        List<ResponesGrades> responesGrades = new ArrayList<>();
        for (Object[] o : gradesRepository.findGradesByStudentId(studentId)){
            ResponesGrades responesGrades1 = new ResponesGrades(o[0]+"", o[1]+"", o[2]+"", o[3]+"", o[4]+"", o[5]+"", o[6]+"", o[7]+"", o[8]+"", o[9]+"", o[10]+"", o[11]+"", o[12]+"");
            responesGrades.add(responesGrades1);
        }
        return responesGrades;
    }
}
