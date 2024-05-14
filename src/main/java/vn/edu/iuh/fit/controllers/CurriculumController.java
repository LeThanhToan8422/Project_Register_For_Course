package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.Curriculum;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.CurriculumRepository;
import vn.edu.iuh.fit.responses.ResponesCurricular;
import vn.edu.iuh.fit.services.AccountService;
import vn.edu.iuh.fit.services.CurriculumService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/curricular")
@CrossOrigin(origins = "*")
public class CurriculumController {
    @Autowired
    private CurriculumService curriculumService;
    @Autowired
    private CurriculumRepository curriculumRepository;

    @GetMapping
    public List<Curriculum> findAll(){
        return curriculumRepository.findAll();
    }

    @GetMapping("/{student_id}/{major_id}")
    public List<ResponesCurricular> findCurriculumByStudentIdAndMajorId(@PathVariable("student_id") long studentId, @PathVariable("major_id") long majorId){
        return curriculumService.findCurriculumByStudentIdAndMajorId(studentId, majorId);
    }
}
