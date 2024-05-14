package vn.edu.iuh.fit.enums;

public enum DayOfWeek {
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);
    private int day;

    DayOfWeek(int day) {
        this.day = day;
    }
}
