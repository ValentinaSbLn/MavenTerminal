import java.util.Arrays;
import java.util.List;

/**
 * Created by Valentina on 25.09.2016.
 */
public class TerminalServerImpl implements TerminalServer {
    private List<Account> accounts;
    private int countConnect;

    public void setCountConnect(int countConnect) {
        this.countConnect = countConnect;
    }

    public TerminalServerImpl() {
        accounts = Arrays.asList(new Account(1111, "1111".toCharArray(), 100.0), new Account(2222, "2222".toCharArray(), 1000.0), new Account(3333, "3333".toCharArray(), 2000.0));
        this.countConnect = 1;
    }

    @Override
    public char[] getPin(int num) {
        char[] pin = new char[0];
        try {
            int numAcc = getNumAccount(num);
            pin = accounts.get(numAcc).getPin();
        } catch (InvalidNumAccount invalidNumAccount) {
            invalidNumAccount.printStackTrace();
        }
        return pin;
    }

    private int getNumAccount(int num) throws InvalidNumAccount {
        int k = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (num == accounts.get(i).getNumAcc())
                k = i;
        }
        if (k == -1)
            new InvalidNumAccount();
        return k;
    }

    @Override
    public double getBalance(int num) {
        double balance = 0;
        try {
            balance = accounts.get(getNumAccount(num)).getBalance();
        } catch (InvalidNumAccount invalidNumAccount) {
            invalidNumAccount.printStackTrace();
        }
        return balance;
    }

    @Override
    public void setBalance(int num, double balance) {

        try {
            accounts.get(getNumAccount(num)).setBalance(balance);
        } catch (InvalidNumAccount invalidNumAccount) {
            invalidNumAccount.printStackTrace();
        }
    }

    @Override
    public void deposit(int num, double sum) {
        setBalance(num, getBalance(num) + sum);

    }

    @Override
    public void withdraw(int num, double sum) {
        try {
            if (sum <= getBalance(num) && sum > 0) {
                setBalance(num, getBalance(num) - sum);
            } else
                throw new InvalidBalanceException();
        } catch (InvalidBalanceException e) {
            System.out.println("Баланс: " + getBalance(num));
        }

    }

    @Override
    public void countConnect() throws ServerWorkException {
        countConnect++;
        if (countConnect > 5)
            throw new ServerWorkException(this);
    }

}
