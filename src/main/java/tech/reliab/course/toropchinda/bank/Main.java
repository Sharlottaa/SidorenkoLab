package main.java.tech.reliab.course.toropchinda.bank;

import main.java.tech.reliab.course.toropchinda.bank.entity.*;
import main.java.tech.reliab.course.toropchinda.bank.service.*;
import main.java.tech.reliab.course.toropchinda.bank.service.impl.*;

import java.util.Date;


public class Main {

    public static void main(String[] args) {

        // Создаем объекты сервисов
        BankServiceImpl bankService = new BankServiceImpl();
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        BankAtmServiceImpl bankAtmService = new BankAtmServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();

        // Создаем новый банк
        Bank bank = bankService.createBank(1, "Tech Bank");
        System.out.println("Создан банк:");
        System.out.println(bankService.readBank(bank));

        // Создаем офис банка
        BankOffice bankOffice = bankOfficeService.createOffice(1, "Main Office", "123 Main St", "Работает", true, 5, true, true, true, 50000, 20000);
        System.out.println("\nСоздан банковский офис:");
        System.out.println(bankOfficeService.readOffice(bankOffice));

        // Создаем банкомат
        BankAtm bankAtm = bankAtmService.createAtm(1, "ATM 001", "123 Main St", "Работает", bank, bankOffice, null, true, true, 20000, 1000);
        System.out.println("\nСоздан банкомат:");
        System.out.println(bankAtmService.readAtm(bankAtm));

        // Создаем сотрудника
        Employee employee = employeeService.createEmployee(1, "Alice Smith", new Date(), "Менеджер", bank, false, bankOffice, true, 50000);
        System.out.println("\nСоздан сотрудник:");
        System.out.println(employeeService.readEmployee(employee));

        // Создаем пользователя
        User user = userService.createUser(1, "John Doe", "1990-01-01", "Software Engineer");
        System.out.println("\nСоздан пользователь:");
        System.out.println(userService.readUser(user));

        // Создаем платежный счет
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(1, user, "Tech Bank", 10000);
        System.out.println("\nСоздан платежный счет:");
        System.out.println(paymentAccountService.readPaymentAccount(paymentAccount));

        // Создаем кредитный счет
        CreditAccount creditAccount = creditAccountService.createCreditAccount(1, user, "Tech Bank", new Date(), new Date(), 12, 50000, 5000, 5.5, employee, paymentAccount);
        System.out.println("\nСоздан кредитный счет:");
        System.out.println(creditAccountService.readCreditAccount(creditAccount));
    }
}
