package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-30 4:21 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class DeleteNodeCntTest {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        // 使用两个指针， first 和 second 同时对链表进行遍历
        ListNode first = dummy;
        ListNode second = head;

        int count = 1;
        while (second != null){
            if (second.next == null){
                ListNode temp = first.next.next;
                first.next = null;
                first.next = temp;
            }
            if (count >= n){
                first = first.next;
            }
            second = second.next;
            count ++;
        }
        return first;
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


    @Test
    public void test() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1, node2);

        ListNode listNode = removeNthFromEnd(node, 2);
        print(listNode);
    }

    private void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
