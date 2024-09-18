package main.java.tech.reliab.course.toropchinda.bank.service.impl;


import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankOffice;
import main.java.tech.reliab.course.toropchinda.bank.entity.Employee;
import main.java.tech.reliab.course.toropchinda.bank.service.EmployeeService;

import java.util.Date;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee createEmployee(int id, String fullName, Date birthDate, String position, Bank bank, boolean isRemote,
                                   BankOffice bankOffice, boolean canIssueLoans, double salary) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("ФИО не может быть пустым.");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        }

        Employee employee = new Employee();
        employee.setId_employee(id);
        employee.setFullName(fullName);
        employee.setBirthDate(birthDate);
        employee.setPosition(position);
        employee.setBank(bank);
        employee.setRemote(isRemote);
        employee.setBankOffice(bankOffice);
        employee.setCanIssueLoans(canIssueLoans);
        employee.setSalary(salary);

        return employee;
    }

    @Override
    public String readEmployee(Employee employee) {
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

    @Override
    public void updateEmployee(Employee employee, String newPosition, double newSalary) {
        if (newSalary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        }
        employee.setPosition(newPosition);
        employee.setSalary(newSalary);
    }

    @Override
    public String deleteEmployee(Employee employee) {
        return "Сотрудник с ID: " + employee.getId_employee() + " был успешно удален.";
    }

    @Override
    public void increaseSalary(Employee employee, double amount) {
        employee.setSalary(employee.getSalary() + amount);
    }

    @Override
    public void setRemoteWork(Employee employee) {
        employee.setRemote(true);
    }

    @Override
    public boolean canIssueLoans(Employee employee) {
        return employee.isCanIssueLoans();
    }
}
