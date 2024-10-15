package main.java.tech.reliab.course.toropchinda.bank.Enum;

public enum StatusEnum {
    ACTIVE("Работает"),
    INACTIVE("Не работает");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}