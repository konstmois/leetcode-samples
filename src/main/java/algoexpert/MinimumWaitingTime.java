package algoexpert;

import java.util.Arrays;

//https://www.algoexpert.io/questions/minimum-waiting-time
public class MinimumWaitingTime {

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int result = 0;
        for (int i=0; i<queries.length-1; i++){
            result += queries[i]*(queries.length-i-1);
        }
        return result;
    }
}
