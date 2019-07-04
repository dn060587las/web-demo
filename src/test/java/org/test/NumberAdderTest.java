package org.test;

import org.demo.components.DataStore;
import org.demo.components.NumberAdder;
import org.demo.components.RandomNumberComponent;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class NumberAdderTest {

    @Test
    public void testNumberAdd() {
        RandomNumberComponent comp = Mockito.mock(RandomNumberComponent.class);
        DataStore ds = new DataStore();
        Mockito.when(comp.getRandom(5)).thenReturn(5);
        Mockito.when(comp.getRandom(3)).thenReturn(1);
        NumberAdder n = new NumberAdder(comp, ds);

        int param1 = 1;
        int param2 = 5;
        int expected = 11; // a =1, b = 5, getRandom = 5
        Assert.assertEquals(expected, n.add(param1, param2));

        param1 = 5;
        param2 = 3;
        expected = 9;// a =5, b = 3, getRandom = 1
        Assert.assertEquals(expected, n.add(param1, param2));
        Mockito.verify(comp, times(2)).getRandom(Mockito.anyInt());
    }
}
