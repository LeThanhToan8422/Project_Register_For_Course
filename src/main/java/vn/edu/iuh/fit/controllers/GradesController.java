package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.models.Grades;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.*;
import vn.edu.iuh.fit.services.GradesService;

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
            @RequestParam("studentId") Long studentId,
            @RequestParam("courseSectionId") Long courseSectionId,
            @RequestParam("courseId") Long courseId,
            @RequestParam("lectureTheoryId") Long lectureTheoryId,
            @RequestParam("lecturePracticeId") Long lecturePracticeId,
            @RequestParam("semester") String semester
    ){
        Course course = courseRepository.findById(courseId).get();
        if(gradesRepository.findCreditsOfSemesterByStudentId(studentId, semester).get(0) != null){
            if(Long.parseLong(gradesRepository.findCreditsOfSemesterByStudentId(studentId, semester).get(0)[0]+"") + course.getCredits() > 30){
                return "credits cannot be greater than 30";
            }
        }
        else if(course.getPrerequisiteId() != null){
            if(gradesRepository.findPrerequisiteByStudentIdAndCourseId(studentId, course.getPrerequisiteId().getId()) == null){
                return "You have not completed the prerequisite course";
            }
        }
        Grades grades = new Grades();
        grades.setStudentId(userRepository.findById(studentId).get());
        grades.setCourseSectionId(courseSectionRepository.findById(courseSectionId).get());
        grades.setCourseId(course);
        grades.setLectureTheoryId(userRepository.findById(lectureTheoryId).get());
        grades.setLecturePracticeId(userRepository.findById(lecturePracticeId).get());
        grades.setSemester(semester);
        scheduleRepository.updateStudentEnrollmentNumberByTypeTheory(courseSectionId, lectureTheoryId);
        scheduleRepository.updateStudentEnrollmentNumberByTypePractice(courseSectionId, lecturePracticeId);
        gradesRepository.save(grades);
        return "Success";
    }
}
