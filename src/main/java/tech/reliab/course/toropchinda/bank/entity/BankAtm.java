package main.java.tech.reliab.course.toropchinda.bank.entity;
public class BankAtm {
    //  Id банкомата
    private int id_atm;

    // Имя банкомата
    private String name_atm;

    // Адрес банкомата (совпадает с адресом банковского офиса)
    private String address_atm;

    // Статус банкомата (работает/не работает/нет денег)
    private String status;

    // Банк, которому принадлежит банкомат
    private Bank bank;

    // Расположение банкомата (может быть только в банковском офисе)
    private BankOffice bankOffice;

    // Сотрудник, обслуживающий банкомат
    private Employee employee;

    // Работает ли на выдачу денег
    private boolean isCashWithdrawalAvailable;

    // Можно ли внести деньги
    private boolean isDepositAvailable;

    // Количество денег в банкомате (напрямую зависит от денег в банке)
    private double moneyAvailable;

    // Стоимость обслуживания банкомата
    private double maintenanceCost;

    // Конструктор банкомата
    public BankAtm(int id_atm, String name_atm, String address_atm, String status, Bank bank, BankOffice bankOffice,
                   Employee employee, boolean isCashWithdrawalAvailable, boolean isDepositAvailable, double moneyAvailable,
                   double maintenanceCost) {
        this.id_atm = id_atm;
        this.name_atm = name_atm;
        this.address_atm = address_atm;
        this.status = status;
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.employee = employee;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isDepositAvailable = isDepositAvailable;
        this.moneyAvailable = moneyAvailable;
        this.maintenanceCost = maintenanceCost;
    }


    public int getId_atm() {
        return id_atm;
    }

    public void setId_atm(int id_atm) {
        this.id_atm = id_atm;
    }

    public String getName_atm() {
        return name_atm;
    }

    public void setName_atm(String name_atm) {
        this.name_atm = name_atm;
    }

    public String getAddress_atm() {
        return address_atm;
    }

    public void setAddress_atm(String address_atm) {
        this.address_atm = address_atm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
}
