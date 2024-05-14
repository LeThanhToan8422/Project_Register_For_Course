package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.repositories.CourseRepository;
import vn.edu.iuh.fit.repositories.CourseSectionRepository;
import vn.edu.iuh.fit.responses.ResponesCourse;
import vn.edu.iuh.fit.responses.ResponesCourseSection;
import vn.edu.iuh.fit.responses.ResponesDetailCourseSection;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseSectionService {
    @Autowired
    private CourseSectionRepository courseSectionRepository;

    public List<ResponesCourseSection> findCourseSectionsByMajorId(Long majorId){
        List<ResponesCourseSection> responesCourseSections = new ArrayList<>();
        for (Object[] o : courseSectionRepository.findCourseSectionsByMajorId(majorId)){
            ResponesCourseSection responesCourseSection = new ResponesCourseSection(o[0]+"", o[1]+"", o[2]+"", o[3]+"", o[4]+"", o[5]+"", o[6]+"");
            responesCourseSections.add(responesCourseSection);
        }
        return responesCourseSections;
    }

    public List<ResponesDetailCourseSection> findDetailCourseSectionsByCourseSectionId(Long courseSectionId){
        List<ResponesDetailCourseSection> responesDetailCourseSections = new ArrayList<>();
        for (Object[] o : courseSectionRepository.findDetailCourseSectionsByCourseSectionId(courseSectionId)){
            ResponesDetailCourseSection responesDetailCourseSection = new ResponesDetailCourseSection(o[0]+"", o[1]+"", o[2]+"", o[3]+"", o[4]+"");
            responesDetailCourseSections.add(responesDetailCourseSection);
        }
        return responesDetailCourseSections;
    }
}
