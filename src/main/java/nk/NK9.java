package nk;

import static nk.NK.insertList;
import static nk.NK.print;

public class NK9 {

    public Node removeRepeatNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node hair = new Node();
        hair.next = head;
        Node cur = head;
        Node pre = hair;

        while (cur != null) {
            Node last = null;
            while (cur.next != null && cur.next.value == cur.value) {
                last = cur;
                cur = cur.next;
            }
            if (pre.next != cur) {
                last.next = null;
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        head = hair.next;
        hair.next = null;
        return head;

    }

    public static void main(String[] args) {
        NK9 nk9 = new NK9();
        Node head = insertList(new int[]{1, 1, 2, 3, 4, 4, 5, 6, 7});
        print(head);
        Node node = nk9.removeRepeatNode(head);
        print(node);


        head = insertList(new int[]{1, 1,2});
        print(head);
        node = nk9.removeRepeatNode(head);
        print(node);


        head = insertList(new int[]{1, 1,1});
        print(head);
        node = nk9.removeRepeatNode(head);
        print(node);


        head = insertList(new int[]{1, 2,3,4});
        print(head);
        node = nk9.removeRepeatNode(head);
        print(node);
    }
}
