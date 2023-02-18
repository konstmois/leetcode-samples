package algoexpert.bst;

// https://www.algoexpert.io/questions/find-closest-value-in-bst
public class FindClosestValueInBST {
    public static int findClosestValueInBst(BST tree, int target) {
        BST current = tree;
        int candidate = current.value;
        while (current != null) {
            int currValue = current.value;
            if (currValue == target) {
                return currValue;
            }
            if (Math.abs(candidate - target) > Math.abs(currValue - target)) {
                candidate = currValue;
            }
            if (currValue > target) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return candidate;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
