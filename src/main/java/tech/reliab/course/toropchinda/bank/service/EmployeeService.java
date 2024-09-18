package main.java.tech.reliab.course.toropchinda.bank.service;

import main.java.tech.reliab.course.toropchinda.bank.entity.Employee;
import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankOffice;

import java.util.Date;

public interface EmployeeService {

    // Создает нового сотрудника.
    Employee createEmployee(int id, String fullName, Date birthDate, String position, Bank bank, boolean isRemote,
                            BankOffice bankOffice, boolean canIssueLoans, double salary);

    // Получает информацию о сотруднике.
    String readEmployee(Employee employee);

    //  Обновляет информацию о сотруднике.
    void updateEmployee(Employee employee, String newPosition, double newSalary);

    // Удаляет сотрудника.
    String deleteEmployee(Employee employee);

    // Повышает зарплату сотруднику.
    void increaseSalary(Employee employee, double amount);

    // Назначает сотрудника на удаленную работу.
    void setRemoteWork(Employee employee);

    // Проверяет, может ли сотрудник выдавать кредиты.
    boolean canIssueLoans(Employee employee);
}
