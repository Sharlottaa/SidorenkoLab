package main.java.tech.reliab.course.toropchinda.bank.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий клиента банка.
 */
public class User {

    // Уникальный идентификатор клиента
    private int id_user;

    // ФИО клиента
    private String fullName;

    // Дата рождения клиента
    private String birthDate;

    // Место работы клиента
    private String placeOfWork;

    // Ежемесячный доход клиента (генерируется рандомно, но не более 10 000)
    private double monthlyIncome;

    // Список банков, которыми пользуется клиент
    private List<Bank> banks;

    // Список кредитных счетов клиента
    private List<CreditAccount> creditAccounts;

    // Список платежных счетов клиента
    private List<PaymentAccount> paymentAccounts;

    // Кредитный рейтинг для банка (генерируется рандомно)
    private int creditRating;

    // Конструктор
    public User(int id_user, String fullName, String birthDate, String placeOfWork, double monthlyIncome, int creditRating) {
        this.id_user = id_user;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.monthlyIncome = monthlyIncome;
        this.banks = new ArrayList<>();
        this.creditAccounts = new ArrayList<>();
        this.paymentAccounts = new ArrayList<>();
        this.creditRating = creditRating;
    }

    // Геттеры и сеттеры

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void addBank(Bank bank) {
        this.banks.add(bank);
    }

    public List<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public void addCreditAccount(CreditAccount creditAccount) {
        this.creditAccounts.add(creditAccount);
    }

    public List<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void addPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccounts.add(paymentAccount);
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }
}

