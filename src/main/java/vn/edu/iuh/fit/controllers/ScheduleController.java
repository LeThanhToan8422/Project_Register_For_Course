package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.repositories.ScheduleRepository;
import vn.edu.iuh.fit.responses.ResponesSchedule;
import vn.edu.iuh.fit.services.ScheduleService;

import java.util.List;

@RestController
@RequestMapping(path = "/schedules")
@CrossOrigin(origins = "*")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/{student_id}")
    public List<ResponesSchedule> findScheduleByStudentId(@PathVariable("student_id") long studentId){
        return scheduleService.findScheduleByStudentId(studentId);
    }
}
