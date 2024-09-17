package main.java.tech.reliab.course.toropchinda.bank;

import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.service.impl.BankService;


public class Main {
    public static void main(String[] args) {


        BankService bankService = new BankService() {};
        Bank bank = new Bank(1, "MyBank");

//сотрудник
        bankService.increaseEmployeeCount(bank);

// клиент
        bankService.increaseClientCount(bank);
        bankService.increaseClientCount(bank);

        System.out.println("Количество сотрудников: " + bank.getCount_employee());
        System.out.println("Количество клиентов: " + bank.getCount_client());
    }
}