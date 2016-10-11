/**
 * Created by Valentina on 28.09.2016.
 */
public class InvalidNumAccount extends Exception {
    InvalidNumAccount(){
        System.out.println("Введен неверный номер счета. Работа завершена");
        System.exit(0); // TODO System.exit в конструкторе класса делать совсем не стоит.
    }
}
