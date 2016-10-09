/**
 * Created by Valentina on 08.10.2016.
 */
public interface Terminal {
    /**
     * Запрос баланса
     */
    public void printBalance() throws InvalidPinException;

    /**
     * Запрос к серверу на снятие наличных
     */
    public void takeMoney(double withdraw) throws InvalidPinException;

    /**
     * Запрос к серверу на пополнение счета
     */
    public void putMoney(double deposit) throws InvalidPinException;

}
