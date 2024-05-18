package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.models.CourseSection;

import java.util.List;

@Repository
public interface CourseSectionRepository extends JpaRepository<CourseSection, Long> {
    @Query(value = "SELECT coss.id, coss.section_code, co.name, coss.class_name, coss.status \n" +
            "FROM course_sections AS coss INNER JOIN courses AS co ON co.id = coss.course_id \n" +
            "WHERE co.id = :majorId AND coss.`status` = 0", nativeQuery = true)
    List<Object[]> findCourseSectionsByMajorId(Long majorId);

    @Query(value = "SELECT coss.id,\n" +
            "       sch.day_of_week, \n" +
            "       sch.shift, \n" +
            "       sch.buildings, \n" +
            "       u.id AS lecture_id,\n" +
            "       u.full_name AS lectures,\n" +
            "       sch.`type`,\n" +
            "       sch.student_enrollment_number\n" +
            "FROM schedules AS sch \n" +
            "INNER JOIN course_sections AS coss ON sch.course_section_id = coss.id\n" +
            "INNER JOIN users AS u ON u.id = sch.lecture_id\n" +
            "WHERE coss.id = :courseSectionId\n" +
            "GROUP BY coss.id, sch.day_of_week, sch.shift, sch.buildings\n", nativeQuery = true)
    List<Object[]> findDetailCourseSectionsByCourseSectionId(Long courseSectionId);

    @Query(value = "SELECT coss.id, coss.section_code, co.name, coss.class_name, co.credits, lecture_theory.full_name AS lecture_theory, lecture_practice.full_name AS lecture_practice, coss.`status` FROM course_sections AS coss \n" +
            "INNER JOIN courses AS co ON co.id = coss.course_id\n" +
            "INNER JOIN grades AS grd ON coss.id = grd.course_section_id\n" +
            "INNER JOIN users AS lecture_theory ON lecture_theory.id = grd.lecture_theory_id\n" +
            "INNER JOIN users AS lecture_practice ON lecture_practice.id = grd.lecture_practice_id\n" +
            "WHERE grd.student_id = :studentId AND coss.semester = :semester", nativeQuery = true)
    List<Object[]> findCourseSectionsRegisteredByStudentIdAndSemester(Long studentId, String semester);
}
