package algoexpert.arrays;

import java.util.List;

// https://www.algoexpert.io/questions/validate-subsequence
public class ValidateSubsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int currentPos = 0;
        int currentSearchValue =sequence.get(currentPos);
        for (int i : array) {
            if (i == currentSearchValue) {
                if (currentPos == sequence.size()-1) {
                    return true;
                }
                currentPos++;
                currentSearchValue=sequence.get(currentPos);
            }
        }
        return false;
    }
}
