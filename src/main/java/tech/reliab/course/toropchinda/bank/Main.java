package main.java.tech.reliab.course.toropchinda.bank;

import main.java.tech.reliab.course.toropchinda.bank.entity.*;
import main.java.tech.reliab.course.toropchinda.bank.service.*;
import main.java.tech.reliab.course.toropchinda.bank.service.impl.*;
import main.java.tech.reliab.course.toropchinda.bank.Enum.*;

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

        // Создание банков
        for (BankEnum bankEnum : BankEnum.values()) {
            Bank bank = bankService.createBank(bankEnum.ordinal() + 1, bankEnum.getBankName());

            List<Employee> employees = new ArrayList<>();  // Список для хранения сотрудников каждого банка

            // Создание офисов
            for (OfficeEnum officeEnum : OfficeEnum.values()) {
                BankOffice office = bankOfficeService.createOffice(officeEnum.ordinal() + 1, officeEnum.getOfficeName(), officeEnum.getOfficeAddress(), StatusEnum.ACTIVE.getStatus(), true, 0, true, true, true, 50000, 2000);
                bankService.increaseOfficeCount(bank);

                // Создание сотрудников
                for (EmployeeEnum employeeEnum : EmployeeEnum.values()) {
                    Employee employee = employeeService.createEmployee(employeeEnum.ordinal() + 1, "Employee " + (employeeEnum.ordinal() + 1), new Date(), employeeEnum.getPosition(), bank, false, office, true, 50000);
                    employees.add(employee);  // Добавляем сотрудников в список
                    bankService.increaseEmployeeCount(bank);
                }

                // Создание банкоматов
                for (AtmEnum atmEnum : AtmEnum.values()) {
                    BankAtm atm = atmService.createAtm(atmEnum.ordinal() + 1, atmEnum.getAtmName(), office.getAddress_office(), StatusEnum.ACTIVE.getStatus(), bank, office, null, true, true, 10000, 500);
                    bankService.increaseAtmCount(bank);
                }
            }

            // Создание клиентов
            for (UserEnum userEnum : UserEnum.values()) {
                User user = userService.createUser(userEnum.ordinal() + 1, userEnum.getFullName(), userEnum.getBirthDate(), userEnum.getPlaceOfWork());
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

        // Вывод информации по всем клиентам
        for (UserEnum userEnum : UserEnum.values()) {
            System.out.println("Клиент: " + userEnum.getFullName());
        }
    }
}
