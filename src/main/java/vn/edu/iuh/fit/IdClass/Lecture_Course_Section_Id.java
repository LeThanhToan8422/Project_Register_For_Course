package vn.edu.iuh.fit.IdClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Lecture_Course_Section_Id implements Serializable {
    private Long lectureId;
    private Long courseSectionId;
}
