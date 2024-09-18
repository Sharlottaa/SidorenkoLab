package main.java.tech.reliab.course.toropchinda.bank.service;
import main.java.tech.reliab.course.toropchinda.bank.entity.BankOffice;

public interface BankOfficeService {

    // Создает банковский офис
    BankOffice createOffice(int id, String name, String address, String status, boolean canPlaceAtm, int atmCount,
                            boolean canIssueLoans, boolean isCashWithdrawalAvailable, boolean isDepositAvailable,
                            double money, double rentalCost);

    // Получает информацию о банковском офисе
    String readOffice(BankOffice office);

    // Обновляет информацию о банковском офисе
    void updateOffice(BankOffice office, String newName, String newStatus, double newMoney, double newRentalCost);

    // Удаляет банковский офис
    String deleteOffice(BankOffice office);

    // Добавляет банкомат в офис банка
    void addAtmToOffice(BankOffice office);

    // Изменяет статус офиса (работает/не работает)
    void changeOfficeStatus(BankOffice office, String status);

    // Проверяет, можно ли разместить банкомат в офисе
    boolean canPlaceAtm(BankOffice office);
}

}
