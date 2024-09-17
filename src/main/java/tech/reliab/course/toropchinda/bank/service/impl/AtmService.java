package main.java.tech.reliab.course.toropchinda.bank.service.impl;


import main.java.tech.reliab.course.toropchinda.bank.entity.*;

import main.java.tech.reliab.course.toropchinda.bank.entity.BankAtm;


public interface AtmService {
    default BankAtm createAtm(int id, String name, String address, String status, Bank bank, BankOffice bankOffice,
                              Employee employee, boolean isCashWithdrawalAvailable, boolean isDepositAvailable,
                              double money, double maintenanceCost) {
        return new BankAtm(id, name, address, status, bank, bankOffice, employee, isCashWithdrawalAvailable,
                isDepositAvailable, money, maintenanceCost);
    }

    // Получает информацию о банкомате.
    default String readAtm(BankAtm atm) {
        return "ID банкомата: " + atm.getId_atm() + "\n" +
                "Имя: " + atm.getName_atm() + "\n" +
                "Адрес: " + atm.getAddress_atm() + "\n" +
                "Статус: " + atm.getStatus() + "\n" +
                "Банк: " + atm.getBank().getName_bank() + "\n" +
                "Расположение: " + atm.getBankOffice().getName_office() + "\n" +
                "Обслуживающий сотрудник: " + atm.getEmployee().getFullName() + "\n" +
                "Работает ли на выдачу денег: " + atm.isCashWithdrawalAvailable() + "\n" +
                "Можно ли внести деньги: " + atm.isDepositAvailable() + "\n" +
                "Количество денег в банкомате: " + atm.getMoneyAvailable() + "\n" +
                "Стоимость обслуживания: " + atm.getMaintenanceCost();
    }

    // Обновляет информацию о банкомате.
    default void updateAtm(BankAtm atm, String newName, String newStatus, double newMoney, double newMaintenanceCost) {
        atm.setName_atm(newName);
        atm.setStatus(newStatus);
        atm.setMoneyAvailable(newMoney);
        atm.setMaintenanceCost(newMaintenanceCost);
    }

    //  Удаляет банкомат.
    default String deleteAtm(BankAtm atm) {
        return "Банкомат с ID: " + atm.getId_atm() + " был успешно удален.";
    }

    /**
     * Добавляет деньги в банкомат.
     * @param atm Объект банкомата, в который добавляются деньги
     * @param amount Количество денег для добавления
     */
    default void addMoney(BankAtm atm, double amount) {
        atm.setMoneyAvailable(atm.getMoneyAvailable() + amount);
    }

    /**
     * Снимает деньги из банкомата.
     * @param atm Объект банкомата, из которого снимаются деньги
     * @param amount Количество денег для снятия
     */
    default void withdrawMoney(BankAtm atm, double amount) {
        double currentMoney = atm.getMoneyAvailable();
        if (currentMoney >= amount) {
            atm.setMoneyAvailable(currentMoney - amount);
        } else {
            System.out.println("Недостаточно средств в банкомате.");
        }
    }

    /**
     * Проверяет статус банкомата.
     * @return Статус банкомата (работает/не работает/нет денег)
     */
    default String checkStatus(BankAtm atm) {
        return atm.getStatus();
    }
}
