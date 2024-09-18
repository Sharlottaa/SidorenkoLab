package main.java.tech.reliab.course.toropchinda.bank.service;

import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;

public interface BankService {

    /**
     * Создает новый банк.
     *
     * @param id   Уникальный идентификатор банка
     * @param name Имя банка
     * @return Новый объект банка
     */
    Bank createBank(int id, String name);

    /**
     * Читает информацию о банке.
     *
     * @param bank Объект банка
     * @return Информация о банке
     */
    String readBank(Bank bank);

    /**
     * Обновляет информацию о банке.
     *
     * @param bank          Объект банка
     * @param newName       Новое имя банка
     * @param newTotalMoney Новая сумма денег в банке
     */
    void updateBank(Bank bank, String newName, double newTotalMoney);

    /**
     * Удаляет банк.
     *
     * @param bank Объект банка
     * @return Сообщение об успешном удалении
     */
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

