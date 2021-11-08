package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-07 6:51 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class GetIntersectionNodeTest {

    Set<ListNode> set = new HashSet<>();

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null || headB != null){
            if (set.contains(headA)){
                return headA;
            }
            if (set.contains(headB)){
                return headB;
            }
            if (headA != null){
                set.add(headA);
            }
            if (headB != null){
                set.add(headB);
            }
            if (headA.next != null){
                headA = headA.next;
            }
            if (headB.next != null){
               headB = headB.next;
            }
        }
        return null;
    }

    @Test
    public void test() {
        ListNode node4 = new ListNode(4);
        ListNode node41 = new ListNode(1);

        ListNode node5 = new ListNode(5);
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);

        ListNode node8 = new ListNode(8);
        ListNode node84 = new ListNode(4);
        ListNode node845 = new ListNode(8);

        node4.next = node41;
        node41.next = node8;

        node5.next = node0;
        node0.next = node1;
        node1.next = node8;

        node8.next = node84;
        node84.next = node845;

        ListNode listNode = getIntersectionNode(node4, node5);

        System.out.println(listNode.val);

    }

}
