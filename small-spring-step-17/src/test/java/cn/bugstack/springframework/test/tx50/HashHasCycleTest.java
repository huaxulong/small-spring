package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 4:01 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class HashHasCycleTest {

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
     * 用hash 打标。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        while (head != null){
            if (map.containsKey(head)){
                return true;
            }else {
                map.put(head, true);
            }
            head = head.next;
        }
        return false;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(2);

        ListNode node = new ListNode(1, node1);

        System.out.println(hasCycle(node));
    }

}
