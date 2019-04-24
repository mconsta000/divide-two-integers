package org.mconsta000.divide;


public final class App {
    public int divide(int dividend, int divisor) {
        final int mask = 0xffffffff;

        boolean negate = true;

        if (dividend > 0) {
            negate = !negate;
            dividend = (dividend-1) ^ mask;
        }

        if (divisor > 0) {
            negate = !negate;
            divisor = (divisor-1) ^ mask;
        }

        int ret = 0;
        while (dividend <= divisor) {
            ret--;
            dividend -= divisor;
        }

        if (negate) {
            if (ret == Integer.MIN_VALUE)
                ret = Integer.MAX_VALUE;
            else
                ret = (ret ^ mask) + 1;
        }

        return ret;        
    }
}
