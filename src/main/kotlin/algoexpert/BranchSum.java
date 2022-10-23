package algoexpert;

import java.util.*;

//https://www.algoexpert.io/questions/branch-sums
class BranchSum {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void sumToList(List<Integer> list, int sum){
            int currentSum = sum + this.value;
            if (this.left != null) {
                this.left.sumToList(list, currentSum);
            }
            if (this.right != null) {
                this.right.sumToList(list, currentSum);
            }
            if (this.right == null && this.left == null) {
                list.add(currentSum);
            }
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        root.sumToList(result,0);
        return result;
    }


}
