package vn.edu.iuh.fit.responses;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.DayOfWeek;
import vn.edu.iuh.fit.models.CourseSection;
import vn.edu.iuh.fit.models.User;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponesSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String dayOfWeek;
    private String shift;
    private String buildings;
    private String type;
    private String fullName;
    private String startTime;
    private String endTime;
}
