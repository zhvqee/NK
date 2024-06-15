package nk;

import java.util.ArrayList;
import java.util.List;

import static nk.NK.*;

public class NK8 {

    public Node getCircle(Node head) {
        if (head == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return fast;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public int gcd(Node node) {
        List<Integer> num = new ArrayList<>();
        Node p = node;
        num.add(p.value);
        p = p.next;
        while (p != node) {
            num.add(p.value);
            p = p.next;
        }
        return gcd(num);
    }

    private int gcd(List<Integer> num) {
        if (num.size() == 1) {
            return num.get(0);
        }
        int i = 2;
        int c = gcd(num.get(0), num.get(1));
        for (; i < num.size(); i++) {
            c = gcd(c, num.get(i));
        }
        return c;
    }

    public static int gcd(int a, int b) {
        if (b < a) {
            int c = b;
            b = a;
            a = c;
        }
        while (a != 0) {
            int y = b % a;
            b = a;
            a = y;
        }
        return b;
    }

    public int getCircleGcd(Node head) {
        Node circle = getCircle(head);
        if (circle == null) {
            return -1;
        }
        return gcd(circle);
    }

    public static void main(String[] args) {
        int gcd = gcd(10, 5);
        System.out.println(gcd);
        Node head = insertList(new int[]{1, 2, 3, 4, 8, 12, 16});
        print(head);
        Node s1 = getExist(head, 16);
        Node s2 = getExist(head, 4);
        s1.next = s2;

        NK8 nk8 = new NK8();
        Node circle = nk8.getCircle(head);
        System.out.println(circle.value);
        int gcd1 = nk8.gcd(circle);
        System.out.println(gcd1);

    }
}
