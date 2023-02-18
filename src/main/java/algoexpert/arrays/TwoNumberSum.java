package algoexpert.arrays;

import java.util.HashSet;
import java.util.Set;

// https://www.algoexpert.io/questions/two-number-sum
public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            int complement = targetSum - i;
            if (set.contains(complement)) {
                return new int[]{i, complement};
            } else {
                set.add(i);
            }

        }
        return new int[]{};
    }
}
