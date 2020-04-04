import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = { null };
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        for (ListNode heads : lists) {
            if (heads != null) {
                minHeap.add(heads);
            }
        }
        ListNode head = minHeap.poll();
        ListNode cur  = head;
        if (cur.next != null) {
            minHeap.add(cur.next);
        }
        while (!minHeap.isEmpty()) {
            ListNode cur_min = minHeap.poll();
            cur.next = cur_min;
            cur = cur_min;
            if (cur != null && cur.next != null) {
                minHeap.add(cur.next);
            }
        }

        return head;
    }
}
