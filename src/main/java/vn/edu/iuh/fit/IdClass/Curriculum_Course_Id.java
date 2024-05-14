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
public class Curriculum_Course_Id implements Serializable {
    private Long courseId;
    private Long curriculumId;
}
