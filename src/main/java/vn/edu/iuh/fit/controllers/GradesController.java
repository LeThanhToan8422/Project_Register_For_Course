package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.models.Grades;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.*;
import vn.edu.iuh.fit.responses.ResponesGrades;
import vn.edu.iuh.fit.services.GradesService;

import java.util.List;

@RestController
@RequestMapping(path = "/grades")
@CrossOrigin(origins = "*")
public class GradesController {
    @Autowired
    private GradesService gradesService;
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

    @PostMapping
    public String create(
            @RequestParam("studentId") String studentId,
            @RequestParam("courseSectionId") String courseSectionId,
            @RequestParam("courseId") String courseId,
            @RequestParam("lectureTheoryId") String lectureTheoryId,
            @RequestParam("lecturePracticeId") String lecturePracticeId,
            @RequestParam("semester") String semester
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

    @GetMapping("/{student_id}")
    public List<ResponesGrades> findGradesByStudentId(@PathVariable("student_id") long studentId){
        return gradesService.findGradesByStudentId(studentId);
    }
}
