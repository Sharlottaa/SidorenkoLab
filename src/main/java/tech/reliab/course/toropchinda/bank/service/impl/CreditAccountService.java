package main.java.tech.reliab.course.toropchinda.bank.service.impl;
import main.java.tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import main.java.tech.reliab.course.toropchinda.bank.entity.User;
import main.java.tech.reliab.course.toropchinda.bank.entity.Employee;
import main.java.tech.reliab.course.toropchinda.bank.entity.PaymentAccount;

import java.util.Date;

public interface CreditAccountService {

    default CreditAccount createCreditAccount(int id, User user, String bankName, Date startDate, Date endDate, int months,
                                              double creditAmount, double monthlyPayment, double interestRate,
                                              Employee employee, PaymentAccount paymentAccount) {
        return new CreditAccount(id, user, bankName, startDate, endDate, months, creditAmount, monthlyPayment,
                interestRate, employee, paymentAccount);
    }


    // Получает информацию о кредитном счете.
    default String readCreditAccount(CreditAccount creditAccount) {
        return "ID кредитного счета: " + creditAccount.getId_creditAccount() + "\n" +
                "Пользователь: " + creditAccount.getUser().getFullName() + "\n" +
                "Название банка: " + creditAccount.getBankName() + "\n" +
                "Дата начала кредита: " + creditAccount.getStartDate() + "\n" +
                "Дата окончания кредита: " + creditAccount.getEndDate() + "\n" +
                "Количество месяцев: " + creditAccount.getMonths() + "\n" +
                "Сумма кредита: " + creditAccount.getCreditAmount() + "\n" +
                "Ежемесячный платеж: " + creditAccount.getMonthlyPayment() + "\n" +
                "Процентная ставка: " + creditAccount.getInterestRate() + "\n" +
                "Сотрудник, выдавший кредит: " + creditAccount.getEmployee().getFullName() + "\n" +
                "Платежный счет: " + creditAccount.getPaymentAccount().getId_paymentAccount();
    }

    // Обновляет информацию о кредитном счете.

    default void updateCreditAccount(CreditAccount creditAccount, double newCreditAmount, double newMonthlyPayment,
                                     double newInterestRate) {
        creditAccount.setCreditAmount(newCreditAmount);
        creditAccount.setMonthlyPayment(newMonthlyPayment);
        creditAccount.setInterestRate(newInterestRate);
    }

    // Удаляет кредитный счет.

    default String deleteCreditAccount(CreditAccount creditAccount) {
        return "Кредитный счет с ID: " + creditAccount.getId_creditAccount() + " был успешно удален.";
    }

    /**
     * Погашает ежемесячный платеж по кредиту.
     * @param creditAccount Кредитный счет
     * @param amount Сумма платежа
     * @return Сообщение о погашении платежа
     */
    default String payMonthlyPayment(CreditAccount creditAccount, double amount) {
        PaymentAccount paymentAccount = creditAccount.getPaymentAccount();
        if (paymentAccount.getBalance() >= amount) {
            paymentAccount.setBalance(paymentAccount.getBalance() - amount);
            return "Ежемесячный платеж по кредиту на сумму " + amount + " успешно погашен.";
        } else {
            return "Недостаточно средств на счету для погашения платежа.";
        }
    }

    // Проверяет, погашен ли кредит полностью.
    default boolean isCreditPaidOff(CreditAccount creditAccount) {
        return creditAccount.getCreditAmount() <= 0;
    }
}

