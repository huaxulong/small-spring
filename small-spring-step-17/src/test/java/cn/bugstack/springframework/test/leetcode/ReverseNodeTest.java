package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-28 11:23 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class ReverseNodeTest {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        int count = 1; // 用来统计链表总结点数
        ListNode tmp = head;
        while (tmp.next != null) {
            count++;
            tmp = tmp.next;
        }

        // 当k为0时，不需要旋转，
        if (k == 0) return head;

        // 不满足上述条件，必将进行旋转，所以先将首尾相连
        tmp.next = head;

        // 现在只需要找到倒数第k+1个节点
        for (int i = 0; i < count - k; i++) {
            tmp = tmp.next;
        }
        ListNode newHead = tmp.next;
        tmp.next = null;
        return newHead;
    }

    public ListNode reverse(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode tail = new ListNode(head.val);
        while (head != null){
            if (head.next != null){
                tail = new ListNode(head.next.val, tail);
                head = head.next;
            }else {
                break;
            }
        }
        return tail;
    }


    @Test
    public void test() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        ListNode listNode = reverse(node);
        print(listNode);

        /*delTail(node);
        print(node);*/

    }

    private void print(ListNode listNode) {
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
