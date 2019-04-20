package org.mconsta000.divide;


public final class App {
    public int divide(int dividend, int divisor) {
        final int mask = -1;

        boolean negate = false;

        if ((dividend & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            negate = !negate;
            dividend = (dividend ^ mask) + 1;
        }

        if ((divisor & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            negate = !negate;
            divisor = (divisor ^ mask) + 1;
        }

        int ret = 0;
        while (dividend >= divisor) {
            ret++;
            dividend -= divisor;
        }

        if (negate) {
            ret = (ret-1) ^ mask;
        }

        return ret;        
    }
}
