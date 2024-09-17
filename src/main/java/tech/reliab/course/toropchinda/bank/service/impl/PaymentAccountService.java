package main.java.tech.reliab.course.toropchinda.bank.service.impl;

import main.java.tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import main.java.tech.reliab.course.toropchinda.bank.entity.User;

public interface PaymentAccountService {

    // Создает новый платежный счет.
    default PaymentAccount createPaymentAccount(int id, User user, String bankName, double initialBalance) {
        return new PaymentAccount(id, user, bankName, initialBalance);
    }

    // Получает информацию о платежном счете.
    default String readPaymentAccount(PaymentAccount paymentAccount) {
        return "ID платежного счета: " + paymentAccount.getId_paymentAccount() + "\n" +
                "Пользователь: " + paymentAccount.getUser().getFullName() + "\n" +
                "Название банка: " + paymentAccount.getBankName() + "\n" +
                "Баланс счета: " + paymentAccount.getBalance();
    }

    // Обновляет информацию о платежном счете.
    default void updatePaymentAccount(PaymentAccount paymentAccount, double newBalance) {
        paymentAccount.setBalance(newBalance);
    }

    // Удаляет платежный счет.
    default String deletePaymentAccount(PaymentAccount paymentAccount) {
        return "Платежный счет с ID: " + paymentAccount.getId_paymentAccount() + " был успешно удален.";
    }

    // Добавляет деньги на платежный счет.
    default void deposit(PaymentAccount paymentAccount, double amount) {
        paymentAccount.setBalance(paymentAccount.getBalance() + amount);
    }

    /**
     * Снимает деньги с платежного счета.
     * @param paymentAccount Платежный счет
     * @param amount Сумма для снятия
     */
    default void withdraw(PaymentAccount paymentAccount, double amount) {
        double currentBalance = paymentAccount.getBalance();
        if (currentBalance >= amount) {
            paymentAccount.setBalance(currentBalance - amount);
        } else {
            System.out.println("Недостаточно средств на счете.");
        }
    }

    //Проверяет баланс платежного счета.
    default double checkBalance(PaymentAccount paymentAccount) {
        return paymentAccount.getBalance();
    }
}
