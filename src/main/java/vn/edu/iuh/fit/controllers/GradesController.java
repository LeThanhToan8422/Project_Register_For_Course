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
        return gradesService.create(studentId,courseSectionId,courseId,lectureTheoryId,lecturePracticeId,semester);
    }

    @GetMapping("/{student_id}")
    public List<ResponesGrades> findGradesByStudentId(@PathVariable("student_id") long studentId){
        return gradesService.findGradesByStudentId(studentId);
    }
}
