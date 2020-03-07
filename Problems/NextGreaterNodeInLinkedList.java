import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode next     = new ListNode(1);
        listNode.next = next;
        next.next = new ListNode(5);
        System.out.println(Arrays.toString(nextLargerNodes(listNode)));
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            nums.add(cur.val);
        }
        int[] answers = new int[nums.size()];


        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.size(); i++) {
            while (!stack.empty() && nums.get(stack.peek()) < nums.get(i)) {
                answers[stack.pop()] = nums.get(i);
            }
            stack.push(i);
        }

        return answers;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


