import java.util.Scanner;

/**
 * Created by Valentina on 08.10.2016.
 */

/**
 * Created by Valentina on 08.10.2016.
 */
public class TermUsr {

    // TODO Здесь член класса server должен быть интерфейсом, значение должно передаваться в конструкторе.
    // Написание теста для класса вынудит изменить его дизайн в лучшую сторону.
    private TerminalServerImpl server = new TerminalServerImpl();

    private int numAccount;
    private TerminalImpl terminal;

    public int getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(int numAccount) {
        this.numAccount = numAccount;
    }

    public boolean enterPin() throws AccountIsLockedException {
        PinValidator validator = new PinValidator();
        boolean enterPin = false;
        char[] pin;
        int countEnterPin = 1;
        do {
            if (countEnterPin <= 3) {
                pin = readPin();
                if (validator.validatePin(pin, server.getPin(numAccount))) {
                    enterPin = true;
                } else {
                    new InvalidPinException();
                    countEnterPin++;
                }
            } else
                throw new AccountIsLockedException();
        } while (!enterPin);
        return enterPin;
    }


    public String readConsol(String massage) {

        String consol = "";
        System.out.println(massage);
        Scanner in = new Scanner(System.in);
        consol = in.nextLine();
        return consol;
    }

    public char[] readPin() {
        char[] pin;
        try {
            System.out.println("Введите PIN");
            Scanner in = new Scanner(System.in);
            pin = in.nextLine().toCharArray();


        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода");
            return new char[0];
        }
        return pin;


    }


}

