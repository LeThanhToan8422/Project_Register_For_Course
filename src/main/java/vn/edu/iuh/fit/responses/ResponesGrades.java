package vn.edu.iuh.fit.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponesGrades {
    private String id;
    private String sectionCode;
    private String name;
    private String credits;
    private String theoryGrades1;
    private String theoryGrades2;
    private String theoryGrades3;
    private String practiceGrades1;
    private String practiceGrades2;
    private String practiceGrades3;
    private String midtermGrades;
    private String finalGrades;
    private String semester;
}
