package ll;
import ll.Node;
public class MyLinkedList {

    public Node head;
    int size;
    private boolean isEmpty;
    int headPos = 0;
    int tailPos = 0;

    MyLinkedList() {
       size = 0;
       isEmpty = true;
       head = null;
    }

    public Node insertNode(Node node) {
        Node currentNode;
        if (head == null) {
            head = node;
            size++;
            currentNode = head;
            headPos = 1;
            tailPos = 1;
            return;
        }

        if (currentNode.next == null) {
            currentNode.next = node;
            tailPos++;
            return;
        }

        currentNode = currentNode.next;
        return insertNode(node);

    }

    public Node deleteNode(Node node) {
        Node currentNode;
        if(head == node) {
            Node previousNode = head;
            head = head.next;
            previousNode == null;
            size--;
            currentNode = head;
            tailPos--;
            return;
        }


        if(currentNode.next == node) {
            currentNode.next == node.next;
            node == null
            size--;
            tailPos--;
            return;
        }

        currentNode = currentNode.next;
        return deleteNode(node);

    }

    public boolean isEmpty() {
        return size == 0;
    }
}