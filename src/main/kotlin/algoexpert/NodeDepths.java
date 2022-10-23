package algoexpert;

// https://www.algoexpert.io/questions/node-depths
public class NodeDepths {


    public static int nodeDepths(BinaryTree root) {
        return nodeDepth(root, 0, 0);
    }

    public static int nodeDepth(BinaryTree tree, int currentDepth, int currentSum) {

        int leftSum = 0;
        if (tree.left != null) {
            leftSum = nodeDepth(tree.left, currentDepth + 1, currentSum + currentDepth);
        }
        int rightSum = 0;
        if (tree.right != null) {
            rightSum = nodeDepth(tree.right, currentDepth + 1, currentSum + currentDepth);
        }
        return currentDepth + leftSum + rightSum;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
