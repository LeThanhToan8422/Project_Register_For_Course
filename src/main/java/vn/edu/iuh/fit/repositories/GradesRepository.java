package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.IdClass.GradeId;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.Grades;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradesRepository extends JpaRepository<Grades, GradeId> {
    @Query(value = "SELECT SUM(co.credits) AS credits FROM grades AS grd\n" +
            "INNER JOIN courses AS co ON co.id = grd.course_id\n" +
            "WHERE grd.student_id = :studentId AND grd.semester = :semester", nativeQuery = true)
    List<Object[]> findCreditsOfSemesterByStudentId(Long studentId, String semester);
    @Query(value = "select g from Grades g where g.studentId.id = :studentId and g.courseId.id = :courseId")
    Grades findPrerequisiteByStudentIdAndCourseId(Long studentId, Long courseId);

    @Query(value = "SELECT css.id, css.section_code, co.name, co.credits, grd.theory_grades_1, grd.theory_grades_2, grd.theory_grades_3, grd.practice_grades_1, grd.practice_grades_2, grd.practice_grades_3, grd.midterm_grades, grd.final_grades, css.semester FROM grades AS grd\n" +
            "INNER JOIN courses AS co ON co.id = grd.course_id\n" +
            "INNER JOIN course_sections AS css ON css.id = grd.course_section_id\n" +
            "WHERE grd.student_id = :studentId\n" +
            "ORDER BY grd.semester, grd.course_section_id", nativeQuery = true)
    List<Object[]> findGradesByStudentId(Long studentId);
}
