package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(getPermutations(List.of(1,2,3)));
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            result.addAll(getPermutations(i, new ArrayList<>(array)));
        }
        return result;
    }

    public static List<List<Integer>> getPermutations(int index, List<Integer> array) {
        List<List<Integer>> results = new ArrayList<>();
        if (array.size() != 1) {
            int number = array.remove(index);
            for (int i = 0; i < array.size(); i++) {
                List<List<Integer>> mutations = getPermutations(i, new ArrayList<>(array));
                for (List<Integer> mutation : mutations) {
                    List<Integer> result = new ArrayList<>();
                    result.add(number);
                    result.addAll(mutation);
                    results.add(result);
                }
            }
        } else {
            results.add(array);
        }
        return results;
    }
}
