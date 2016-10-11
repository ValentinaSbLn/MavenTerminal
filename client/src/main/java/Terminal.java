/**
 * Created by Valentina on 08.10.2016.
 */
public interface Terminal {
    /**
     * Запрос баланса
     */
    void printBalance() throws InvalidPinException;

    /**
     * Запрос к серверу на снятие наличных
     */
    void takeMoney(double withdraw) throws InvalidPinException;

    /**
     * Запрос к серверу на пополнение счета
     */
    void putMoney(double deposit) throws InvalidPinException;

}
