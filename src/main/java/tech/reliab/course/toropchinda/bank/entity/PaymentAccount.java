package main.java.tech.reliab.course.toropchinda.bank.entity;
/**
 * Класс, представляющий платежный счет.
 */
public class PaymentAccount {

    // Уникальный идентификатор платежного счета
    private int id_paymentAccount;

    // Пользователь, который владеет этим платежным счетом
    private User user;

    // Название банка, где открыт счет
    private String bankName;

    // Сумма денег на счете (по умолчанию 0)
    private double balance;

    public int getId_paymentAccount() {
        return id_paymentAccount;
    }

    public void setId_paymentAccount(int id_paymentAccount) {
        this.id_paymentAccount = id_paymentAccount;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
