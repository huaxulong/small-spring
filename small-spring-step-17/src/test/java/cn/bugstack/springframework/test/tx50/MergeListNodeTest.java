package cn.bugstack.springframework.test.tx50;

import org.junit.Test;


/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-01 4:57 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MergeListNodeTest {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 头节点是 dumply 节点
        ListNode node = new ListNode(0);
        node = compare(node, l1, l2);
        node = reverse(node);
        return node.next;
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

    private ListNode compare(ListNode node, ListNode l1, ListNode l2) {
        while (l1 != null || l2 != null){
            if (l1 == null){
                node = new ListNode(l2.val, node);
                l2 = l2.next;
                continue;
            }
            if (l2 == null){
                node = new ListNode(l1.val, node);
                l1 = l1.next;
                continue;
            }
            if (l1.val < l2.val){
                // 添加 l1 节点
                node = new ListNode(l1.val, node);
                l1 = l1.next;
            }else {
                node = new ListNode(l2.val, node);
                l2 = l2.next;
            }
        }
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode node){
            val = x;
            next = node;
        }
    }

    @Test
    public void test() {
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2, node4);
        ListNode nodel1 = new ListNode(1, node2);

        ListNode node4l2 = new ListNode(4);
        ListNode node3l2 = new ListNode(3, node4l2);
        ListNode node1l2 = new ListNode(1, node3l2);

        ListNode node = mergeTwoLists(nodel1, node1l2);

        printNode(node);
    }

    private void printNode(ListNode node) {
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

}
