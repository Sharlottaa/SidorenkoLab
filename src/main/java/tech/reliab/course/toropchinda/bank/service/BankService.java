package main.java.tech.reliab.course.toropchinda.bank.service;

import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;

public interface BankService {

    // Создает новый банк.
    Bank createBank(int id, String name);

    // Читает информацию о банке.
    String readBank(Bank bank);

    // Обновляет информацию о банке.
    void updateBank(Bank bank, String newName, double newTotalMoney);

    // Удаляет банк.
    String deleteBank(Bank bank);

    // Увеличивает количество банкоматов у банка на +1.
    void increaseAtmCount(Bank bank);

    // Увеличивает количество офисов у банка на +1.
    void increaseOfficeCount(Bank bank);

    // Увеличивает количество сотрудников у банка на +1.
    void increaseEmployeeCount(Bank bank);

    //Увеличивает количество клиентов у банка на +1.
    void increaseClientCount(Bank bank);
}

