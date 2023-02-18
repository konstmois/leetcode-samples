package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

// https://www.algoexpert.io/questions/product-sum
public class ProductSum {

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int depth) {
        int result = 0;
        for (int i = 0; i < array.size(); i++) {
            result += array.get(i) instanceof ArrayList
                    ? productSum((List<Object>) array.get(i), depth + 1)
                    : (Integer) array.get(i);
        }
        return result * depth;
    }
}
