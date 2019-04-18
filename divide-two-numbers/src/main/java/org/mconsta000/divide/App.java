package org.mconsta000.divide;


public final class App {
    public int divide(int dividend, int divisor) {

        int dividendSign = 1;
        int divisorSign = 1;

        if (dividend < 0){
            dividendSign = -1;
            dividend *= dividendSign;
        }

        if (divisor < 0){
            divisorSign = -1;
            divisor *= divisorSign;
        }

        int ret = 0;
        while (dividend >= divisor){
            ret++;
            dividend -= divisor;
        }
        return ret * dividendSign * divisorSign;        
    }
}
