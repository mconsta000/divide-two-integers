package org.mconsta000.divide;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    private App app = new App();

    @Test(timeout = 500)
    public void testMask1() {
        // 0100 0000 0000 0000 0000 0000 0000 0000
        //    4    0    0    0    0    0    0    0 
        assertEquals(Integer.toBinaryString(0x40000000), Integer.toBinaryString(app.buildMask(1)));
    }

    @Test(timeout = 500)
    public void testMask2() {
        // 0110 0000 0000 0000 0000 0000 0000 0000
        //    6    0    0    0    0    0    0    0 
        assertEquals(Integer.toBinaryString(0x60000000), Integer.toBinaryString(app.buildMask(2)));
    }

    @Test(timeout = 500)
    public void testMask4() {
        // 0111 1000 0000 0000 0000 0000 0000 0000
        //    7    8    0    0    0    0    0    0 
        assertEquals(Integer.toBinaryString(0x78000000), Integer.toBinaryString(app.buildMask(4)));
    }

    @Test()
    public void testExtract1() {
        // 0100 0000 0000 0000 0000 0000 0000 0000
        //    4    0    0    0    0    0    0    0 
        assertEquals(Integer.toBinaryString(0x00000001), 
            Integer.toBinaryString(app.extract(0x70000000, 0x40000000, 1, 30)));
    }

    @Test()
    public void testExtract7() {
        // 0100 0000 0000 0000 0000 0000 0000 0000
        //    4    0    0    0    0    0    0    0 
        assertEquals(Integer.toBinaryString(0x00000007), 
            Integer.toBinaryString(app.extract(0x70000000, 0x70000000, 2, 29)));
    }

    @Test()
    public void testExtract10() {
        // 0000 0000 0000 0000 0000 0000 0000 1010
        //    0    0    0    0    0    0    0    a 
        assertEquals(Integer.toBinaryString(0x00000002), 
            Integer.toBinaryString(app.extract(0x0000000a, 0x0000000c, 2, 3)));
    }

    @Test()
    public void testPositive() {
        assertEquals(5, app.divide(10,2));
    }

    @Test
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
    public void testZeroDividend() {
        assertEquals(0, app.divide(0,2));
    }

    @Test(timeout = 500)
    public void testOverflow() {
        assertEquals(Integer.MAX_VALUE, app.divide(Integer.MIN_VALUE,-1));
    }

    @Test(timeout = 500)
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
