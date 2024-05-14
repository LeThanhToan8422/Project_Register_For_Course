package vn.edu.iuh.fit.enums;

public enum TypeUser {
    STUDENT(0),
    LECTURE(1);
    private int type;

    TypeUser(int type) {
        this.type = type;
    }
}
