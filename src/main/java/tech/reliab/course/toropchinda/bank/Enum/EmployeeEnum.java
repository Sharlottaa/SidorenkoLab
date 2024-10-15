package main.java.tech.reliab.course.toropchinda.bank.Enum;

public enum EmployeeEnum {
    MANAGER("Manager"),
    ANALYST("Analyst"),
    CLERK("Clerk");

    private final String position;

    EmployeeEnum(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}