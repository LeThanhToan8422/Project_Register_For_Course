package vn.edu.iuh.fit.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponesDetailCourseSection {
    private String id;
    private String dayOfWeek;
    private String shift;
    private String buildings;
    private String lectureId;
    private String lectures;
    private String type;
    private String studentEnrollmentNumbers;
}
