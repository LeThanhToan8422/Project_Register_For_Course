package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Curriculum;
import vn.edu.iuh.fit.models.Grades;
import vn.edu.iuh.fit.models.Schedule;
import vn.edu.iuh.fit.responses.ResponesSchedule;

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

    @Query(value = "SELECT COUNT(*) FROM schedules AS sch1\n" +
            "WHERE sch1.course_section_id = :courseSectionId AND ((sch1.lecture_id = :lectureTheoryId AND sch1.`type` = 'LT') OR (sch1.lecture_id = :lecturePracticeId AND sch1.`type` = 'TH'))\n" +
            "AND (\n" +
            "\tSELECT sch2.id FROM schedules AS sch2 INNER JOIN grades AS grd ON sch2.course_section_id = grd.course_section_id\n" +
            "\tWHERE grd.semester = :semester AND grd.student_id = :studentId \n" +
            "\tAND (grd.lecture_theory_id = sch2.lecture_id OR grd.lecture_practice_id = sch2.lecture_id)\n" +
            "\tAND sch1.day_of_week = sch2.day_of_week AND sch1.shift = sch2.shift\n" +
            "\tORDER BY sch2.day_of_week\n" +
            ")", nativeQuery = true)
    List<Object[]> findScheduleByStudentIdSemesterLectureTheoryAndLecturePractice(Long courseSectionId, Long lectureTheoryId, Long lecturePracticeId, String semester, Long studentId);

    @Query(value = "SELECT sch.id, co.name, sch.day_of_week, sch.shift, sch.buildings, sch.`type`, u.full_name, css.start_time, css.end_time FROM schedules AS sch \n" +
            "INNER JOIN grades AS grd ON sch.course_section_id = grd.course_section_id\n" +
            "INNER JOIN course_sections AS css ON sch.course_section_id = css.id\n" +
            "INNER JOIN courses AS co ON css.course_id = co.id\n" +
            "INNER JOIN users AS u ON u.id = sch.lecture_id\n" +
            "WHERE grd.student_id = :studentId\n" +
            "AND (grd.lecture_theory_id = sch.lecture_id OR grd.lecture_practice_id = sch.lecture_id)\n" +
            "ORDER BY css.start_time, sch.day_of_week, sch.shift ASC", nativeQuery = true)
    List<Object[]> findScheduleByStudentId(Long studentId);
}
