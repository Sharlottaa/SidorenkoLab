package main.java.tech.reliab.course.toropchinda.bank.service;
import main.java.tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import main.java.tech.reliab.course.toropchinda.bank.entity.User;
import main.java.tech.reliab.course.toropchinda.bank.entity.Employee;
import main.java.tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import java.util.Date;

import java.util.Date;

public interface CreditAccountService {

    // Создает кредитный счет
    CreditAccount createCreditAccount(int id, User user, String bankName, Date startDate, Date endDate, int months,
                                      double creditAmount, double monthlyPayment, double interestRate,
                                      Employee employee, PaymentAccount paymentAccount);

    // Получает информацию о кредитном счете
    String readCreditAccount(CreditAccount creditAccount);

    // Обновляет информацию о кредитном счете
    void updateCreditAccount(CreditAccount creditAccount, double newCreditAmount, double newMonthlyPayment,
                             double newInterestRate);

    // Удаляет кредитный счет
    String deleteCreditAccount(CreditAccount creditAccount);

    // Погашает ежемесячный платеж по кредиту
    String payMonthlyPayment(CreditAccount creditAccount, double amount);

    // Проверяет, погашен ли кредит полностью
    boolean isCreditPaidOff(CreditAccount creditAccount);
}

