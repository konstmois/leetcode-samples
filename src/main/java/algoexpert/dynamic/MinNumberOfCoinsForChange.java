package algoexpert.dynamic;


import java.util.Arrays;

// https://www.algoexpert.io/questions/min-number-of-coins-for-change
public class MinNumberOfCoinsForChange {


    public static void main(String[] args) {
        int[] demons = {3, 4, 5};
        minNumberOfCoinsForChange(9, demons);
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        Arrays.sort(denoms);
        int[] numbersOfCoins = new int[n + 1];
        Arrays.fill(numbersOfCoins, Integer.MAX_VALUE);
        numbersOfCoins[0] = 0;
        for (int currentDenom : denoms) {
            for (int currentSum = 0; currentSum < numbersOfCoins.length; currentSum++) {
                if (currentSum >= currentDenom) {
                    if (numbersOfCoins[currentSum - currentDenom] != Integer.MAX_VALUE) {
                        numbersOfCoins[currentSum] = Math.min(
                                numbersOfCoins[currentSum],
                                numbersOfCoins[currentSum - currentDenom] + 1
                        );
                    }
                }
            }
        }

        if (numbersOfCoins[n] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return numbersOfCoins[n];
        }
    }

}
