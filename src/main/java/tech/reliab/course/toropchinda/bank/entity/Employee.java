package main.java.tech.reliab.course.toropchinda.bank.entity;


import java.util.Date;

/**
 * Класс, представляющий сотрудника банка.
 */
public class Employee {

    // Уникальный идентификатор сотрудника
    private int id_employee;

    // ФИО сотрудника
    private String fullName;

    // Дата рождения сотрудника
    private Date birthDate;

    // Должность сотрудника
    private String position;

    // Банк, в котором работает сотрудник
    private Bank bank;

    // Работает ли в банковском офисе или удаленно
    private boolean isRemote;

    // Офис банка, в котором работает сотрудник
    private BankOffice bankOffice;

    // Может ли сотрудник выдавать кредиты
    private boolean canIssueLoans;

    // Размер зарплаты сотрудника
    private double salary;

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public boolean isCanIssueLoans() {
        return canIssueLoans;
    }

    public void setCanIssueLoans(boolean canIssueLoans) {
        this.canIssueLoans = canIssueLoans;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
