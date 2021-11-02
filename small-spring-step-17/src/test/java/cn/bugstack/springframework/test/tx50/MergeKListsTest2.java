package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: MergeKListsTest2
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-02 3:40 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MergeKListsTest2 {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (true) {
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minPointer == -1) {
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));

        ListNode[] nodes = {node1, node2, node3};

        ListNode node = mergeKLists(nodes);

        printNode(node);
    }

    private void printNode(ListNode node) {
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

}
