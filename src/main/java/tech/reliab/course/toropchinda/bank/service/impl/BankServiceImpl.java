package main.java.tech.reliab.course.toropchinda.bank.service.impl;
import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.service.BankService;

import java.util.Random;

public class BankServiceImpl implements BankService {

    @Override
    public Bank createBank(int id, String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название банка не может быть пустым или null");
        }

        Bank bank = new Bank();
        bank.setId_bank(id);
        bank.setName_bank(name);
        bank.setRating_bank(new Random().nextInt(101)); // Рейтинг от 0 до 100
        bank.setTotal_money(new Random().nextDouble() * 1000000); // Деньги до 1 000 000
        bank.setInterest_rate(calculateInterestRate(bank.getRating_bank())); // Процентная ставка
        return bank;
    }

    private double calculateInterestRate(int rating) {
        double maxRate = 20.0; // Максимальная ставка
        double minRate = 2.0;  // Минимальная ставка
        return maxRate - ((rating / 100.0) * (maxRate - minRate));
    }

    @Override
    public String readBank(Bank bank) {
        return "ID банка: " + bank.getId_bank() + "\n" +
                "Имя банка: " + bank.getName_bank() + "\n" +
                "Количество офисов: " + bank.getCount_office() + "\n" +
                "Количество банкоматов: " + bank.getCount_atm() + "\n" +
                "Количество сотрудников: " + bank.getCount_employee() + "\n" +
                "Количество клиентов: " + bank.getCount_client() + "\n" +
                "Рейтинг банка: " + bank.getRating_bank() + "\n" +
                "Всего денег в банке: " + bank.getTotal_money() + "\n" +
                "Процентная ставка: " + bank.getInterest_rate();
    }

    @Override
    public void updateBank(Bank bank, String newName, double newTotalMoney) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Новое имя банка не может быть пустым или null");
        }

        if (newTotalMoney < 0 || newTotalMoney > 1000000) {
            throw new IllegalArgumentException("Сумма денег должна быть в пределах от 0 до 1 000 000.");
        }

        bank.setName_bank(newName);
        bank.setTotal_money(newTotalMoney);
    }

    @Override
    public String deleteBank(Bank bank) {
        return "Банк с ID: " + bank.getId_bank() + " был успешно удален.";
    }

    @Override
    public void increaseAtmCount(Bank bank) {
        bank.setCount_atm(bank.getCount_atm() + 1);
    }

    @Override
    public void increaseOfficeCount(Bank bank) {
        bank.setCount_office(bank.getCount_office() + 1);
    }

    @Override
    public void increaseEmployeeCount(Bank bank) {
        bank.setCount_employee(bank.getCount_employee() + 1);
    }

    @Override
    public void increaseClientCount(Bank bank) {
        bank.setCount_client(bank.getCount_client() + 1);
    }
}
