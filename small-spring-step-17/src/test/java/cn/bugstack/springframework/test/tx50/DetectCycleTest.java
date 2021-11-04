package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: detectCycleTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-04 11:23 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class DetectCycleTest {

    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();

        //标记下标位置 index
        int index = 0;
        while (head != null && !map.containsKey(head)){
            map.put(head, index);
            head = head.next;
            index ++;
        }
        return head;
    }

    public int getIndexDetectCycle(ListNode head) {
        return 0;
    }

    @Test
    public void test() {
        ListNode node3 = new ListNode(3);

        ListNode node2 = new ListNode(2);

        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node3.next = node2;
        node2.next = node0;
        node0.next = node4;

        node4.next = node2;

        ListNode node = detectCycle(node3);
        System.out.println(node.val);
    }

    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);

        node1.next = node2;
        node2.next = node1;

        ListNode node = detectCycle(node1);
        System.out.println(node.val);
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(1);

        ListNode node = detectCycle(node1);

        System.out.println(node.val);
    }

}
