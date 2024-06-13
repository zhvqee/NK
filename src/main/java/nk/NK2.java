package nk;

import static nk.NK.insertList;
import static nk.NK.print;

public class NK2 {

    public Node removeRepeatNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node hair = new Node();
        hair.next = head;
        Node cur = head;
        Node pre = hair;

        while (cur != null) {
            while (cur.next != null && cur.next.value == cur.value) {
                cur = cur.next;
            }
            //找到最后一个不同的元素
            if (pre.next == cur) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        head = hair.next;
        hair.next = null;
        return head;

    }

    public static void main(String[] args) {
        NK2 nk2 = new NK2();
        Node head = insertList(new int[]{1, 1, 2, 3, 4, 4, 5, 6, 7});
        print(head);
        Node node = nk2.removeRepeatNode(head);
        print(node);


        head = insertList(new int[]{1, 2, 3, 4, 4, 5, 6, 7});
        print(head);
        node = nk2.removeRepeatNode(head);
        print(node);


        head = insertList(new int[]{1, 2, 3, 4, 4, 5, 6, 7, 7});
        print(head);
        node = nk2.removeRepeatNode(head);
        print(node);

    }
}
