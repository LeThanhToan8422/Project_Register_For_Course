package vn.edu.iuh.fit.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponesCourseSectionsRegistered {
    private String id;
    private String sectionCode;
    private String name;
    private String className;
    private String credits;
    private String lecture_theory;
    private String lecture_practice;
    private String status;
    private String startTime;
    private String endTime;
}
