package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.models.Curriculum;
import vn.edu.iuh.fit.repositories.CourseRepository;
import vn.edu.iuh.fit.repositories.CurriculumRepository;
import vn.edu.iuh.fit.responses.ResponesCourse;
import vn.edu.iuh.fit.responses.ResponesCurricular;
import vn.edu.iuh.fit.services.CourseService;
import vn.edu.iuh.fit.services.CurriculumService;

import java.util.List;

@RestController
@RequestMapping(path = "/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    @GetMapping("/{student_id}/{major_id}")
    public List<ResponesCourse> findCourseByStudentIdAndMajorId(@PathVariable("student_id") long studentId, @PathVariable("major_id") long majorId){
        return courseService.findCourseByStudentIdAndMajorId(studentId, majorId);
    }
}
