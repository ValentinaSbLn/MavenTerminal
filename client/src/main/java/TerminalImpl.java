/**
 * Created by Valentina on 08.10.2016.
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by Valentina on 25.09.2016.
 */
class TerminalImpl implements Terminal {
    private boolean checkPin;
    private  final int numAccount;

    private final TerminalServerImpl server;



    private static Logger log = Logger.getLogger(TerminalImpl.class.getName());

    public TerminalImpl(boolean checkPin, int numAccount) {
        this.server = new TerminalServerImpl();
        this.checkPin = checkPin;
        this.numAccount=numAccount;
        try {
            LogManager.getLogManager().readConfiguration(
                    TerminalImpl.class.getResourceAsStream("./"));

        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());

        }
    }

    /**
     * Запрос баланса
     */
    @Override
    public void printBalance() throws InvalidPinException{

        try {
            server.countConnect();
            if (!checkPin) throw new InvalidPinException("Печать счета невозможна.");
            System.out.println(server.getBalance(numAccount));

        } catch (InvalidPinException e) {
            log.log(Level.INFO, "InvalidPinException");
        } catch (ServerWorkException e) {
            log.log(Level.INFO, "ServerWorkException");

        }
    }

    /**
     * Запрос к серверу на снятие наличных
     */
    @Override
    public void takeMoney(double withdraw) {
        try {
            server.countConnect();
            if (!checkPin) throw new InvalidPinException("Внесение средств невозможно.");
            if (withdraw >= 0) {
                if (withdraw % 10 == 0) {
                    server.withdraw(numAccount,withdraw);
                } else
                    System.out.println("ERROR: Со счета можно снимать только суммы кратные 100");

            } else
                System.out.println("ERROR: Вы ввели отрицательное число");
        } catch (InvalidPinException e) {
            log.log(Level.INFO, "InvalidPinException");

        } catch (ServerWorkException e) {
            log.log(Level.INFO, "ServerWorkException");

        }

    }

    /**
     * Запрос к серверу на пополнение счета
     */
    @Override
    public void putMoney(double deposit) {


        try {
            server.countConnect();
            if (!checkPin) throw new InvalidPinException("Внесение средств невозможно.");
            if (deposit >= 0) {
                if (deposit % 10 == 0) {
                    server.deposit(numAccount,deposit);
                } else
                    System.out.println("ERROR: На счет можно класть суммы только кратные 100");

            } else
                System.out.println("ERROR: Вы ввели отрицательное число");
        } catch (InvalidPinException e) {
            log.log(Level.INFO, "InvalidPinException");
        } catch (ServerWorkException e) {
            log.log(Level.INFO, "ServerWorkException");
        }
    }


}
