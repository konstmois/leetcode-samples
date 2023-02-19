package algoexpert.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(this);
            bfs(array, queue);
            return array;
        }

        private void bfs(List<String> array, Queue<Node> queue) {
            Node current = queue.poll();
            if (current != null) {
                array.add(current.name);
                queue.addAll(current.children);
                bfs(array, queue);
            }
        }


        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
