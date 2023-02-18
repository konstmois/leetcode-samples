package algoexpert.trees;

// https://www.algoexpert.io/questions/binary-tree-diameter
public class BinaryTreeDiameter {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        int diameter = diameter(tree);
        int diameterLeft = diameter(tree.left);
        int diameterRight = diameter(tree.right);
       return Math.max(diameter, Math.max(diameterLeft, diameterRight));
    }

    public int diameter(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        int heightLeft = height(tree.left, 0);
        int heightRight = height(tree.right,0);
        return heightLeft + heightRight;
    }

    private int height(BinaryTree tree, int height) {
        if (tree == null) {
            return height;
        }
        return Math.max(height(tree.left, height+1), height(tree.right, height+1));
    }
}
