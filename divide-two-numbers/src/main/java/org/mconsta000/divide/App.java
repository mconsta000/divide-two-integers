package org.mconsta000.divide;


public final class App {
    protected long buildMask(long size) {
        long bit_mask = 0x80000000l;
        long mask = 0;

        for (int i=0; i<size; i++) {
            mask = mask | bit_mask;
            bit_mask = bit_mask >> 1;
        }
        return mask;
    }

    protected long extract(long dividend, long mask, long mask_size, int bit_pos) {
        long work = dividend & mask;
        return (work >> (bit_pos + 1 - mask_size));
    }

    public int divide(int dividend, int divisor) {
        boolean negate = false;
        long lDividend = dividend;
        long lDivisor = divisor;

        if (lDividend < 0) {
            negate = !negate;
            lDividend = (lDividend ^ -1) + 1;
        }

        if (lDivisor < 0) {
            negate = !negate;
            lDivisor = (lDivisor ^ -1) + 1;
        }
 
        long mask_size = 64 - Long.numberOfLeadingZeros(lDivisor);
        long mask = buildMask(mask_size);
        long answer = 0;

        for (int i=31; i>=(mask_size-1); i--) {
            long work = extract(lDividend, mask, mask_size, i);

            answer = (answer << 1); 
            mask = mask >> 1;
            if (work >= lDivisor) {
                answer = answer | 0x00000001;
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
