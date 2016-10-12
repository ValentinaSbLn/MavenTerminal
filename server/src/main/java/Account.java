// TODO Нет package!

/**
 * Created by Valentina on 08.10.2016.
 */
public class Account {
    private final int numAcc;
    // Лучше PIN не хранить вместе с аккаунтом. Точнее лучше не хранить PIN вовсе.
    // Собственно, никакие пароли нельзя хранить в открытом виде.
    // Обычно считается хэш функция пароля, именно с её результатом происходит дальнейшее сравнение.
    // Валидатор ПиНа можно научить ходить к некому сервису, который хранит хэши паролей, связанных с аккаунтами.
    private final char [] pin;
    private double balance;

    public Account(int numAcc, char[] pin, double balance) {
        this.numAcc = numAcc;
        this.pin = pin;
        this.balance = balance;
    }

    public int getNumAcc() {
        return numAcc;
    }

    public char[] getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
