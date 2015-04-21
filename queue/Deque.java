import java.lang.NullPointerException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int N;
    private Node first, last;


    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        N = 0;
    }

    private class Node {
        private Item item;
        private Node next;
        private Node previous;

        Node(Item item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    // is the deque empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // insert the item at the front
    public void addFirst(Item item) throws NullPointerException {

        if (item == null) throw new NullPointerException("Item cannot be null");

        if (isEmpty()) {
            first = new Node(item, null, null);
            last = first;
            N++;
        } else {
            Node oldFirst = first;
            first = new Node(item, oldFirst, null);
            oldFirst.previous = first;
            N++;
        }
    }

    // insert the item at the end
    public void addLast(Item item) throws NullPointerException {
        if (item == null) throw new NullPointerException("Item cannot be null");

        if (isEmpty()) {
            last = new Node(item, null, null);
            first = last;
            N++;
        } else {
            Node oldLast = last;
            last = new Node(item, null, oldLast);
            oldLast.next = last;
            N++;
        }

    }

    // delete and return the item at the front
    public Item removeFirst() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item;
        if (N == 1) {
            item = first.item;
            first = null;
            last = null;
            N--;
        } else {
            item = first.item;
            Node oldFirst = first;
            first = first.next;
            first.previous = null;
            oldFirst = null;
            N--;
        }
        return item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item;
        if (N == 1) {
            item = last.item;
            first = null;
            last = null;
            N--;
        } else {
            item = last.item;
            Node oldLast = last;
            last = oldLast.previous;
            last.next = null;
            oldLast = null;
            N--;
        }
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("Deque is empty");
            Item item = current.item;
            current = current.next;
            return item;
        }

    }


    // unit testing
    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(10);

    }
}