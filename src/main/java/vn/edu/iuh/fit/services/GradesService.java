package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GradesRepository;
import vn.edu.iuh.fit.responses.ResponesCourseSectionsRegistered;
import vn.edu.iuh.fit.responses.ResponesGrades;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradesService {
    @Autowired
    private GradesRepository gradesRepository;

    public List<ResponesGrades> findGradesByStudentId(Long studentId){
        List<ResponesGrades> responesGrades = new ArrayList<>();
        for (Object[] o : gradesRepository.findGradesByStudentId(studentId)){
            ResponesGrades responesGrades1 = new ResponesGrades(o[0]+"", o[1]+"", o[2]+"", o[3]+"", o[4]+"", o[5]+"", o[6]+"", o[7]+"", o[8]+"", o[9]+"", o[10]+"", o[11]+"", o[12]+"");
            responesGrades.add(responesGrades1);
        }
        return responesGrades;
    }
}
