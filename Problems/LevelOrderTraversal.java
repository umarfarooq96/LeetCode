import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class LevelOrderTraversal {

    static public List<List<Integer>> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;

        while(!queue.isEmpty()){

            List<Node> nodesOfThisLevel = new ArrayList<>();
            List<Integer> thisLevel = new ArrayList<>();

            while(!queue.isEmpty()){
                Node remove = queue.remove();
                nodesOfThisLevel.add(remove);
                thisLevel.add(remove.val);
            }

            ret.add(thisLevel);

            nodesOfThisLevel.forEach(node -> {
                queue.addAll(node.children);
            });
        }

        return ret;
    }

    public static void main(String[] args) {
        Node root = new Node(1, asList(new Node(3, asList(new Node(5, emptyList()), new Node(6, emptyList()))),
                                       new Node(2, emptyList()),
                                       new Node(4, emptyList())));

        System.out.println(levelOrder(root));
    }

    static class Node {
        int val;
        List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

