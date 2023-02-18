package algoexpert.trees;

// https://www.algoexpert.io/questions/find-successor
public class FindSuccessor {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        return find(tree, node);
    }

    public BinaryTree find(BinaryTree tree, BinaryTree node) {
        if (tree != null) {
            //Если нашли ноду - идем искать следующую, которая будет посещена
            if (node.value == tree.value) {
                return findSuccessor(tree);
            } else {
                // Если не нашли, идем налево, потом направо
                BinaryTree left = find(tree.left, node);
                if (left == null) {
                    return find(tree.right, node);
                } else {
                    return left;
                }

            }
        }
        return null;
    }

    private BinaryTree findSuccessor(BinaryTree tree) {
        if (tree.right != null) {
            // Если существует правое поддерево,
            // то следующей посещенной нодой будет сама левая в правом поддереве
            return findSuccessorInRightSubtree(tree.right);
        } else {
            //Если поддерева нет,
            // то следующей посещенной будет родитель, у которого текущая нода является левым дитем
            return findSuccessorInParents(tree);
        }
    }

    private BinaryTree findSuccessorInParents(BinaryTree tree) {
        int value = tree.value;
        tree = tree.parent;
        while (tree != null) {
            if (tree.left != null && tree.left.value == value) {
                return tree;
            } else {
                value = tree.value;
                tree = tree.parent;
            }
        }
        return null;
    }

    private BinaryTree findSuccessorInRightSubtree(BinaryTree tree) {
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }
}
