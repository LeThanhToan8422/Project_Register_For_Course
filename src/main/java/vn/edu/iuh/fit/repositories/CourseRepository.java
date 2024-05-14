package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.models.Curriculum;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "SELECT \n" +
            "    cucr.course_id, \n" +
            "    co.course_code, \n" +
            "    co.name, \n" +
            "    IF(co.prerequisite_id IS NOT NULL, prereq.course_code, 0) AS has_prerequisite, \n" +
            "    co.credits,\n" +
            "    co.type_course\n" +
            "FROM \n" +
            "    curriculums AS cu \n" +
            "INNER JOIN curriculum_courses AS cucr ON cu.id = cucr.curriculum_id\n" +
            "INNER JOIN courses AS co ON co.id = cucr.course_id\n" +
            "LEFT JOIN courses AS prereq ON co.prerequisite_id = prereq.id\n" +
            "WHERE \n" +
            "    cu.major_id = :majorId AND cucr.course_id NOT IN (SELECT grd.course_id FROM grades AS grd WHERE grd.student_id = :studentId)\n", nativeQuery = true)
    List<Object[]> findCourseByStudentIdAndMajorId(Long studentId, Long majorId);
}
