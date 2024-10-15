package main.java.tech.reliab.course.toropchinda.bank.Enum;

public enum BankEnum {
    BANK_1("Bank 1"),
    BANK_2("Bank 2"),
    BANK_3("Bank 3"),
    BANK_4("Bank 4"),
    BANK_5("Bank 5");

    private final String bankName;

    BankEnum(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }
}
