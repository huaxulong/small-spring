package cn.bugstack.springframework.test.tx50;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 3:39 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class DelNodeTest2 {

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

    ListNode node4 = new ListNode(9);
    ListNode node3 = new ListNode(1, node4);
    ListNode node2 = new ListNode(5, node3);
    ListNode temHead  = new ListNode(4, node2);



}
