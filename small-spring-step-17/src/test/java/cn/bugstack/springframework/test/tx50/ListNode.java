package cn.bugstack.springframework.test.tx50;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-02 1:40 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
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
