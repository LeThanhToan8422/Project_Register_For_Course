package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.enums.Classes;

@Entity
@Table(name = "lecture_course_sections")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@IdClass(Lecture_Course_Section_Id.class)
public class Lecture_Course_Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private User lectureId;
    @ManyToOne
    @JoinColumn(name = "course_section_id")
    private CourseSection courseSectionId;
    private Classes clss;
}
