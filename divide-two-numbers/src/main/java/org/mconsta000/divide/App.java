package org.mconsta000.divide;


public final class App {
    public int divide(int dividend, int divisor) {

        int ret = 0;
        while (dividend >= divisor){
            ret++;
            dividend -= divisor;
        }
        return ret;        
    }
}
