package main.java.tech.reliab.course.toropchinda.bank.service.impl;

import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;

public interface BankService {

    // Создает новый банк.
    default Bank createBank(int id, String name) {
        return new Bank(id, name);
    }

    // Получает информацию о банке.
    default String readBank(Bank bank) {
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

    //  Обновляет информацию о банке.
    default void updateBank(Bank bank, String newName, double newTotalMoney) {
        bank.name_bank = newName;
        if (newTotalMoney >= 0 && newTotalMoney <= 1000000) {
            // Обновляем количество денег в банке только если оно в допустимых пределах
            bank.setTotalMoney(newTotalMoney);
        } else {
            System.out.println("Ошибка: Недопустимая сумма денег. Она должна быть от 0 до 1 000 000.");
        }
    }

    // Удаляет банк.
    default String deleteBank(Bank bank) {
        return "Банк с ID: " + bank.getId_bank() + " был успешно удален.";
    }

    // Увеличивает количество банкоматов у банка на +1.
    default void increaseAtmCount(Bank bank) {
        int currentAtmCount = bank.getCount_atm();
        bank.setCount_atm(currentAtmCount + 1);
    }

    // Увеличивает количество офисов у банка на +1.
    default void increaseOfficeCount(Bank bank) {
        int currentOfficeCount = bank.getCount_office();
        bank.setCount_office(currentOfficeCount + 1);
    }

    // Увеличивает количество сотрудников у банка на +1.
    default void increaseEmployeeCount(Bank bank) {
        int currentEmployeeCount = bank.getCount_employee();
        bank.setCount_employee(currentEmployeeCount + 1);
    }

    //Увеличивает количество клиентов у банка на +1.
    default void increaseClientCount(Bank bank) {
        int currentClientCount = bank.getCount_client();
        bank.setCount_client(currentClientCount + 1);
    }
}
