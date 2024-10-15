package main.java.tech.reliab.course.toropchinda.bank.Enum;

public enum OfficeEnum {
    OFFICE_1("Office 1", "Address 1"),
    OFFICE_2("Office 2", "Address 2"),
    OFFICE_3("Office 3", "Address 3");

    private final String officeName;
    private final String officeAddress;

    OfficeEnum(String officeName, String officeAddress) {
        this.officeName = officeName;
        this.officeAddress = officeAddress;
    }

    public String getOfficeName() {
        return officeName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

}
