package ch05;

/**
 * 5.7
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */
public class KInverse {
    public ListNode inverse(ListNode head, int k) {
        // write code here
        if (k < 2)
            return head;

        ListNode cur = head;
        ListNode start;
        ListNode pre = null;
        ListNode next;
        int count = 1;

        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                reverse(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }

        return head;
    }

    /**
     * 反转局部链表
     * @param left 局部链表头节点的前一个节点
     * @param start 局部链表的头节点
     * @param end 局部链表的尾节点
     * @param right 局部链表尾节点的后一个节点
     */
    public void reverse(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = start;
        ListNode cur = pre.next;
        ListNode next;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null)
            left.next = end;
        start.next = right;
    }

    public static void main(String[] args) {
        KInverse kInverse = new KInverse();
        int[] data = {0, 1, 2, 5, 11};
        ListNode head = ListNode.makeList(data);
        head = kInverse.inverse(head, 2);
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
