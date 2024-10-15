package main.java.tech.reliab.course.toropchinda.bank.Enum;

public enum AtmEnum {
    ATM_1("ATM 1"),
    ATM_2("ATM 2"),
    ATM_3("ATM 3");

    private final String atmName;

    AtmEnum(String atmName) {
        this.atmName = atmName;
    }

    public String getAtmName() {
        return atmName;
    }
}