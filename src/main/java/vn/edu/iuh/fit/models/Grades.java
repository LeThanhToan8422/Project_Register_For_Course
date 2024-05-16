package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
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
    @Column(name = "theory_grades")
    private double theoryGrades;
    @Column(name = "practice_grades")
    private double practiceGrades;
    @Column(name = "final_grades")
    private double finalGrades;
    private String evaluate;
    private String semester;
    @ManyToOne
    @JoinColumn(name = "lecture_theory_id")
    private User lectureTheoryId;
    @ManyToOne
    @JoinColumn(name = "lecture_practice_id")
    private User lecturePracticeId;
}
