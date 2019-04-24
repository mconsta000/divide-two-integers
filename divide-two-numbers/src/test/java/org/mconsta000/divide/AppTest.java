package org.mconsta000.divide;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    private App app = new App();

    @Test
    public void testPositive() {
        assertEquals(5, app.divide(10,2));
    }

    @Test
    public void testNegativeDivisor() {
        assertEquals(-5, app.divide(10,-2));
    }

    @Test
    public void testNegativeDividend() {
        assertEquals(-5, app.divide(-10,2));
    }

    @Test
    public void testNegativeDividendAndDivisor() {
        assertEquals(5, app.divide(-10,-2));
    }

    @Test
    public void testRemainder() {
        assertEquals(5, app.divide(11,2));
    }

    @Test
    public void testZeroDividend() {
        assertEquals(0, app.divide(0,2));
    }

    @Test
    public void testOverflow() {
        assertEquals(Integer.MAX_VALUE, app.divide(Integer.MIN_VALUE,-1));
    }

    @Test
    public void testOverflow2() {
        assertEquals(Integer.MIN_VALUE, app.divide(Integer.MIN_VALUE,1));
    }

    @Test
    public void testUnderflow() {
        assertEquals(-Integer.MAX_VALUE, app.divide(Integer.MAX_VALUE,-1));
    }

    @Test
    public void testUnderflow2() {
        assertEquals(Integer.MAX_VALUE, app.divide(Integer.MAX_VALUE,1));
    }
}
