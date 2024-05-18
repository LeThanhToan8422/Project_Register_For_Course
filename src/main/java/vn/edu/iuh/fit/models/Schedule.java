package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.enums.DayOfWeek;

import java.time.LocalDate;

@Entity
@Table(name = "schedules")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;
    private String shift;
    private String buildings;
    private String type;
    private Long student_enrollment_number;
    @ManyToOne
    @JoinColumn(name = "course_section_id")
    private CourseSection courseSectionId;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private User lectureId;
}
