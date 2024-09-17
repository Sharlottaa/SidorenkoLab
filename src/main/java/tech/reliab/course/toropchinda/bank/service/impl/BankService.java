package main.java.tech.reliab.course.toropchinda.bank.service.impl;

import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;

public interface BankService {

    //Увеличивает количество банкоматов у банка + 1.
    default void increaseAtmCount(Bank bank) {
        int currentAtmCount = bank.getCount_atm();
        bank.setCount_atm(currentAtmCount + 1);
    }

  // Увеличивает количество сотрудников у банка + 1.
    default void increaseEmployeeCount(Bank bank) {
        int currentEmployeeCount = bank.getCount_employee();
        bank.setCount_employee(currentEmployeeCount + 1);
    }

    // Увеличивает количество клиентов у банка + 1
    default void increaseClientCount(Bank bank) {
        int currentClientCount = bank.getCount_client();
        bank.setCount_client(currentClientCount + 1);
    }
}
