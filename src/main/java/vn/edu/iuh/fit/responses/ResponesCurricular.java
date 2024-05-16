package vn.edu.iuh.fit.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponesCurricular {
    private String id;
    private String courseCode;
    private String name;
    private String hasPrerequisite;
    private String credits;
    private String number_of_theory_classes;
    private String number_of_practice_classes;
    private String semester;
    private String result;
}
