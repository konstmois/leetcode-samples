package algoexpert.dynamic;

// https://www.algoexpert.io/questions/number-of-ways-to-traverse-graph
public class NumberOfWaysToTraverseGraph {

    public int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] ways = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || j == 0) {
                    ways[i][j] = 1;
                } else {
                    ways[i][j]=ways[i-1][j] + ways[i][j-1];
                }
            }
        }
        return ways[width-1][height-1];
    }
}
