package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Curriculum;

import java.util.List;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
    @Query(value = "SELECT \n" +
            "    cucr.course_id, \n" +
            "    co.course_code, \n" +
            "    co.name, \n" +
            "    IF(co.prerequisite_id IS NOT NULL, prereq.course_code, 0) AS has_prerequisite, \n" +
            "    co.credits, \n" +
            "    cucr.number_of_theory_classes, \n" +
            "    cucr.number_of_practice_classes,\n" +
            "    cu.semester,\n" +
            "    IF(grd.student_id = :studentId AND grd.result IS NOT NULL, grd.result, NULL) AS result\n" +
            "FROM \n" +
            "    curriculums AS cu \n" +
            "INNER JOIN curriculum_courses AS cucr ON cu.id = cucr.curriculum_id\n" +
            "INNER JOIN courses AS co ON co.id = cucr.course_id\n" +
            "LEFT JOIN courses AS prereq ON co.prerequisite_id = prereq.id\n" +
            "LEFT JOIN grades AS grd ON grd.course_id = co.id\n" +
            "WHERE \n" +
            "    cu.major_id = :majorId", nativeQuery = true)
    List<Object[]> findCurriculumByStudentIdAndMajorId(Long studentId, Long majorId);
}
