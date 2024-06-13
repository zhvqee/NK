package nk;

import static nk.NK.*;

public class NK1 {

    public Node reverseList(Node head, int n, int m) {
        int i = 0;
        Node newHead = new Node();
        newHead.next = head;

        Node pre = newHead;
        while (i < n - 1) {
            pre = pre.next;
            i++;
        }
        int left = m - n;
        Node tail = pre.next;
        while (left > 0) {
            tail = tail.next;
            left--;
        }
        pre.next = reverseList(pre.next, tail);
        head = newHead.next;
        newHead.next = null;
        return head;

    }

    private Node reverseList(Node next, Node tail) {
        Node head = new Node();
        Node p = next;
        Node end = tail.next;
        Node pp = null;
        while (p != end) {
            pp = p.next;
            p.next = head.next;
            head.next = p;
            p = pp;
        }
        next.next = end;
        Node newHead = head.next;
        head.next = null;
        return newHead;
    }



    public static void main(String[] args) {
        NK1 nk1 = new NK1();
        Node head = insertList(new int[]{1, 2, 3, 4, 5, 6, 7});
        print(head);

        Node head1 = nk1.reverseList(cpy(head), 1,3);
        print(head1);

        Node head2 = nk1.reverseList(cpy(head), 1,7);
        print(head2);


        Node head3 = nk1.reverseList(cpy(head), 2,6);
        print(head3);

        Node head4 = nk1.reverseList(cpy(head), 6,7);
        print(head4);
    }

}
