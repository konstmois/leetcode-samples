package algoexpert.dynamic;

// https://www.algoexpert.io/questions/number-of-ways-to-make-change
public class NumberOfWaysToMakeChange {


    /**
     * Генерируем массив длины n+1.
     * Индекс в массиве = таргет сумма
     * Значение в массиве = количество способов представить данную сумму
     * Идем по всем представленным номиналам.
     * И для каждого номинала идем по массиву
     * Если текущий номинал "помещается" в текущей сумме (индексе в массиве),
     * то к количеству способов для этой суммы прибавляем количество способов для суммы [текущая минус текущий номинал]
     * @param n - таргет сумма
     * @param denoms - номиналы монет
     * @return количество способов представления
     */
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if (n == 0) {
            return 1;
        }
        int[] ways = new int[n+1];
        ways[0] = 1;
        for (int denom : denoms) {
            for (int i = 0; i < ways.length; i++) {
                if (i >= denom) {
                    ways[i] += ways[i - denom];
                }
            }
        }
        return ways[ways.length - 1];
    }
}
