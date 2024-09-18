package main.java.tech.reliab.course.toropchinda.bank.service.impl;

import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankAtm;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankOffice;
import main.java.tech.reliab.course.toropchinda.bank.entity.Employee;
import main.java.tech.reliab.course.toropchinda.bank.service.AtmService;

public class BankAtmServiceImpl implements AtmService {

    @Override
    public BankAtm createAtm(int id, String name, String address, String status, Bank bank, BankOffice bankOffice,
                             Employee employee, boolean isCashWithdrawalAvailable, boolean isDepositAvailable,
                             double money, double maintenanceCost) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название банкомата не может быть пустым или null");
        }
        if (money < 0 || maintenanceCost < 0) {
            throw new IllegalArgumentException("Деньги или стоимость обслуживания не могут быть отрицательными.");
        }
        BankAtm atm = new BankAtm();
        atm.setId_atm(id);
        atm.setName_atm(name);
        atm.setAddress_atm(address);
        atm.setStatus(status);
        atm.setBank(bank);
        atm.setBankOffice(bankOffice);
        atm.setEmployee(employee);
        atm.setCashWithdrawalAvailable(isCashWithdrawalAvailable);
        atm.setDepositAvailable(isDepositAvailable);
        atm.setMoneyAvailable(money);
        atm.setMaintenanceCost(maintenanceCost);

        return atm;
    }

    @Override
    public String readAtm(BankAtm atm) {
        return "ID банкомата: " + atm.getId_atm() + "\n" +
                "Имя: " + atm.getName_atm() + "\n" +
                "Адрес: " + atm.getAddress_atm() + "\n" +
                "Статус: " + atm.getStatus() + "\n" +
                "Банк: " + atm.getBank().getName_bank() + "\n" +
                "Расположение: " + atm.getBankOffice().getName_office() + "\n" +
                "Обслуживающий сотрудник: " + (atm.getEmployee() != null ? atm.getEmployee().getFullName() : "Нет данных") + "\n" +
                "Работает ли на выдачу денег: " + atm.isCashWithdrawalAvailable() + "\n" +
                "Можно ли внести деньги: " + atm.isDepositAvailable() + "\n" +
                "Количество денег в банкомате: " + atm.getMoneyAvailable() + "\n" +
                "Стоимость обслуживания: " + atm.getMaintenanceCost();
    }

    @Override
    public void updateAtm(BankAtm atm, String newName, String newStatus, double newMoney, double newMaintenanceCost) {
        if (newMoney < 0 || newMaintenanceCost < 0) {
            throw new IllegalArgumentException("Количество денег и стоимость обслуживания не могут быть отрицательными.");
        }
        atm.setName_atm(newName);
        atm.setStatus(newStatus);
        atm.setMoneyAvailable(newMoney);
        atm.setMaintenanceCost(newMaintenanceCost);
    }

    @Override
    public String deleteAtm(BankAtm atm) {
        return "Банкомат с ID: " + atm.getId_atm() + " был успешно удален.";
    }

    @Override
    public void addMoney(BankAtm atm, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Количество добавляемых денег не может быть отрицательным.");
        }
        atm.setMoneyAvailable(atm.getMoneyAvailable() + amount);
    }

    @Override
    public void withdrawMoney(BankAtm atm, double amount) {
        double currentMoney = atm.getMoneyAvailable();
        if (amount < 0) {
            throw new IllegalArgumentException("Снимаемая сумма не может быть отрицательной.");
        }
        if (currentMoney >= amount) {
            atm.setMoneyAvailable(currentMoney - amount);
        } else {
            throw new IllegalStateException("Недостаточно средств в банкомате.");
        }
    }
}
