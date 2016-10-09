import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Valentina on 08.10.2016.
 */
public class TestServer {
    private TerminalServerImpl trmSrv;

    @Before
    public void setUp() {
        trmSrv= new TerminalServerImpl();

    }

    @Test
    public void testGetBalance()  {
        double balance=trmSrv.getBalance(2222);
        assertEquals("Баланс", 1000, balance, 0);
    }

    @Test
    public void testSetBalance()  {
        trmSrv.setBalance(2222,7000);
        assertEquals("Баланс", 7000, trmSrv.getBalance(2222), 0);
    }
    @Test
    public void testDeposit()  {
        trmSrv.deposit(3333, 200);
        assertEquals("Баланс", 2200, trmSrv.getBalance(3333), 0);
    }
    @Test
    public void testWithdraw()  {
        trmSrv.withdraw(3333, 55555);
        assertEquals("Баланс", 2000, trmSrv.getBalance(3333), 0);
    }
}
