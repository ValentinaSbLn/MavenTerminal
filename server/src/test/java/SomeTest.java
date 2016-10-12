import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Calculator.class)
public class SomeTest {

    @Test
    public void testPowerMockExample() {
        mockStatic(Calculator.class);
        when(Calculator.add(1, 2)).thenReturn(100);

        int result = Calculator.add(1, 2);
        assertEquals(100, result);
    }

}
