package vn.edu.iuh.fit.enums;

public enum TypeCourse {
    ELECTIVE(0),
    OBLIGATE(1);
    private int type;

    TypeCourse(int type) {
        this.type = type;
    }
}
