package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Grades;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.CourseRepository;
import vn.edu.iuh.fit.repositories.CourseSectionRepository;
import vn.edu.iuh.fit.repositories.GradesRepository;
import vn.edu.iuh.fit.repositories.UserRepository;
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

    @PostMapping
    public Grades create(
            @RequestParam("studentId") Long studentId,
            @RequestParam("courseSectionId") Long courseSectionId,
            @RequestParam("courseId") Long courseId,
            @RequestParam("lectureTheoryId") Long lectureTheoryId,
            @RequestParam("lecturePracticeId") Long lecturePracticeId
    ){
        Grades grades = new Grades();
        grades.setStudentId(userRepository.findById(studentId).get());
        grades.setCourseSectionId(courseSectionRepository.findById(courseSectionId).get());
        grades.setCourseId(courseRepository.findById(courseId).get());
        grades.setLectureTheoryId(userRepository.findById(lectureTheoryId).get());
        grades.setLecturePracticeId(userRepository.findById(lecturePracticeId).get());
        return gradesRepository.save(grades);
    }
}