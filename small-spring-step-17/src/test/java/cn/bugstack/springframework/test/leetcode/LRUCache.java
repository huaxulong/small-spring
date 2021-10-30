package cn.bugstack.springframework.test.leetcode;

/**
 * @description: LRUCache
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-21 4:01 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class LRUCache {

    private int capacity = 16;

    // 头节点
    private Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = head;
        int count = 0;

        while (node != null){

            if (count == capacity){
                node.next = null;
            }

            if (node.key == key){
                int tempKey = node.key;
                int tempValue = node.value;
                removeKey(tempKey);
                addFirst(tempKey, tempValue);
                head = node;
                return tempValue;
            }
            node = node.next;
            count ++;
        }
        return -1;
    }

    private void removeKey(Integer key) {
        // 先断开这个node
        while (head != null){
            if (key == head.key){
                Node prev = head.prev;
                Node next = head.next;
                if (prev != null){
                    head = null;
                    prev.next = next;
                }
                if (next != null){
                    next.prev = prev;
                }
                return;
            }
            head = head.next;
        }
    }

    private void addFirst(int key, int value) {
        Node newFirst = new Node(key, value);
        head.prev = newFirst;
        newFirst.next = head;
        head = newFirst;
    }

    public void put(int key, int value) {
        // node init
        if (head == null){
            head = new Node(key, value);
            return;
        }

        Node node = head;

        // 最多维持长度为 capacity 的链表
        while (node != null){
            if (node != null && key == node.key){
                removeKey(key);

                //中间找到了， 要重新构建这个 node ，放到头节点
                addFirst(key, value);
                return;
            }
            if (node.next == null){
                addTail(key, value);
                return;
            }
            node = node.next;
        }
    }

    /**
     * node 表示最后一个节点
     * @param key
     * @param value
     */
    public void addTail(int key, int value) {
        Node newNode = new Node(key, value);
        while (head != null){
            if (head.next == null){
                head.next = newNode;
                return;
            }
            head = head.next;
        }
    }

    class Node {

        Node next;

        Node prev;

        Integer key;

        Integer value;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }


    // 创建删除节点的方法
    public void delete(Node delNode) {
        Node newNode;
        Node tmp;
        // 删除链表的第一个节点，只需要把链表首指针指向第二个节点即可
        if (head.key == delNode.key) {
            head = head.next;
        }
        //删除链表内的中间节点：只要将删除节点的前一个节点指针指向要删除节点的下一个节点即可
        else {
            newNode = head;
            tmp = head;
            while (newNode.key != delNode.key) {
                tmp = newNode;
                newNode = newNode.next;
            }
            if (newNode.next == null){
                // 表示这个是尾部节点
                for (Node x = head; x != null; x = x.next) {
                    if (x.next.next == null)
                        x.next = null;
                }
            }
            tmp.next = delNode.next;
        }
    }

    private void deleteLastNode() {

    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(2);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }




}
