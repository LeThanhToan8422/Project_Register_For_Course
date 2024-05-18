package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.repositories.CourseRepository;
import vn.edu.iuh.fit.repositories.ScheduleRepository;
import vn.edu.iuh.fit.responses.ResponesCourse;
import vn.edu.iuh.fit.responses.ResponesSchedule;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<ResponesSchedule> findScheduleByStudentId(Long studentId){
        List<ResponesSchedule> responesSchedules = new ArrayList<>();
        for (Object[] o : scheduleRepository.findScheduleByStudentId(studentId)){
            ResponesSchedule responesSchedule = new ResponesSchedule(o[0]+"", o[1]+"", o[2]+"", o[3]+"", o[4]+"", o[5]+"", o[6]+"", o[7]+"", o[8]+"");
            responesSchedules.add(responesSchedule);
        }
        return responesSchedules;
    }
}
