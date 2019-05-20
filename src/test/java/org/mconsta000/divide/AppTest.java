package org.mconsta000.divide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AppTest {
    private App app = new App();

    @Parameter(0)
    public int dividend;

    @Parameter(1)
    public int divisor;

    @Parameter(2)
    public int expected;

    @Parameters(name="{index}: {0}/{1}={2}")
    public static Collection<Object[]> data() {
        Object data[][] = new Object[][] {
            {10,2,5},
            {10,-2,-5},
            {-10,2,-5},
            {-10,-2,5},
            {11,2,5},
            {10,3,3},
            {30,4,7},
            {101,4,25},
            {0,2,0},
            {Integer.MIN_VALUE,-1,Integer.MAX_VALUE},
            {Integer.MIN_VALUE,1,Integer.MIN_VALUE},
            {Integer.MAX_VALUE,-1,-Integer.MAX_VALUE},
            {Integer.MAX_VALUE,1,Integer.MAX_VALUE} 
        };

        return Arrays.asList(data);
    }

    @Test
    public void test() {
        assertEquals(expected, app.divide(dividend, divisor));
    }
}
