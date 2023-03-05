package algoexpert.dynamic;

// https://www.algoexpert.io/questions/levenshtein-distance
public class LevenshteinDistance {

    public static void main(String[] args) {
        levenshteinDistance("abc", "yabd");
    }

    public static int levenshteinDistance(String str1, String str2) {
        int[][] array = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == 0) {
                    array[i][j] = j;
                } else if (j == 0) {
                    array[i][j] = i;
                } else {
                    int curStr1 = i - 1;
                    int curStr2 = j - 1;
                    if (str1.charAt(curStr1) == str2.charAt(curStr2)) {
                        array[i][j] = array[i - 1][j - 1];
                    } else {
                        array[i][j] = 1 + Math.min(
                                array[i - 1][j - 1],
                                Math.min(
                                        array[i - 1][j],
                                        array[i][j - 1]
                                )
                        );
                    }
                }

            }
        }
        return array[str1.length()][str2.length()];
    }

}
