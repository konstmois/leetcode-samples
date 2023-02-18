package algoexpert.arrays;

import java.util.Arrays;

// https://www.algoexpert.io/questions/non-constructible-change
public final class NonConstructibleChange {

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int change = 0;
        int idx = 0;

        while (idx < coins.length) {
            if (coins[idx] > change+1) {
                return change+1;
            } else {
                change+=coins[idx];
            }
            idx++;
        }

        return change+1;
    }
}
