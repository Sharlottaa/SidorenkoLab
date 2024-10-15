package main.java.tech.reliab.course.toropchinda.bank.Enum;

public enum UserEnum {
    USER_1("User 1", "01.01.1980", "Company 1"),
    USER_2("User 2", "02.02.1980", "Company 2");

    private final String fullName;
    private final String birthDate;
    private final String placeOfWork;

    UserEnum(String fullName, String birthDate, String placeOfWork) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }
}