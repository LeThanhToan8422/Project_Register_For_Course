package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.IdClass.Curriculum_Course_Id;

@Entity
@Table(name = "curriculum_courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(Curriculum_Course_Id.class)
public class Curriculum_Course {
    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courseId;
    @Id
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculumId;
    @Column(name = "theory_credits")
    private int theoryCredits;
    @Column(name = "practice_credits")
    private int practiceCredits;
    @Column(name = "number_of_theory_classes")
    private int numberOfTheoryClasses;
    @Column(name = "number_of_practice_classes")
    private int numberOfPracticeClasses;
    @Column(name = "self_selected_group")
    private int selfSelectedGroup;
    @Column(name = "required_number_of_credits")
    private int requiredNumberOfCredits;
}
