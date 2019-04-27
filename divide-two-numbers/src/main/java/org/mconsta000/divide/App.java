package org.mconsta000.divide;


public final class App {
    public int divide(int dividend, int divisor) {
        boolean negate = false;
        long lDividend = dividend;
        long lDivisor = divisor;
        long remainder = 0;
        long bit_mask = 0x80000000l;

        if (lDividend < 0) {
            negate = !negate;
            lDividend = (lDividend ^ -1) + 1;
        }

        if (lDivisor < 0) {
            negate = !negate;
            lDivisor = (lDivisor ^ -1) + 1;
        }
 
        long mask = 0;
        long answer = 0;

        for (int i=31; i>=0; i--) {
            // build the dividend mask            
            mask = mask | bit_mask;

            // increment the bit_mask
            bit_mask = bit_mask >> 1;

            // extract the bits using the bit_mask
            remainder = remainder << 1;
            long work = ((lDividend & mask) >> i) | remainder;

            // calculate next bit
            answer = (answer << 1); 
            if (work >= lDivisor) {
                remainder = work - lDivisor;
                answer = answer | 0x00000001;
                mask = 0;
            }
        }

        if (negate) {
            answer = (answer - 1) ^ -1;
        }

        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
            answer = Integer.MAX_VALUE;
        }
        
        return (int)answer;
    }
}
