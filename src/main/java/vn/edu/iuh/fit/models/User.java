package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.enums.StatusUser;
import vn.edu.iuh.fit.enums.TypeUser;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private boolean gender;
    private LocalDate dob;
    private String email;
    private String phone;
    private String address;
    @Column(name = "class")
    private String classCode;
    @Column(name = "course_year")
    private String courseYear;
    @Column(name = "enroll_time")
    private LocalDate enrollTime;
    private TypeUser type;
    private StatusUser status;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major majorId;
    @OneToMany(mappedBy = "studentId")
    @JsonIgnore
    private List<Grades> grades;
    @OneToMany(mappedBy = "lectureTheoryId")
    @JsonIgnore
    private List<Grades> gradeLectureTheories;
    @OneToMany(mappedBy = "lecturePracticeId")
    @JsonIgnore
    private List<Grades> gradeLecturePractices;
    @OneToMany(mappedBy = "lectureId")
    @JsonIgnore
    private List<Schedule> schedules;
}
