package nk;

import static nk.NK.insertList;
import static nk.NK.print;

public class NK6 {
    public Node rotate(Node head, int k) {
        if (head == null) {
            return null;
        }
        int[] position = getLengthAndKPosition(head, k);
        Node cur = head;
        k = position[1];
        if (k == position[0] - 1) {
            return head;
        }
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        Node next = cur.next;
        cur.next = null;
        cur = next;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return next;
    }

    private int[] getLengthAndKPosition(Node head, int k) {
        int len = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return new int[]{len, k % len};
    }

    public static void main(String[] args) {
        NK6 nk6 = new NK6();
        Node head = insertList(new int[]{1, 2, 3, 4, 5, 6, 7});

        Node rotate = nk6.rotate(head, 6);
        print(rotate);

    }
}
