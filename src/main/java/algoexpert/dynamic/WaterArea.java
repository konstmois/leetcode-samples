package algoexpert.dynamic;

// https://www.algoexpert.io/questions/water-area
public class WaterArea {

    public static int waterArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        return waterArea(0, 0, heights);
    }

    public static int waterArea(int leftIndex, int sum, int[] heights) {
        if (leftIndex == heights.length - 1) {
            return sum;
        }
        //searching for candidate
        int rightCandidate = leftIndex + 1;
        for (int rightIndex = leftIndex + 1; rightIndex < heights.length; rightIndex++) {
            if (heights[rightIndex] > heights[rightCandidate]) {
                rightCandidate = rightIndex;
            }
            if (heights[rightCandidate] >= heights[leftIndex]) {
                break;
            }
        }

        //area calculation
        int area = Math.min(heights[leftIndex], heights[rightCandidate]) * (rightCandidate - leftIndex - 1);
        for (int i = leftIndex + 1; i < rightCandidate; i++) {
            area -= heights[i];
        }

        //next "glass" area calculation
        return waterArea(rightCandidate, sum + area, heights);
    }

}
