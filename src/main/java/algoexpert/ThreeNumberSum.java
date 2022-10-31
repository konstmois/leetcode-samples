package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        ArrayList<Integer[]> results = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length-2; i++) {
            results.addAll(twoNumberSum(i, targetSum, array));
        }
        return results;
    }

    private static Collection<? extends Integer[]> twoNumberSum(int i, int targetSum, int[] a) {
        ArrayList<Integer[]> results = new ArrayList<>();
        int left = i + 1;
        int right = a.length - 1;
        int current = a[i];
        while (left < right) {
            int sum = current + a[left] + a[right];
            if (sum == targetSum) {
                results.add(new Integer[]{current, a[left], a[right]});
            } else if (sum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return results;
    }

   /*
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        ArrayList<Integer[]> results = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int complement = targetSum - array[i];
            List<Integer[]> pairs = twoNumberSum(array, complement, i + 1);
            int j = i;
            results.addAll(pairs.stream().map(pair -> sortedTriplet(pair, array[j])).collect(Collectors.toList()));
        }
        return results;
    }


    private static Integer[] sortedTriplet(Integer[] pair, int i) {
        Integer[] triple = {i, pair[0], pair[1]};
        //Arrays.sort(triple);
        return triple;
    }

    private static List<Integer[]> twoNumberSum(int[] array, int targetSum, int start) {
        Set<Integer> previous = new HashSet<>();
        for (int i = start; i < array.length; i++) {
            previous.add(array[i]);
        }

        List<Integer[]> results = new ArrayList<>();
        for (int i = start; i < array.length; i++) {
            int current = array[i];
            int complement = targetSum - current;

            if (previous.contains(complement) && complement != current) {
                results.add(new Integer[]{current, complement});
                previous.remove(complement);
                previous.remove(current);
            }
        }
        return results;
    }*/
}
