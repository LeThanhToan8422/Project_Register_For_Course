package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.enums.TypeCourse;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "course_code")
    private String courseCode;
    private long credits;
    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private Course prerequisiteId;
    @OneToMany(mappedBy = "prerequisiteId")
    private List<Course> prerequisites;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major majorId;
    @OneToMany(mappedBy = "courseId")
    private List<CourseSection> courseSections;
    @OneToMany(mappedBy = "courseId")
    private List<Curriculum_Course> curriculumCourses;
    @OneToMany(mappedBy = "courseId")
    private List<Grades> grades;
    @Column(name = "type_course")
    private TypeCourse typeCourse;

}
