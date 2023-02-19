package algoexpert.graphs;

// https://www.algoexpert.io/questions/single-cycle-check
public class SingleCycleCheck {

    /**
     * Для проверки цикличности переходов в массиве достаточно проверить два условия:
     * Если длина массива = n, то
     * 1. В течение n-1 переходов мы не посещаем начало массива второй раз
     * 2. n-ый переход должен быть переходом в начало массива
     *
     * @param array
     * @return
     */
    public static boolean hasSingleCycle(int[] array) {
        int nextIndex = getNextIndex(array, 0);
        for (int jumps = 1; jumps < array.length; jumps++) {
            if (nextIndex == 0) {
                return false;
            } else {
                nextIndex = getNextIndex(array, nextIndex);
            }
        }
        return nextIndex == 0;
    }

    private static int getNextIndex(int[] array, int nextIndex) {
        int nextCandidate = (nextIndex + array[nextIndex]) % array.length;
        if (nextCandidate < 0) {
            nextIndex = array.length + nextCandidate;
        } else {
            nextIndex = nextCandidate;
        }
        return nextIndex;
    }
}
