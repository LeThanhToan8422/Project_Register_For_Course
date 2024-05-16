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
}
