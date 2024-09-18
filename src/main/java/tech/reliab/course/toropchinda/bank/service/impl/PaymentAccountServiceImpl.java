package main.java.tech.reliab.course.toropchinda.bank.service.impl;

import main.java.tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import main.java.tech.reliab.course.toropchinda.bank.entity.User;
import main.java.tech.reliab.course.toropchinda.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    @Override
    public PaymentAccount createPaymentAccount(int id, User user, String bankName, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным.");
        }

        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setId_paymentAccount(id);
        paymentAccount.setUser(user);
        paymentAccount.setBankName(bankName);
        paymentAccount.setBalance(initialBalance);

        return paymentAccount;
    }

    @Override
    public String readPaymentAccount(PaymentAccount paymentAccount) {
        return "ID платежного счета: " + paymentAccount.getId_paymentAccount() + "\n" +
                "Пользователь: " + paymentAccount.getUser().getFullName() + "\n" +
                "Название банка: " + paymentAccount.getBankName() + "\n" +
                "Баланс счета: " + paymentAccount.getBalance();
    }

    @Override
    public void updatePaymentAccount(PaymentAccount paymentAccount, double newBalance) {
        if (newBalance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным.");
        }
        paymentAccount.setBalance(newBalance);
    }

    @Override
    public String deletePaymentAccount(PaymentAccount paymentAccount) {
        return "Платежный счет с ID: " + paymentAccount.getId_paymentAccount() + " был успешно удален.";
    }

    @Override
    public void deposit(PaymentAccount paymentAccount, double amount) {
        paymentAccount.setBalance(paymentAccount.getBalance() + amount);
    }

    @Override
    public void withdraw(PaymentAccount paymentAccount, double amount) {
        double currentBalance = paymentAccount.getBalance();
        if (amount < 0) {
            throw new IllegalArgumentException("Снимаемая сумма не может быть отрицательной.");
        }
        if (currentBalance >= amount) {
            paymentAccount.setBalance(currentBalance - amount);
        } else {
            throw new IllegalStateException("Недостаточно средств на счете для совершения операции.");
        }
    }

}
