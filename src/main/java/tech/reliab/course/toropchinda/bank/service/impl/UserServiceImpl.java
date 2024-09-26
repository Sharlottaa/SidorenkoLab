package main.java.tech.reliab.course.toropchinda.bank.service.impl;
import main.java.tech.reliab.course.toropchinda.bank.entity.*;
import main.java.tech.reliab.course.toropchinda.bank.service.*;


import java.util.ArrayList;
import java.util.Random;

public class UserServiceImpl implements UserService {

    @Override
    public User createUser(int id, String fullName, String birthDate, String placeOfWork) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("ФИО не может быть пустым.");
        }

        double monthlyIncome = new Random().nextDouble() * 10000; // Генерация дохода от 0 до 10 000
        int creditRating = calculateCreditRating(monthlyIncome);

        User user = new User();
        user.setId_user(id);
        user.setFullName(fullName);
        user.setBirthDate(birthDate);
        user.setPlaceOfWork(placeOfWork);
        user.setMonthlyIncome(monthlyIncome);
        user.setCreditRating(creditRating);

        // Инициализация списков
        user.setBanks(new ArrayList<>());
        user.setCreditAccounts(new ArrayList<>());
        user.setPaymentAccounts(new ArrayList<>());

        return user;
    }


    @Override
    public int calculateCreditRating(double monthlyIncome) {
        double maxIncome = 10000; // Максимальный доход
        double maxRating = 1000;  // Максимальный кредитный рейтинг

        // Рассчитываем рейтинг как процент от максимального дохода
        int creditRating = (int) ((monthlyIncome / maxIncome) * maxRating);

        // Возвращаем рейтинг, но не меньше 100 (минимум)
        return Math.max(creditRating, 100);
    }

    @Override
    public String readUser(User user) {
        return "ID клиента: " + user.getId_user() + "\n" +
                "ФИО: " + user.getFullName() + "\n" +
                "Дата рождения: " + user.getBirthDate() + "\n" +
                "Место работы: " + user.getPlaceOfWork() + "\n" +
                "Ежемесячный доход: " + user.getMonthlyIncome() + "\n" +
                "Кредитный рейтинг: " + user.getCreditRating();
    }

    @Override
    public void updateUser(User user, String newPlaceOfWork, double newMonthlyIncome) {
        if (newMonthlyIncome < 0) {
            throw new IllegalArgumentException("Доход не может быть отрицательным.");
        }
        user.setPlaceOfWork(newPlaceOfWork);
        user.setMonthlyIncome(newMonthlyIncome);
        user.setCreditRating(calculateCreditRating(newMonthlyIncome));
    }

    @Override
    public String deleteUser(User user) {
        return "Клиент с ID: " + user.getId_user() + " был успешно удален.";
    }


    @Override
    public void addBankToUser(User user, Bank bank) {
        user.addBank(bank);
    }

    @Override
    public void addCreditAccountToUser(User user, CreditAccount creditAccount) {
        user.addCreditAccount(creditAccount);
    }

    @Override
    public void addPaymentAccountToUser(User user, PaymentAccount paymentAccount) {
        user.addPaymentAccount(paymentAccount);
    }
}
