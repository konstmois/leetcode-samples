package algoexpert.trees;

// https://www.algoexpert.io/questions/invert-binary-tree
public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree != null) {
            invertBinaryTree(tree.left);
            invertBinaryTree(tree.right);
            BinaryTree temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
