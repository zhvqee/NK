package nk;

import static nk.NK.*;
import static nk.NK.print;

public class NK5 {
    public Node reverse(Node head) {
        Node hair = new Node();
        while (head != null) {
            Node next = head.next;
            head.next = hair.next;
            hair.next = head;
            head = next;
        }
        head = hair.next;
        hair.next = null;
        return head;
    }

    public static void main(String[] args) {
        NK5 nk5 = new NK5();
        Node head = insertList(new int[]{1, 2, 3, 4, 5, 6, 7});
        print(head);

        Node head1 = nk5.reverse(cpy(head));
        print(head1);

    }
}
