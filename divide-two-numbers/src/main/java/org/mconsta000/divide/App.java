package org.mconsta000.divide;


public final class App {
    private final static int SIGNED_WIDTH = 31;
    private final static int MASK = 0x60000000;


    protected int buildMask(int size) {
        int bit_mask = 0x40000000;
        int mask = 0;

        for (int i=0; i<size; i++) {
            mask = mask | bit_mask;
            bit_mask = bit_mask >> 1;
        }
        return mask;
    }

    protected int extract(int dividend, int mask, int mask_size, int bit_pos) {
        int work = dividend & mask;
        return (work >> (bit_pos + 1 - mask_size));
    }

    public int divide(int dividend, int divisor) {
        int mask_size = Integer.highestOneBit(divisor);
        int mask = buildMask(mask_size);
        int remainder = 0;
        int answer = 0;

        for (int i=30; i>=(mask_size-1); i--) {
            int work = extract(dividend, mask, mask_size, i) + remainder;

            answer = (answer << 1); 
            mask = mask >> 1;
            if (work >= divisor) {
                remainder = work - divisor;
                answer = answer | 0x00000001;
            }
        }

        return answer;
    }
}
