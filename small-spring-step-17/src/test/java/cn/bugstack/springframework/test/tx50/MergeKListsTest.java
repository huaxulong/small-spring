package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-02 10:58 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MergeKListsTest {

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

    public ListNode mergeKLists(ListNode[] lists) {
        // 新增dumpy node 节点
        ListNode node = new ListNode();

        int size = lists.length;
        // 依次遍历每个 每一个node，依次把数据最小的放入node

        retry:
        while (lists != null && size != 0){
            // 最小值下标
            int index = 0;
            // 最小值数值
            int count = Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                if (lists[i] != null){
                    if (lists[i].val == Math.min(lists[i].val, count)){
                        index = i;
                        count = lists[i].val;
                    }
                }else {
                    // remove null 元素
                    size = removeNull(size, i, lists);
                    continue retry;
                }
            }

            // 插入node头部
            node = new ListNode(count, node);

            // 删除对应节点
            if (lists[index].next != null){
                lists[index] = lists[index].next;
            }else {
                size = removeNull(size, index, lists);
            }
        }
        // 翻转 node
        ListNode reverse = reverse(node);

        // 去掉头节点
        return reverse.next;
        // 返回
    }

    private int removeNull(int size, int index, ListNode[] lists){
        if (size == 1){
            size = 0;
        }else {
            if (lists[size - 1] != null){
                lists[index] = lists[size - 1];
                lists[size - 1] = null;
            }
            size = size - 1;
        }
        return size;
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


    @Test
    public void test() {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));

        ListNode[] nodes = {node1, node2, node3};

        ListNode node = mergeKLists(nodes);

        printNode(node);
    }

    @Test
    public void test1() {
        ListNode node = null;
        ListNode node1 = new ListNode(1);
        ListNode[] list = {node, node1};
        ListNode nd = mergeKLists(list);

        printNode(nd);

    }

    @Test
    public void test2() {
        ListNode node = new ListNode(2);
        ListNode node1 = null;
        ListNode node2 = new ListNode(-1);
        ListNode[] list = {node, node1, node2};
        ListNode nd = mergeKLists(list);

        printNode(nd);
    }

    private void printNode(ListNode node) {
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }


}
