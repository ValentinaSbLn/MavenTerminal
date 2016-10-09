import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Valentina on 08.10.2016.
 */
public class TestInterface {
    TermUsr tUsr;

    @Before
    public void setUp() {
        tUsr  = new TermUsr();
    }

    @Test (expected = AccountIsLockedException.class)
    public void testFailPin() throws AccountIsLockedException {
        PinValidator validator = new PinValidator();
        boolean enterPin=false;
        char[] pin;
        int countEnterPin = 1;
        do {
            if (countEnterPin <= 3) {
                pin = "1234".toCharArray();
                if (validator.validatePin(pin, "7777".toCharArray()) ) {
                    enterPin=true;
                } else {
                    new InvalidPinException();
                    countEnterPin++;
                }
            } else
                throw new AccountIsLockedException();
        } while (!enterPin);

    }


}
