package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.repositories.CurriculumRepository;
import vn.edu.iuh.fit.responses.ResponesCurricular;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurriculumService {
    @Autowired
    private CurriculumRepository curriculumRepository;

    public List<ResponesCurricular> findCurriculumByStudentIdAndMajorId(Long studentId, Long majorId){
        List<ResponesCurricular> responesCurriculars = new ArrayList<>();
        for (Object[] o : curriculumRepository.findCurriculumByStudentIdAndMajorId(studentId, majorId)){
            ResponesCurricular responesCurricular = new ResponesCurricular(o[0]+"", o[1]+"", o[2]+"", o[3]+"", o[4]+"", o[5]+"", o[6]+"", o[7]+"", o[8]+"");
            responesCurriculars.add(responesCurricular);
        }
        return responesCurriculars;
    }
}
