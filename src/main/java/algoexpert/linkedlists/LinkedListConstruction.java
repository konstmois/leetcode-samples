package algoexpert.linkedlists;

// https://www.algoexpert.io/questions/linked-list-construction
public class LinkedListConstruction {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head != null) {
                insertBefore(head, node);
            } else {
                head = node;
                tail = node;
            }
        }

        public void setTail(Node node) {
            if (tail != null) {
                insertAfter(tail, node);
            } else {
                head = node;
                tail = node;
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (node.next == null) {
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
            } else {
                Node current = head;
                int i = 1;
                while (current != null && i != position) {
                    current = current.next;
                    i++;
                }
                if (current != null) {
                    insertBefore(current, nodeToInsert);
                } else {
                    setTail(nodeToInsert);
                }
            }
        }

        public void removeNodesWithValue(int value) {
            Node current = head;
            while (current != null) {
                Node removeCandidate = current;
                current = current.next;
                if (removeCandidate.value == value) {
                    remove(removeCandidate);
                }
            }
        }

        public void remove(Node node) {
            if (node == head) {
                head = head.next;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            removeNodeBindings(node);
        }

        private void removeNodeBindings(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.next = null;
            node.prev = null;
        }

        public boolean containsNodeWithValue(int value) {
            Node current = head;
            while (current != null) {
                if (current.value == value) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
