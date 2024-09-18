package main.java.tech.reliab.course.toropchinda.bank.service;

import main.java.tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import main.java.tech.reliab.course.toropchinda.bank.entity.User;

public interface PaymentAccountService {

    // Создает новый платежный счет.
    PaymentAccount createPaymentAccount(int id, User user, String bankName, double initialBalance);

    // Получает информацию о платежном счете
    String readPaymentAccount(PaymentAccount paymentAccount);

    // Обновляет информацию о платежном счете.
    void updatePaymentAccount(PaymentAccount paymentAccount, double newBalance);

    //Удаляет платежный счет.
    String deletePaymentAccount(PaymentAccount paymentAccount);

    // Добавляет деньги на платежный счет
    void deposit(PaymentAccount paymentAccount, double amount);

    //Снимает деньги с платежного счета
    void withdraw(PaymentAccount paymentAccount, double amount);


}
