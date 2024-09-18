package main.java.tech.reliab.course.toropchinda.bank.entity;


/**
 * Класс, представляющий банковский офис.
 */
public class BankOffice {

    // Уникальный идентификатор банковского офиса
    private int id_office;

    // Название офиса
    private String name_office;

    // Адрес офиса
    private String address_office;

    // Статус офиса (работает/не работает)
    private String status;

    // Можно ли разместить банкомат
    private boolean canPlaceAtm;

    // Количество банкоматов в офисе
    private int atm_count;

    // Можно ли оформить кредит
    private boolean canIssueLoans;

    // Работает ли на выдачу денег
    private boolean isCashWithdrawalAvailable;

    // Можно ли внести деньги
    private boolean isDepositAvailable;

    // Количество денег в офисе (зависит от денег в банке)
    private double moneyAvailable;

    // Стоимость аренды офиса
    private double rentalCost;


    public int getId_office() {
        return id_office;
    }

    public void setId_office(int id_office) {
        this.id_office = id_office;
    }

    public String getName_office() {
        return name_office;
    }

    public void setName_office(String name_office) {
        this.name_office = name_office;
    }

    public String getAddress_office() {
        return address_office;
    }

    public void setAddress_office(String address_office) {
        this.address_office = address_office;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCanPlaceAtm() {
        return canPlaceAtm;
    }

    public void setCanPlaceAtm(boolean canPlaceAtm) {
        this.canPlaceAtm = canPlaceAtm;
    }

    public int getAtm_count() {
        return atm_count;
    }

    public void setAtm_count(int atm_count) {
        this.atm_count = atm_count;
    }

    public boolean isCanIssueLoans() {
        return canIssueLoans;
    }

    public void setCanIssueLoans(boolean canIssueLoans) {
        this.canIssueLoans = canIssueLoans;
    }

    public boolean isCashWithdrawalAvailable() {
        return isCashWithdrawalAvailable;
    }

    public void setCashWithdrawalAvailable(boolean cashWithdrawalAvailable) {
        isCashWithdrawalAvailable = cashWithdrawalAvailable;
    }

    public boolean isDepositAvailable() {
        return isDepositAvailable;
    }

    public void setDepositAvailable(boolean depositAvailable) {
        isDepositAvailable = depositAvailable;
    }

    public double getMoneyAvailable() {
        return moneyAvailable;
    }

    public void setMoneyAvailable(double moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }
}
