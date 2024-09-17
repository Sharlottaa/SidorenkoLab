package main.java.tech.reliab.course.toropchinda.bank.service.impl;

import main.java.tech.reliab.course.toropchinda.bank.entity.Employee;
import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankOffice;

import java.util.Date;

public interface EmployeeService {

    // Создает нового сотрудника.
    default Employee createEmployee(int id, String fullName, Date birthDate, String position, Bank bank, boolean isRemote,
                                    BankOffice bankOffice, boolean canIssueLoans, double salary) {
        return new Employee(id, fullName, birthDate, position, bank, isRemote, bankOffice, canIssueLoans, salary);
    }

    // Получает информацию о сотруднике
    default String readEmployee(Employee employee) {
        return "ID сотрудника: " + employee.getId_employee() + "\n" +
                "ФИО: " + employee.getFullName() + "\n" +
                "Дата рождения: " + employee.getBirthDate() + "\n" +
                "Должность: " + employee.getPosition() + "\n" +
                "Банк: " + employee.getBank().getName_bank() + "\n" +
                "Работает ли удаленно: " + (employee.isRemote() ? "Да" : "Нет") + "\n" +
                "Офис: " + employee.getBankOffice().getName_office() + "\n" +
                "Может выдавать кредиты: " + (employee.isCanIssueLoans() ? "Да" : "Нет") + "\n" +
                "Зарплата: " + employee.getSalary();
    }

    // Обновляет информацию о сотруднике.
    default void updateEmployee(Employee employee, String newPosition, double newSalary) {
        employee.setPosition(newPosition);
        employee.setSalary(newSalary);
    }

    //Удаляет сотрудника.
    default String deleteEmployee(Employee employee) {
        return "Сотрудник с ID: " + employee.getId_employee() + " был успешно удален.";
    }

    /**
     * Повышает зарплату сотруднику.
     * @param employee Объект сотрудника, которому нужно повысить зарплату
     * @param amount Сумма повышения зарплаты
     */
    default void increaseSalary(Employee employee, double amount) {
        employee.setSalary(employee.getSalary() + amount);
    }

    // Назначает сотрудника на удаленную работу.
    default void setRemoteWork(Employee employee) {
        employee.setRemote(true);
    }

    /**
     * Проверяет, может ли сотрудник выдавать кредиты.
     * @return Может ли сотрудник выдавать кредиты (true/false)
     */
    default boolean canIssueLoans(Employee employee) {
        return employee.isCanIssueLoans();
    }
}
