package vn.edu.iuh.fit.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponesCourse {
    private String id;
    private String courseCode;
    private String name;
    private String hasPrerequisite;
    private String credits;
    private String typeCourse;
}
