public class ReverseLinkedListFromMToN {

    public static void main(String[] args) {
        ListNode one   = new ListNode(1);
        ListNode two   = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four  = new ListNode(4);
        ListNode five  = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;

        reverseBetween(one, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode cur  = head;

        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        /*
        1->2->3->4->5->NULL, cur is 2, prev is 1


        1<-2<-3<-4->5->NULL
        we want 2->5 and 1->4
        */
        ListNode start   = prev; //1
        ListNode new_end = cur;

        while (n > 0) {
            ListNode next_cur = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next_cur;

            n--;
        }

        if (start != null) {
            start.next = prev;
        } else {
            head = prev;
        }

        new_end.next = cur;
        return head;
    }
}
