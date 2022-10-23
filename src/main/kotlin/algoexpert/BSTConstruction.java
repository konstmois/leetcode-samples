package algoexpert;

//https://www.algoexpert.io/questions/bst-construction
public class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST current = this;
            boolean inserted = false;
            while (!inserted) {
                if (current.value > value) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new BST(value);
                        inserted = true;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new BST(value);
                        inserted = true;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            return contains(this, value);
        }

        private boolean contains(BST tree, int value) {
            if (tree == null) {
                return false;
            }
            if (tree.value == value) {
                return true;
            }
            return (tree.value > value)
                    ? contains(tree.left, value)
                    : contains(tree.right, value);
        }

        public BST remove(int value) {
            return this.remove(value, null);
        }

        public BST remove(int value, BST parent) {
            BST current = this;
            boolean removed = false;
            while (!removed) {
                //going to the left to search value to remove
                if (current.value > value) {
                    parent = current;
                    current = current.left;
                    //going to the right to search value to remove
                } else if (current.value < value) {
                    parent = current;
                    current = current.right;
                } else {
                    removed = true;
                    // current have two children
                    if (current.right != null && current.left != null) {
                        current.value = current.right.findMinValue();
                        current.right.remove(current.value, current);
                        // current = root node = parent is null and have one or zero child
                    } else if (parent == null) {
                        //root has left subtree
                        if (current.left != null) {
                            //reassigning root to the left
                            current.value = current.left.value;
                            current.right = current.left.right;
                            current.left = current.left.left;
                        } else if (current.right != null){
                            current.value = current.right.value;
                            current.right = current.right.right;
                            current.left = current.right.left;
                        } else {
                            return null;
                        }
                        // current have one child and not root
                    } else {
                        //left subtree
                        if (parent.left == current) {
                            if (current.left != null) {
                                parent.left = current.left;
                            } else {
                                parent.left = current.right;
                            }
                            //right subtree
                        } else if (parent.right == current) {
                            if (current.left != null) {
                                parent.right = current.left;
                            } else {
                                parent.right = current.right;
                            }
                        }
                    }
                }
            }
            return this;
        }

        private int findMinValue() {
            BST current = this;
            while(current.left != null) {
                current = current.left;
            }
            return current.value;
        }
    }
}
