import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        List<Node>      nodes             = new ArrayList();
        Map<Node, Node> copyToOriginalMap = new HashMap<>();
        Map<Node, Node> originalToCopyMap = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            Node cur_copy = new Node(cur.val);
            copyToOriginalMap.put(cur_copy, cur);
            originalToCopyMap.put(cur, cur_copy);
            cur = cur.next;
            nodes.add(cur_copy);
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (i + 1 < nodes.size()) {
                nodes.get(i).next = nodes.get(i + 1);
            }
        }

        for (Node n : nodes) {
            Node originalThis   = copyToOriginalMap.get(n); //real 13
            Node originalRandom = originalToCopyMap.get(originalThis.random); //real 7
            Node copiedRandom   = originalToCopyMap.get(originalRandom); //copy 7

            n.random = copiedRandom;
        }

        return nodes.get(0);
    }

    public static void main(String[] args) {
        Node seven    = new Node(7);
        Node thirteen = new Node(13);
        seven.next = thirteen;
        thirteen.next = null;
        seven.random = null;
        thirteen.random = seven;

        System.out.println(copyRandomList(seven));
    }

    // Definition for a Node.
    static class Node {

        int  val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
