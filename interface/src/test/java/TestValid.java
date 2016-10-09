import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Valentina on 08.10.2016.
 */
public class TestValid {
    TerminalServerImpl  trmSrv;
    PinValidator pinVld;
    @Before
    public void setUp() {
        trmSrv  = new TerminalServerImpl();
        pinVld=new PinValidator();
    }

    @Test
    public void testFailPin()  {

        boolean pin=pinVld.validatePin("1231".toCharArray(), trmSrv.getPin(1111));
        assertEquals("валидация. Неверный Пин", false, pin);
    }
    @Test
    public void testValidPin()  {

        boolean pin=pinVld.validatePin("1111".toCharArray(), trmSrv.getPin(1111));
        assertEquals("валидация. Верный пин", true, pin);
    }

    @Test
    public void testSomePartContainsPin()  {

        boolean pin=pinVld.validatePin("11111".toCharArray(), trmSrv.getPin(1111));
        assertEquals("валидация. Часть пин кода совпадает", false, pin);
    }

}
