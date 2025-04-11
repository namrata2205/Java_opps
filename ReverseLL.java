class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class ReverseLL {
    public static Node reverse(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        print(head);
        System.out.println();
        head = reverse(head);
        print(head);
    }
}
