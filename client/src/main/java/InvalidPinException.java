/**
 * Created by Valentina on 08.10.2016.
 */
public class InvalidPinException extends Exception{
    private static final long serialVersionUID = -2586424477138885105L;

    InvalidPinException(String s){
        System.out.println(s+"Введен неверный PIN" );
    }
    InvalidPinException(){
        new InvalidPinException("");
    }
}
