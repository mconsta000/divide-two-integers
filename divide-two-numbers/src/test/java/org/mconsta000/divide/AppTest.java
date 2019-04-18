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
}
