package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 3:39 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class DelNodeTest2 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }



    ListNode node4 = new ListNode(9);
    ListNode node3 = new ListNode(1, node4);
    ListNode node2 = new ListNode(5, node3);
    ListNode temHead  = new ListNode(4, node2);

    @Test
    public void test() {
        deleteNode(node2);

        printNode(temHead);
    }

    private void printNode(ListNode node) {
        while (node != null){
            System.out.println(node.val + "\t");
            node = node.next;
        }
    }



}
