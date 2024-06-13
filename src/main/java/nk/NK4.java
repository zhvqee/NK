package nk;

import java.util.ArrayList;
import java.util.List;

import static nk.NK.insertList;
import static nk.NK.print;

public class NK4 {


    public Node merge(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node hair = new Node();
        Node p = hair;
        while (node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        if (node1 != null) {
            p.next = node1;
        }
        if (node2 != null) {
            p.next = node2;
        }
        Node head = hair.next;
        hair.next = null;
        return head;
    }

}
