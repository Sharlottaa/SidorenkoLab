package main.java.tech.reliab.course.toropchinda.bank.service;
import main.java.tech.reliab.course.toropchinda.bank.entity.User;
import main.java.tech.reliab.course.toropchinda.bank.entity.Bank;
import main.java.tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import main.java.tech.reliab.course.toropchinda.bank.entity.PaymentAccount;

public interface UserService {

    // Создает нового клиента банка.
    User createUser(int id, String fullName, String birthDate, String placeOfWork);

    // Получает информацию о клиенте.
    String readUser(User user);

    // Обновляет информацию о клиенте.
    void updateUser(User user, String newPlaceOfWork, double newMonthlyIncome);

    // Удаляет клиента банка.
    String deleteUser(User user);

    // Добавляет новый банк к клиенту.
    void addBankToUser(User user, Bank bank);

    // Добавляет кредитный счет к клиенту.
    void addCreditAccountToUser(User user, CreditAccount creditAccount);

    // Добавляет платежный счет к клиенту.
    void addPaymentAccountToUser(User user, PaymentAccount paymentAccount);

    // Рассчитывает кредитный рейтинг на основе ежемесячного дохода.
    int calculateCreditRating(double monthlyIncome) ;
}
