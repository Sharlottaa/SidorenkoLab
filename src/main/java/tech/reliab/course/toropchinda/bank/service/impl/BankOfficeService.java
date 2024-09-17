package main.java.tech.reliab.course.toropchinda.bank.service.impl;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankOffice;

public interface BankOfficeService {
    default BankOffice createOffice(int id, String name, String address, String status, boolean canPlaceAtm, int atmCount,
                                    boolean canIssueLoans, boolean isCashWithdrawalAvailable, boolean isDepositAvailable,
                                    double money, double rentalCost) {
        return new BankOffice(id, name, address, status, canPlaceAtm, atmCount, canIssueLoans, isCashWithdrawalAvailable,
                isDepositAvailable, money, rentalCost);
    }

    // Получает информацию о банковском офисе.
    default String readOffice(BankOffice office) {
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

    // Обновляет информацию о банковском офисе.
    default void updateOffice(BankOffice office, String newName, String newStatus, double newMoney, double newRentalCost) {
        office.setName_office(newName);
        office.setStatus(newStatus);
        office.setMoneyAvailable(newMoney);
        office.setRentalCost(newRentalCost);
    }

    // Удаляет банковский офис
    default String deleteOffice(BankOffice office) {
        return "Офис с ID: " + office.getId_office() + " был успешно удален.";
    }

    //Добавляет банкомат в офис банка.
    default void addAtmToOffice(BankOffice office) {
        office.setAtm_count(office.getAtm_count() + 1);
    }

    // Изменяет статус офиса (работает/не работает).
    default void changeOfficeStatus(BankOffice office, String status) {
        office.setStatus(status);
    }

    // Проверяет, можно ли разместить банкомат в офисе.
    default boolean canPlaceAtm(BankOffice office) {
        return office.isCanPlaceAtm();
    }
}
