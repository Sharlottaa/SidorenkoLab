package main.java.tech.reliab.course.toropchinda.bank;

import main.java.tech.reliab.course.toropchinda.bank.entity.*;
import main.java.tech.reliab.course.toropchinda.bank.service.*;
import main.java.tech.reliab.course.toropchinda.bank.service.impl.*;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
// Инициализация банка
        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.createBank(1, "Bank of Future");

        // Инициализация офиса банка
        BankOfficeService bankOfficeService = new BankOfficeService() {};
        BankOffice bankOffice = bankOfficeService.createOffice(1, "Main Office", "123 Main Street", "Работает", true, 1, true, true, true, 500000, 10000);

        // Инициализация сотрудника
        EmployeeService employeeService = new EmployeeService() {};
        Employee employee = employeeService.createEmployee(1, "Иван Иванов", new Date(), "Кассир", bank, false, bankOffice, true, 50000);

        // Инициализация банкомата с указанием сотрудника
        AtmService atmService = new AtmService() {};
        BankAtm atm = atmService.createAtm(1, "ATM-1", "123 Main Street", "Работает", bank, bankOffice, employee, true, true, 50000, 1000);

        // Инициализация клиента
        UserService userService = new UserService() {};
        User user = userService.createUser(1, "Андрей Петров", "01.01.1990", "Tech Inc.");

        // Инициализация платежного счета
        PaymentAccountService paymentAccountService = new PaymentAccountService() {};
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(1, user, "Bank of Future", 10000);

        // Инициализация кредитного счета
        CreditAccountService creditAccountService = new CreditAccountService() {};
        CreditAccount creditAccount = creditAccountService.createCreditAccount(1, user, "Bank of Future", new Date(), new Date(), 12, 100000, 8500, 10, employee, paymentAccount);

        // Увеличение количества сотрудников, клиентов и банкоматов в банке
        bankService.increaseEmployeeCount(bank);
        bankService.increaseClientCount(bank);
        bankService.increaseAtmCount(bank);
        bankService.increaseOfficeCount(bank);

        // Вывод в консоль всех сущностей
        System.out.println("Банк: " + bankService.readBank(bank));
        System.out.println("Офис банка: " + bankOfficeService.readOffice(bankOffice));
        System.out.println("Банкомат: " + atmService.readAtm(atm));
        System.out.println("Сотрудник: " + employeeService.readEmployee(employee));
        System.out.println("Клиент: " + userService.readUser(user));
        System.out.println("Платежный счет: " + paymentAccountService.readPaymentAccount(paymentAccount));
        System.out.println("Кредитный счет: " + creditAccountService.readCreditAccount(creditAccount));
    }
}