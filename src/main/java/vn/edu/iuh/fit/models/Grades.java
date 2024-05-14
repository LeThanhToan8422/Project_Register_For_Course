package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.IdClass.GradeId;

@Entity
@Table(name = "grades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(GradeId.class)
public class Grades {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User studentId;
    @Id
    @ManyToOne
    @JoinColumn(name = "course_section_id")
    private CourseSection courseSectionId;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courseId;
    private double grades;
    private String evaluate;
}
