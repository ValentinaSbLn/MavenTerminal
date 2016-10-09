/**
 * Created by Valentina on 08.10.2016.
 */
public class PinValidator {

    public boolean validatePin(char[] pinEnter, char[] pinServ) {
        if (pinServ.length != pinEnter.length)
            return false;
        else {
            for (int i = 0; i < pinServ.length; i++)
                if (pinEnter[i] != pinServ[i])
                    return false;
            return true;
        }
    }
}
