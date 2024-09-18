package main.java.tech.reliab.course.toropchinda.bank.service.impl;
import main.java.tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import main.java.tech.reliab.course.toropchinda.bank.entity.User;
import main.java.tech.reliab.course.toropchinda.bank.entity.Employee;
import main.java.tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import main.java.tech.reliab.course.toropchinda.bank.service.CreditAccountService;

import java.util.Date;

public class CreditAccountServiceImpl implements CreditAccountService {

    @Override
    public CreditAccount createCreditAccount(int id, User user, String bankName, Date startDate, Date endDate, int months,
                                             double creditAmount, double monthlyPayment, double interestRate,
                                             Employee employee, PaymentAccount paymentAccount) {
        if (creditAmount <= 0 || monthlyPayment <= 0 || interestRate < 0) {
            throw new IllegalArgumentException("Сумма кредита, ежемесячный платеж и процентная ставка должны быть положительными.");
        }
        if (months <= 0) {
            throw new IllegalArgumentException("Количество месяцев должно быть положительным.");
        }

        CreditAccount creditAccount = new CreditAccount();
        creditAccount.setId_creditAccount(id);
        creditAccount.setUser(user);
        creditAccount.setBankName(bankName);
        creditAccount.setStartDate(startDate);
        creditAccount.setEndDate(endDate);
        creditAccount.setMonths(months);
        creditAccount.setCreditAmount(creditAmount);
        creditAccount.setMonthlyPayment(monthlyPayment);
        creditAccount.setInterestRate(interestRate);
        creditAccount.setEmployee(employee);
        creditAccount.setPaymentAccount(paymentAccount);

        return creditAccount;
    }

    @Override
    public String readCreditAccount(CreditAccount creditAccount) {
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

    @Override
    public void updateCreditAccount(CreditAccount creditAccount, double newCreditAmount, double newMonthlyPayment,
                                    double newInterestRate) {
        if (newCreditAmount < 0 || newMonthlyPayment < 0 || newInterestRate < 0) {
            throw new IllegalArgumentException("Сумма кредита, ежемесячный платеж и процентная ставка не могут быть отрицательными.");
        }
        creditAccount.setCreditAmount(newCreditAmount);
        creditAccount.setMonthlyPayment(newMonthlyPayment);
        creditAccount.setInterestRate(newInterestRate);
    }

    @Override
    public String deleteCreditAccount(CreditAccount creditAccount) {
        return "Кредитный счет с ID: " + creditAccount.getId_creditAccount() + " был успешно удален.";
    }

    @Override
    public String payMonthlyPayment(CreditAccount creditAccount, double amount) {
        PaymentAccount paymentAccount = creditAccount.getPaymentAccount();
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма платежа не может быть отрицательной.");
        }
        if (paymentAccount.getBalance() >= amount) {
            paymentAccount.setBalance(paymentAccount.getBalance() - amount);
            return "Ежемесячный платеж по кредиту на сумму " + amount + " успешно погашен.";
        } else {
            throw new IllegalStateException("Недостаточно средств на счету для погашения платежа.");
        }
    }

    @Override
    public boolean isCreditPaidOff(CreditAccount creditAccount) {
        return creditAccount.getCreditAmount() <= 0;
    }
}
