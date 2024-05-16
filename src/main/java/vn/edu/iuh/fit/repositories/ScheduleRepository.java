package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Curriculum;
import vn.edu.iuh.fit.models.Schedule;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "UPDATE schedules AS sch \n" +
            "SET sch.student_enrollment_number = sch.student_enrollment_number + 1\n" +
            "WHERE sch.course_section_id = :courseSectionId AND sch.lecture_id = :lectureId AND sch.`type` = 'LT'", nativeQuery = true)
    void updateStudentEnrollmentNumberByTypeTheory(Long courseSectionId, Long lectureId);

    @Query(value = "UPDATE schedules AS sch \n" +
            "SET sch.student_enrollment_number = sch.student_enrollment_number + 1\n" +
            "WHERE sch.course_section_id = :courseSectionId AND sch.lecture_id = :lectureId AND sch.`type` = 'TH'", nativeQuery = true)
    void updateStudentEnrollmentNumberByTypePractice(Long courseSectionId, Long lectureId);

    @Query(value = "SELECT sch.student_enrollment_number FROM schedules AS sch\n" +
            "WHERE sch.course_section_id = :courseSectionId AND sch.`type` = 'LT'", nativeQuery = true)
    List<Object[]> findStudentEnrollmentNumbersByCourseSectionId(Long courseSectionId);
}
