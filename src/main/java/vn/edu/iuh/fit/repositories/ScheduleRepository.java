package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Curriculum;
import vn.edu.iuh.fit.models.Grades;
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

    @Query(value = "SELECT COUNT(*) FROM schedules AS sch\n" +
            "WHERE sch.course_section_id = :courseSectionId AND ((sch.lecture_id = :lectureTheoryId AND sch.`type` = 'LT') OR (sch.lecture_id = :lecturePracticeId AND sch.`type` = 'TH'))\n" +
            "AND sch.day_of_week IN (\n" +
            "\tSELECT sch.day_of_week FROM schedules AS sch INNER JOIN grades AS grd ON sch.course_section_id = grd.course_section_id\n" +
            "\tWHERE grd.semester = :semester AND grd.student_id = :studentId \n" +
            "\tAND (grd.lecture_theory_id = sch.lecture_id OR grd.lecture_practice_id = sch.lecture_id)\n" +
            ")\n" +
            "AND sch.shift IN (\n" +
            "\tSELECT sch.shift FROM schedules AS sch INNER JOIN grades AS grd ON sch.course_section_id = grd.course_section_id\n" +
            "\tWHERE grd.semester = :semester AND grd.student_id = :studentId \n" +
            "\tAND (grd.lecture_theory_id = sch.lecture_id OR grd.lecture_practice_id = sch.lecture_id)\n" +
            ")", nativeQuery = true)
    List<Object[]> findScheduleByStudentIdSemesterLectureTheoryAndLecturePractice(Long courseSectionId, Long lectureTheoryId, Long lecturePracticeId, String semester, Long studentId);
}
