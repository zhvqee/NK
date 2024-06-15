package nk;

import static nk.NK.insertList;
import static nk.NK.print;

public class NK10 {

    public Node orderCows(Node head, int x) {
        Node hair = new Node();
        Node cur = head;
        Node insert = hair;
        Node newHead = null;
        Node pre = null;
        while (cur != null) {
            if (cur.value < x) {
                Node next = cur.next;
                cur.next = null;
                insert.next = cur;
                insert = insert.next;
                if (pre != null) {
                    pre.next = next;
                }
                cur = next;
            } else {
                if (newHead == null) {
                    newHead = cur;
                }
                pre = cur;
                cur = cur.next;

            }
        }
        insert.next = newHead;
        return hair.next;
    }

    public static void main(String[] args) {
        // 4,4,2,5,2,3;; 3
        // 1,1,4,3,2,;;2

        NK10 nk10 = new NK10();
        Node head = insertList(new int[]{4, 4, 2, 5, 2, 3});
        print(head);
        Node node = nk10.orderCows(head, 3);
        print(node);

        head = insertList(new int[]{1, 1, 4, 3, 2});
        print(head);
        node = nk10.orderCows(head, 2);
        print(node);

    }
}
