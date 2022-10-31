package algoexpert;

import java.util.Objects;

import static java.util.Objects.isNull;

//https://www.algoexpert.io/questions/validate-bst
public class ValidateBST {

    public static boolean validateBst(BST tree) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return validateBst(tree, min, max);
    }

    public static boolean validateBst(BST tree, int min, int max) {
        return isNull(tree)
                ||
                (
                        tree.value >= min
                                && tree.value < max
                                && (validateBst(tree.left, min, tree.value) && validateBst(tree.right, tree.value, max))
                );
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
