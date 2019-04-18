package org.mconsta000.divide;


public final class App {
    public int divide(int dividend, int divisor) {

        boolean negate = false;

        if ((dividend & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            negate = !negate;
            dividend = (dividend ^ -1) + 1;
        }

        if ((divisor & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            negate = !negate;
            divisor = (divisor ^ -1) + 1;
        }

        int ret = 0;
        while (dividend >= divisor) {
            ret++;
            dividend -= divisor;
        }

        if (negate) {
            ret = (ret-1) ^ -1;
        }

        return ret;        
    }
}
