package nk;

import java.util.ArrayList;
import java.util.List;

import static nk.NK.insertList;
import static nk.NK.print;

public class NK3 {

    public Node mergeLists(List<Node> headList) {
        if (headList == null || headList.size() == 0) {
            return null;
        }
        if (headList.size() == 1) {
            return headList.get(0);
        }
        return mergeLists(headList, 0, headList.size() - 1);

    }

    private Node mergeLists(List<Node> headList, int l, int r) {
        if (l == r) {
            return headList.get(l);
        }
        if (l > r) {
            return null;
        }
        int mid = l + (r-l) / 2;
        return merge(mergeLists(headList, l, mid), mergeLists(headList, mid + 1, r));
    }

    private Node merge(Node node1, Node node2) {
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

    public static void main(String[] args) {
        NK3 nk3 = new NK3();
        Node head1 = insertList(new int[]{1, 2, 2, 3, 4, 4, 6, 7});
        Node head2 = insertList(new int[]{1, 4, 4, 5, 6, 7, 9, 10});
        Node head3 = insertList(new int[]{5, 6, 7});
        Node head4 = insertList(new int[]{8, 9, 11});
        Node head5 = insertList(new int[]{2, 3, 4, 4, 5, 6, 7});

        List<Node> ls = new ArrayList<>();
        ls.add(head1);
        ls.add(head2);
        ls.add(head3);
        ls.add(head4);
        ls.add(head5);
        Node node = nk3.mergeLists(ls);
        print(node);
    }
}
