package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.models.CourseSection;
import vn.edu.iuh.fit.repositories.CourseRepository;
import vn.edu.iuh.fit.repositories.CourseSectionRepository;
import vn.edu.iuh.fit.repositories.ScheduleRepository;
import vn.edu.iuh.fit.responses.ResponesCourse;
import vn.edu.iuh.fit.responses.ResponesCourseSection;
import vn.edu.iuh.fit.responses.ResponesCourseSectionsRegistered;
import vn.edu.iuh.fit.responses.ResponesDetailCourseSection;
import vn.edu.iuh.fit.services.CourseSectionService;
import vn.edu.iuh.fit.services.CourseService;

import java.util.List;

@RestController
@RequestMapping(path = "/course-sections")
@CrossOrigin(origins = "*")
public class CourseSectionController {
    @Autowired
    private CourseSectionService courseSectionService;
    @Autowired
    private CourseSectionRepository courseSectionRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping
    public List<CourseSection> findAll(){
        return courseSectionRepository.findAll();
    }

    @GetMapping("/{major_id}")
    public List<ResponesCourseSection> findCourseSectionsByMajorId(@PathVariable("major_id") long majorId){
        return courseSectionService.findCourseSectionsByMajorId(majorId);
    }

    @GetMapping("/detail-course-section/{course_section_id}")
    public List<ResponesDetailCourseSection> findDetailCourseSectionsByCourseSectionId(@PathVariable("course_section_id") long courseSectionId){
        return courseSectionService.findDetailCourseSectionsByCourseSectionId(courseSectionId);
    }

    @GetMapping("/registered-course-section/{student_id}/{semester}")
    public List<ResponesCourseSectionsRegistered> findCourseSectionsRegisteredByStudentIdAndSemester(@PathVariable("student_id") long studentId, @PathVariable("semester") String semester){
        return courseSectionService.findCourseSectionsRegisteredByStudentIdAndSemester(studentId, semester);
    }

    @GetMapping("/student-enrollment-numbers/{course_section_id}")
    public Long findStudentEnrollmentNumbersByCourseSectionId(@PathVariable("course_section_id") long courseSectionId){
        return Long.parseLong(scheduleRepository.findStudentEnrollmentNumbersByCourseSectionId(courseSectionId).get(0)[0]+"");
    }
}
