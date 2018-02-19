package ch05;

/**
 * 5.8
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 * 测试样例：
 * {1,2,3,4,3,2,1},2
 * {1,3,4,3,1}
 */
public class ClearValue {
    public ListNode clear(ListNode head, int num) {
        // 删除头节点直到头节点不为num
        while (head != null) {
            if (head.val != num)
                break;
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == num)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] data = {16, 14};
        ListNode head = ListNode.makeList(data);
        ClearValue clearValue = new ClearValue();
        head = clearValue.clear(head, 16);
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
