package nk;

import java.util.HashMap;
import java.util.Map;

import static nk.NK.print;

public class NK7 {

    public static class LRU {
        private Map<Integer, Node> nodeMap = new HashMap<>();
        private Node head = new Node();
        private Node tail = head;
        private int size = 0;
        private int capacity;

        public LRU(int capacity) {
            this.capacity = capacity;
        }

        public String get(int key) {
            Node node = getNode(key);
            return node == null ? "null" : node.value + "";
        }

        private Node getNode(int key) {
            Node cur = nodeMap.get(key);
            if (cur == null) {
                return null;
            }
            if (cur == tail) {
                tail = tail.prev;
            }
            Node prev = cur.prev;
            Node next = cur.next;
            cur.prev = null;
            cur.next = null;

            prev.next = next;
            if (next != null) {
                next.prev = prev;
            }


            cur.next = head.next;
            head.next.prev = cur;
            head.next = cur;
            cur.prev = head;
            return cur;
        }

        public void set(int key, int value) {
            Node node1 = getNode(key);
            if (node1 == null) {
                Node node = new Node(value);
                nodeMap.put(key, node);
                node.next = head.next;
                node.prev = head;
                if (head.next != null) {
                    head.next.prev = node;
                } else {
                    tail = node;
                }
                head.next = node;
                size++;
                if (size > capacity) {
                    tail = tail.prev;
                    tail.next.prev = null;
                    tail.next = null;
                }
            } else {
                node1.value = value;
            }
        }
    }

    public static void main(String[] args) {
        NK7 nk6 = new NK7();
        LRU lru = new LRU(6);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);
        lru.set(5, 5);
        lru.set(6, 6);
        print(lru.head);
        lru.get(1);
        print(lru.head);
        lru.get(2);
        print(lru.head);
        lru.set(7,7);
        print(lru.head);
    }
}
