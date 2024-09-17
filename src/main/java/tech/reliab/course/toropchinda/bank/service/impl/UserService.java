package main.java.tech.reliab.course.toropchinda.bank.service.impl;
import main.java.tech.reliab.course.toropchinda.bank.entity.User;
import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import main.java.tech.reliab.course.toropchinda.bank.entity.PaymentAccount;

import java.util.Random;

public interface UserService {
    // Создает нового клиента банка.
    default User createUser(int id, String fullName, String birthDate, String placeOfWork) {
        double monthlyIncome = new Random().nextDouble() * 10000; // Генерация дохода от 0 до 10 000
        int creditRating = calculateCreditRating(monthlyIncome);
        return new User(id, fullName, birthDate, placeOfWork, monthlyIncome, creditRating);
    }

    // Получает информацию о клиенте
    default String readUser(User user) {
        return "ID клиента: " + user.getId_user() + "\n" +
                "ФИО: " + user.getFullName() + "\n" +
                "Дата рождения: " + user.getBirthDate() + "\n" +
                "Место работы: " + user.getPlaceOfWork() + "\n" +
                "Ежемесячный доход: " + user.getMonthlyIncome() + "\n" +
                "Кредитный рейтинг: " + user.getCreditRating();
    }

    // Обновляет информацию о клиенте.
    default void updateUser(User user, String newPlaceOfWork, double newMonthlyIncome) {
        user.setPlaceOfWork(newPlaceOfWork);
        user.setMonthlyIncome(newMonthlyIncome);
        user.setCreditRating(calculateCreditRating(newMonthlyIncome)); // Обновляем кредитный рейтинг
    }

    // Удаляет клиента банка.
    default String deleteUser(User user) {
        return "Клиент с ID: " + user.getId_user() + " был успешно удален.";
    }

    // Добавляет новый банк к клиенту
    default void addBankToUser(User user, Bank bank) {
        user.addBank(bank);
    }

    /**
     * Добавляет кредитный счет к клиенту.
     * @param user Объект клиента
     * @param creditAccount Кредитный счет для добавления
     */
    default void addCreditAccountToUser(User user, CreditAccount creditAccount) {
        user.addCreditAccount(creditAccount);
    }

    // Добавляет платежный счет к клиенту
    default void addPaymentAccountToUser(User user, PaymentAccount paymentAccount) {
        user.addPaymentAccount(paymentAccount);
    }

    // Проверяет кредитный рейтинг клиента.
    default int checkCreditRating(User user) {
        return user.getCreditRating();
    }

    /**
     * Рассчитывает кредитный рейтинг на основе ежемесячного дохода.
     * @param monthlyIncome Ежемесячный доход клиента
     * @return Кредитный рейтинг
     */
    default int calculateCreditRating(double monthlyIncome) {
        if (monthlyIncome < 1000) {
            return 100;
        } else if (monthlyIncome < 2000) {
            return 200;
        } else if (monthlyIncome < 3000) {
            return 300;
        } else if (monthlyIncome < 4000) {
            return 400;
        } else if (monthlyIncome < 5000) {
            return 500;
        } else if (monthlyIncome < 6000) {
            return 600;
        } else if (monthlyIncome < 7000) {
            return 700;
        } else if (monthlyIncome < 8000) {
            return 800;
        } else if (monthlyIncome < 9000) {
            return 900;
        } else {
            return 1000;
        }
    }
}

