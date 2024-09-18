package main.java.tech.reliab.course.toropchinda.bank.service.impl;

import main.java.tech.reliab.course.toropchinda.bank.entity.BankOffice;
import main.java.tech.reliab.course.toropchinda.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {

    @Override
    public BankOffice createOffice(int id, String name, String address, String status, boolean canPlaceAtm, int atmCount,
                                   boolean canIssueLoans, boolean isCashWithdrawalAvailable, boolean isDepositAvailable,
                                   double money, double rentalCost) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название офиса не может быть пустым или null");
        }
        if (money < 0 || rentalCost < 0) {
            throw new IllegalArgumentException("Деньги и стоимость аренды не могут быть отрицательными.");
        }

        BankOffice office = new BankOffice();
        office.setId_office(id);
        office.setName_office(name);
        office.setAddress_office(address);
        office.setStatus(status);
        office.setCanPlaceAtm(canPlaceAtm);
        office.setAtm_count(atmCount);
        office.setCanIssueLoans(canIssueLoans);
        office.setCashWithdrawalAvailable(isCashWithdrawalAvailable);
        office.setDepositAvailable(isDepositAvailable);
        office.setMoneyAvailable(money);
        office.setRentalCost(rentalCost);

        return office;
    }

    @Override
    public String readOffice(BankOffice office) {
        return "ID офиса: " + office.getId_office() + "\n" +
                "Название офиса: " + office.getName_office() + "\n" +
                "Адрес: " + office.getAddress_office() + "\n" +
                "Статус: " + office.getStatus() + "\n" +
                "Можно ли разместить банкомат: " + office.isCanPlaceAtm() + "\n" +
                "Количество банкоматов: " + office.getAtm_count() + "\n" +
                "Можно ли оформить кредит: " + office.isCanIssueLoans() + "\n" +
                "Работает ли на выдачу денег: " + office.isCashWithdrawalAvailable() + "\n" +
                "Можно ли внести деньги: " + office.isDepositAvailable() + "\n" +
                "Количество денег: " + office.getMoneyAvailable() + "\n" +
                "Стоимость аренды: " + office.getRentalCost();
    }

    @Override
    public void updateOffice(BankOffice office, String newName, String newStatus, double newMoney, double newRentalCost) {
        if (newMoney < 0 || newRentalCost < 0) {
            throw new IllegalArgumentException("Деньги и стоимость аренды не могут быть отрицательными.");
        }
        office.setName_office(newName);
        office.setStatus(newStatus);
        office.setMoneyAvailable(newMoney);
        office.setRentalCost(newRentalCost);
    }

    @Override
    public String deleteOffice(BankOffice office) {
        return "Офис с ID: " + office.getId_office() + " был успешно удален.";
    }

    @Override
    public void addAtmToOffice(BankOffice office) {
        office.setAtm_count(office.getAtm_count() + 1);
    }

    @Override
    public void changeOfficeStatus(BankOffice office, String status) {
        office.setStatus(status);
    }

    @Override
    public boolean canPlaceAtm(BankOffice office) {
        return office.isCanPlaceAtm();
    }
}
