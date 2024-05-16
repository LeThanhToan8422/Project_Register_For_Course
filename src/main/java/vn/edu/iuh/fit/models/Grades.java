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
    @Column(name = "midterm_grades")
    private double midtermGrades;
    @Column(name = "theory_grades_1")
    private double theoryGrades1;
    @Column(name = "theory_grades_2")
    private double theoryGrades2;
    @Column(name = "theory_grades_3")
    private double theoryGrades3;
    @Column(name = "practice_grades_1")
    private double practiceGrades1;
    @Column(name = "practice_grades_2")
    private double practiceGrades2;
    @Column(name = "practice_grades_3")
    private double practiceGrades3;
    @Column(name = "final_grades")
    private double finalGrades;
    private String result;
    private String semester;
    @ManyToOne
    @JoinColumn(name = "lecture_theory_id")
    private User lectureTheoryId;
    @ManyToOne
    @JoinColumn(name = "lecture_practice_id")
    private User lecturePracticeId;
}
