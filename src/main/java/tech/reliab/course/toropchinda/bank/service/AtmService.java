package main.java.tech.reliab.course.toropchinda.bank.service;

import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankAtm;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankOffice;
import main.java.tech.reliab.course.toropchinda.bank.entity.Employee;

public interface AtmService {

    // Создает банкомат
    BankAtm createAtm(int id, String name, String address, String status, Bank bank, BankOffice bankOffice,
                      Employee employee, boolean isCashWithdrawalAvailable, boolean isDepositAvailable,
                      double money, double maintenanceCost);

    // Получает информацию о банкомате
    String readAtm(BankAtm atm);

    // Обновляет информацию о банкомате
    void updateAtm(BankAtm atm, String newName, String newStatus, double newMoney, double newMaintenanceCost);

    // Удаляет банкомат
    String deleteAtm(BankAtm atm);

    // Добавляет деньги в банкомат
    void addMoney(BankAtm atm, double amount);

    // Снимает деньги из банкомата
    void withdrawMoney(BankAtm atm, double amount);
}
