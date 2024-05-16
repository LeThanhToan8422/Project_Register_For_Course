package vn.edu.iuh.fit.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponesCourseSection {
    private String id;
    private String sectionCode;
    private String name;
    private String className;
    private String status;
}
