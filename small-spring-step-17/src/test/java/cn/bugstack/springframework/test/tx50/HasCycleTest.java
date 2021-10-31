package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 3:46 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class HasCycleTest {

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

    /**
     * 判断列表中是否有环， 可以定义一个快慢指针， 直到慢指针追上了 快指针，则说明链表有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        while (slow != fast){
            if (fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(2);

        ListNode node = new ListNode(1, node1);

        System.out.println(hasCycle(null));
    }

}
