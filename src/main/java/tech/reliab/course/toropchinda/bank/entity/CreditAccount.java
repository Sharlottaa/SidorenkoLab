package main.java.tech.reliab.course.toropchinda.bank.entity;

import java.util.Date;

/**
 * Класс, представляющий кредитный счет.
 */
public class CreditAccount {

    // Уникальный идентификатор кредитного счета
    private int id_creditAccount;

    // Пользователь, который владеет этим кредитным счетом
    private User user;

    // Название банка, где взят кредит
    private String bankName;

    // Дата начала кредита
    private Date startDate;

    // Дата окончания кредита
    private Date endDate;

    // Количество месяцев, на которые взят кредит
    private int months;

    // Сумма кредита
    private double creditAmount;

    // Ежемесячный платеж
    private double monthlyPayment;

    // Процентная ставка
    private double interestRate;

    // Сотрудник, который выдал кредит
    private Employee employee;

    // Платежный счет, с которого будут погашаться платежи по кредиту
    private PaymentAccount paymentAccount;


    public int getId_creditAccount() {
        return id_creditAccount;
    }

    public void setId_creditAccount(int id_creditAccount) {
        this.id_creditAccount = id_creditAccount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
}
