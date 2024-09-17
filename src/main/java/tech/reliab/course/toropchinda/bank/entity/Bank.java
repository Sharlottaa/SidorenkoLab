package main.java.tech.reliab.course.toropchinda.bank.entity;

import java.util.Random;

public class Bank {
    /*
             • Рейтинг банка (генерируется рандомно, от 0 до 100, где 100 наивысший
             балл, чем выше рейтинг банка, тем меньше должна быть процентная ставка)
 • Всего денег в банке (генерируется рандомно, но не более 1 000 000)
 • Процентная ставка (генерируется рандомно, но не более 20%, однако
             нужно учитывать рейтинг банка, чем он выше, тем ставка должна
                              сгенерироваться меньше)
         */
    // Id банка
    private int id_bank;
    // Имя банка
    public String name_bank;

    // Кол-во офисов
    public static int count_office = 0;

    // Кол-во банкоматов
    public static int count_atm = 0;

    // Кол-во сотрудников
    public static int count_employee = 0;

    // Количество клиентов
    public static int count_client = 0;


    // Рейтинг банка (генерируется рандомно, от 0 до 100)
    private int rating_bank;

    // Всего денег в банке (генерируется рандомно, но не более 1 000 000)
    private double total_money;

    // Процентная ставка (генерируется рандомно, но не более 20, но и зависит от рейтинга банка)
    private double interest_rate;


    /**
     * Конструктор  банка. Генерируются его рейтинг, количество денег и процентная ставка.
     */
    public Bank(int id_bank, String name_bank) {
        this.id_bank = id_bank;
        this.name_bank = name_bank;
        this.rating_bank = new Random().nextInt(101); // Генерация рейтинга от 0 до 100
        this.total_money = new Random().nextDouble() * 1000000; // Генерация суммы денег до 1 000 000
        this.interest_rate = calculateInterestRate(this.rating_bank); // Расчет процентной ставки
    }

    /**
     * Метод для вычисления процентной ставки на основе рейтинга банка.
     * Чем выше рейтинг, тем ниже процентная ставка.
     */
    private double calculateInterestRate(int rating) {
        double maxRate = 20.0; // Максимальная ставка 20%
        double minRate = 2.0;  // Минимальная ставка пусть 2%

        return maxRate - ((rating / 100.0) * (maxRate - minRate));
    }

    // Геттеры и сеттеры

    public int getId_bank() {
        return id_bank;
    }

    public String getName_bank() {
        return name_bank;
    }

    public int getCount_office() {
        return count_office;
    }

    public void setCount_office(int count_office) {
        this.count_office = count_office;
    }

    public int getCount_atm() {
        return count_atm;
    }

    public void setCount_atm(int count_atm) {
        this.count_atm = count_atm;
    }

    public int getCount_employee() {
        return count_employee;
    }

    public void setCount_employee(int count_employee) {
        this.count_employee = count_employee;
    }

    public int getCount_client() {
        return count_client;
    }

    public void setCount_client(int count_client) {
        this.count_client = count_client;
    }

    public int getRating_bank() {
        return rating_bank;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotalMoney(double total_money) {
        if (total_money >= 0 && total_money <= 1000000) {
            this.total_money = total_money;
        } else {
            System.out.println("Ошибка: Недопустимая сумма денег.");
        }
    }

    public double getInterest_rate() {
        return interest_rate;
    }
}


