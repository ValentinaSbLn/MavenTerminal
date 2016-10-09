
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by Valentina on 09.10.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(TerminalServerImpl.class)
public class TestPrivateMethod {
        @Test (expected = IllegalArgumentException.class)
        public void  testPrivateGetNumAccountFail (){
            TerminalServerImpl spy= PowerMockito.spy(new TerminalServerImpl());
            try {
                spy.getPin(2222);
                when(spy, method(TerminalServerImpl.class, "getNumAccount", int.class))
                        .withArguments(-1)
                        .thenReturn(anyInt());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    @Test
    public void  testPrivateGetNumAccount (){
        TerminalServerImpl spy= PowerMockito.spy(new TerminalServerImpl());
        try {
            spy.getPin(2222);
            when(spy, method(TerminalServerImpl.class, "getNumAccount", int.class))
                    .withArguments(2222)
                    .thenReturn(anyInt());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

