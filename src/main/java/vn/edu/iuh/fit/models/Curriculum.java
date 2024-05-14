package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "curriculums")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int semester;
    private int credits;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major majorId;
    @OneToMany(mappedBy = "curriculumId")
    private List<Curriculum_Course> curriculumCourses;

}
