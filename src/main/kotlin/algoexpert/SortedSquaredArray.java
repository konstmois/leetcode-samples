package algoexpert;

// https://www.algoexpert.io/questions/sorted-squared-array
public class SortedSquaredArray {

    public int[] sortedSquaredArray(int[] array) {
        int[] out = new int[array.length];
        int j = array.length - 1;
        int i = 0;
        int cur = array.length - 1;
        while (i <= j) {
            int iSquare = array[i] * array[i];
            int jSquare = array[j] * array[j];
            out[cur] = Math.max(iSquare, jSquare);
            cur--;
            if (iSquare > jSquare) {
                i++;
            } else {
                j--;
            }

        }
        return out;
    }
}
