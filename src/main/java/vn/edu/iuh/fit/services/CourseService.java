package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.repositories.CourseRepository;
import vn.edu.iuh.fit.repositories.CurriculumRepository;
import vn.edu.iuh.fit.responses.ResponesCourse;
import vn.edu.iuh.fit.responses.ResponesCurricular;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<ResponesCourse> findCourseByStudentIdAndMajorId(Long studentId, Long majorId){
        List<ResponesCourse> responesCourses = new ArrayList<>();
        for (Object[] o : courseRepository.findCourseByStudentIdAndMajorId(studentId, majorId)){
            ResponesCourse responesCourse = new ResponesCourse(o[0]+"", o[1]+"", o[2]+"", o[3]+"", o[4]+"", o[5]+"");
            responesCourses.add(responesCourse);
        }
        return responesCourses;
    }
}
