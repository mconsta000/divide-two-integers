package org.mconsta000.divide;


public final class App {
    public int divide(int dividend, int divisor) {
        int answer = 0;
        int template = 1;
        int base = Integer.bitCount(iDivisor);
        int leftOver = 0;

        for (int i=31; i>=base; i--) {
            int mask = template << i;
            int current = (iDividend & mask) + leftOver;

            answer = answer << 1;
            if (iDivisor <= current) {
                answer = answer | 1;
                template = 1;
                leftOver = current - iDivisor;
            }
            else {
                template = template << 1;
                template = template | 1;
            }
        }

        return answer;
    }
}
