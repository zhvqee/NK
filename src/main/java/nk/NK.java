package nk;

public class NK {
    public static Node insertList(int[] array) {
        Node node = new Node();
        for (int i = array.length - 1; i >= 0; i--) {
            Node cur = new Node(array[i]);
            cur.next = node.next;
            node.next = cur;
        }
        Node head = node.next;
        node.next = null;
        return head;
    }

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();

    }

    public static Node getExist(Node head, int value) {
        Node p = head;
        while (p.value != value) {
            p = p.next;
        }
        return p;
    }

    public static Node cpy(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node();
        newNode.value = node.value;
        Node cur = newNode;
        while (node.next != null) {
            node = node.next;
            cur.next = new Node(node.value);
            cur = cur.next;
        }
        return newNode;

    }
}
