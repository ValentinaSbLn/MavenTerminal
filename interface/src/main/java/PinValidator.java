import java.util.Arrays;

/**
 * Created by Valentina on 08.10.2016.
 */
public class PinValidator {

    public boolean validatePin(char[] pinEnter, char[] pinServ) {
        return Arrays.equals(pinEnter, pinServ);
    }
}
