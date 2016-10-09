/**
 * Created by Valentina on 08.10.2016.
 */
public class Account {
    private final int numAcc;
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
