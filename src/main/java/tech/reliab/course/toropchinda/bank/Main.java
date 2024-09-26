package main.java.tech.reliab.course.toropchinda.bank;

import main.java.tech.reliab.course.toropchinda.bank.entity.*;
import main.java.tech.reliab.course.toropchinda.bank.service.*;
import main.java.tech.reliab.course.toropchinda.bank.service.impl.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Создание сервисов
        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        AtmService atmService = new BankAtmServiceImpl();
        UserService userService = new UserServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();

        // Создание 5 банков
        for (int i = 1; i <= 5; i++) {
            Bank bank = bankService.createBank(i, "Bank " + i);

            List<Employee> employees = new ArrayList<>();  // Список для хранения сотрудников каждого банка

            // Создание 3 офисов для каждого банка
            for (int j = 1; j <= 3; j++) {
                BankOffice office = bankOfficeService.createOffice(j, "Office " + j, "Address " + j, "Работает", true, 0, true, true, true, 50000, 2000);
                bankService.increaseOfficeCount(bank);

                // Создание 5 сотрудников в каждом офисе
                for (int k = 1; k <= 5; k++) {
                    Employee employee = employeeService.createEmployee(k, "Employee " + k, new Date(), "Manager", bank, false, office, true, 50000);
                    employees.add(employee);  // Добавляем сотрудников в список
                    bankService.increaseEmployeeCount(bank);
                }

                // Создание 3 банкоматов для каждого банка
                for (int m = 1; m <= 3; m++) {
                    BankAtm atm = atmService.createAtm(m, "ATM " + m, office.getAddress_office(), "Работает", bank, office, null, true, true, 10000, 500);
                    bankService.increaseAtmCount(bank);
                }
            }

            // Создание 5 клиентов для каждого банка
            for (int c = 1; c <= 5; c++) {
                User user = userService.createUser(c, "User " + c, "01.01.1980", "Company " + c);
                bankService.increaseClientCount(bank);

                // Создание 2 платежных счетов для каждого клиента
                List<PaymentAccount> paymentAccounts = new ArrayList<>();
                for (int p = 1; p <= 2; p++) {
                    PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(p, user, bank.getName_bank(), 1000 * p);
                    paymentAccounts.add(paymentAccount);  // Добавляем платежные счета в список
                    userService.addPaymentAccountToUser(user, paymentAccount);
                }

                // Создание 2 кредитных счетов для каждого клиента
                for (int cr = 1; cr <= 2; cr++) {
                    // Назначаем случайного сотрудника и платежный счет
                    Employee creditEmployee = employees.get(new Random().nextInt(employees.size()));
                    PaymentAccount creditPaymentAccount = paymentAccounts.get(new Random().nextInt(paymentAccounts.size()));

                    CreditAccount creditAccount = creditAccountService.createCreditAccount(cr, user, bank.getName_bank(), new Date(), new Date(), 12, 10000 * cr, 1000, 5, creditEmployee, creditPaymentAccount);
                    userService.addCreditAccountToUser(user, creditAccount);
                }

                // Вывод информации по всем счетам клиента
                System.out.println("Клиент: " + user.getFullName());
                System.out.println("Платежные счета: ");
                for (PaymentAccount pa : user.getPaymentAccounts()) {
                    System.out.println(paymentAccountService.readPaymentAccount(pa));
                }

                System.out.println("Кредитные счета: ");
                for (CreditAccount ca : user.getCreditAccounts()) {
                    System.out.println(creditAccountService.readCreditAccount(ca));
                }
            }

            // Вывод информации по банку
            System.out.println(bankService.readBank(bank));
        }
    }
}
