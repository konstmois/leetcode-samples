package algoexpert.greedy;

import java.util.Arrays;

// https://www.algoexpert.io/questions/tandem-bicycle
public class TandemBicycle {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int result = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            if (fastest) {
                result += Math.max(redShirtSpeeds[i], blueShirtSpeeds[blueShirtSpeeds.length - i - 1]);
            } else {
                result += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);

            }
        }
        return result;
    }

}
