package algoexpert.recursion;

import java.util.HashMap;

// https://www.algoexpert.io/questions/nth-fibonacci
public class Fibonachi {

    public static int getNthFib(int n) {
        HashMap<Integer, Integer> results = new HashMap<>();
        return getNthFib(n, results);
    }

    public static int getNthFib(int n, HashMap<Integer, Integer> results) {
        if (n > 2) {
            if (results.containsKey(n)) {
                return results.get(n);
            } else {
                int result = getNthFib(n-1) + getNthFib(n-2);
                results.put(n, result);
                return result;
            }
        } else if (n==2){
            return 1;
        } else {
            return 0;
        }
    }
}
