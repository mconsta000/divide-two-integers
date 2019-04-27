package org.mconsta000.divide;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    private App app = new App();

    @Test(timeout = 500)
    public void testMask1() {
        // 1000 0000 0000 0000 0000 0000 0000 0000
        //    8    0    0    0    0    0    0    0 
        assertEquals(Long.toBinaryString(0x80000000l), Long.toBinaryString(app.buildMask(1)));
    }

    @Test(timeout = 500)
    public void testMask2() {
        // 1100 0000 0000 0000 0000 0000 0000 0000
        //    c    0    0    0    0    0    0    0 
        assertEquals(Long.toBinaryString(0xc0000000l), Long.toBinaryString(app.buildMask(2)));
    }

    @Test(timeout = 500)
    public void testMask4() {
        // 1111 0000 0000 0000 0000 0000 0000 0000
        //    f    0    0    0    0    0    0    0 
        assertEquals(Long.toBinaryString(0xf0000000l), Long.toBinaryString(app.buildMask(4)));
    }

    @Test(timeout = 500)
    public void testExtract1() {
        // 1100 0000 0000 0000 0000 0000 0000 0000
        //    c    0    0    0    0    0    0    0 
        assertEquals(Long.toBinaryString(0x00000001), 
            Long.toBinaryString(app.extract(0xc0000000l, 0x80000000l, 1, 31)));
    }

    @Test(timeout = 500)
    public void testExtract7() {
        // 0100 0000 0000 0000 0000 0000 0000 0000
        //    4    0    0    0    0    0    0    0 
        assertEquals(Long.toBinaryString(0x00000007), 
            Long.toBinaryString(app.extract(0x70000000l, 0x70000000l, 2, 29)));
    }

    @Test(timeout = 500)
    public void testExtract10() {
        // 0000 0000 0000 0000 0000 0000 0000 1010
        //    0    0    0    0    0    0    0    a 
        assertEquals(Long.toBinaryString(0x00000002), 
            Long.toBinaryString(app.extract(0x0000000al, 0x0000000cl, 2, 3)));
    }

    @Test(timeout = 500)
    public void testPositive() {
        assertEquals(5, app.divide(10,2));
    }

    @Test(timeout = 500)
    public void testNegativeDivisor() {
        assertEquals(-5, app.divide(10,-2));
    }

    @Test(timeout = 500)
    public void testNegativeDividend() {
        assertEquals(-5, app.divide(-10,2));
    }

    @Test(timeout = 500)
    public void testNegativeDividendAndDivisor() {
        assertEquals(5, app.divide(-10,-2));
    }

    @Test(timeout = 500)
    public void testRemainder() {
        assertEquals(5, app.divide(11,2));
    }

    @Test(timeout = 500)
    public void testRemainder2() {
        assertEquals(7, app.divide(30,4));
    }

    @Test(timeout = 500)
    public void testRemainder3() {
        assertEquals(25, app.divide(101,4));
    }

    @Test(timeout = 500)
    public void testZeroDividend() {
        assertEquals(0, app.divide(0,2));
    }

    @Test(timeout = 500)
    public void testOverflow() {
        assertEquals(Integer.MAX_VALUE, app.divide(Integer.MIN_VALUE,-1));
    }

    @Test()
    public void testOverflow2() {
        assertEquals(Integer.MIN_VALUE, app.divide(Integer.MIN_VALUE,1));
    }

    @Test(timeout = 500)
    public void testUnderflow() {
        assertEquals(-Integer.MAX_VALUE, app.divide(Integer.MAX_VALUE,-1));
    }

    @Test(timeout = 500)
    public void testUnderflow2() {
        assertEquals(Integer.MAX_VALUE, app.divide(Integer.MAX_VALUE,1));
    }
}
