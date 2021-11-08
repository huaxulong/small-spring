package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-04 2:55 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class SortNodeListTest {

    /**
     * 规定时间复杂度是 O(NLogN), 所以考虑使用归并算法进行排序。
     * 先进行  二分排序，  然后左结果归并
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);

        ListNode sortList = merge(list1, list2);
        return sortList;
    }

    /**
     * 结果归并
     *
     * @param head1 在内部是一个有序的链表结构
     * @param head2
     * @return
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }

        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode node1 = sortList(node);
        printNode(node1);
    }

    private void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "\t" + "->" + "\t");
            node = node.next;
        }
    }

}
