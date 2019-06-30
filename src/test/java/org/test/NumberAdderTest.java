package test;

import org.demo.components.NumberAdder;
import org.junit.Assert;
import org.junit.Test;

public class NumberAdderTest {

    @Test
    public void testNumberAdd() {
        NumberAdder n = new NumberAdder();
        int param1 = 1;
        int param2 = 2;
        int expected = 3;
        Assert.assertEquals(expected, n.add(1, 2));
    }
}
