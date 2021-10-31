package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 2:45 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class DelNodeTest {



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode node){
            val = x;
            next = node;
        }
    }

    public void deleteNode(ListNode temHead, ListNode node) {
        while (temHead != null){
            if (temHead.next != null){
                if (node.val == temHead.next.val){
                    ListNode next1 = temHead.next.next;
                    temHead.next = next1;
                    break;
                }
            }
            temHead = temHead.next;
        }

    }

    @Test
    public void test() {
        ListNode node4 = new ListNode(9);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(5, node3);
        ListNode temHead  = new ListNode(4, node2);

        ListNode node = new ListNode(1);

        deleteNode(temHead, node);

        printNode(temHead);
    }

    private void printNode(ListNode node) {
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

}
