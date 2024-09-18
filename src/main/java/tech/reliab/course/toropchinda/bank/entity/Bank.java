package main.java.tech.reliab.course.toropchinda.bank.entity;


public class Bank {

    // Id банка
    private int id_bank;

    // Имя банка
    public String name_bank;

    // Кол-во офисов
    private int count_office = 0;

    // Кол-во банкоматов
    private int count_atm = 0;

    // Кол-во сотрудников
    private int count_employee = 0;

    // Количество клиентов
    private int count_client = 0;

    // Рейтинг банка (генерируется рандомно, от 0 до 100)
    private int rating_bank;

    // Всего денег в банке (генерируется рандомно, но не более 1 000 000)
    private double total_money;

    // Процентная ставка (генерируется рандомно, но не более 20%, зависит от рейтинга банка)
    private double interest_rate;

    public int getId_bank() {
        return id_bank;
    }

    public void setId_bank(int id_bank) {
        this.id_bank = id_bank;
    }

    public String getName_bank() {
        return name_bank;
    }

    public void setName_bank(String name_bank) {
        this.name_bank = name_bank;
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

    public void setRating_bank(int rating_bank) {
        this.rating_bank = rating_bank;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }
}
