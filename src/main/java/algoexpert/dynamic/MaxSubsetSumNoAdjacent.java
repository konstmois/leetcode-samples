package algoexpert.dynamic;

// https://www.algoexpert.io/questions/max-subset-sum-no-adjacent
public class MaxSubsetSumNoAdjacent {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] sums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                sums[i] = array[i];
            } else if (i == 1) {
                sums[i] = Math.max(array[i], sums[i-1]);
            } else {
                sums[i] = Math.max(sums[i - 1], sums[i - 2] + array[i]);
            }
        }
        return Math.max(sums[array.length - 1], sums[array.length - 2]);
    }

}
