import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] a;
    private int N;
    private int start, end;
    private boolean full;
   
    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        start = end = 0;
        full = false;
        N = 0;
    }   
    
    // is the queue empty?
    public boolean isEmpty() {
        return (start == end) && !full;
    }
    
    // return the number of items on the queue
    public int size() {
        return N;
    } 
    
     // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
        start = N-1;
        end = 0;        
    }
    
    // add the item
    public void enqueue(Item item) throws NullPointerException {
        if (item == null) throw new NullPointerException("Item cannot be null");
        if (N == a.length) resize(2*a.length); 
        a[start = ++start % a.length] = item;
        N++;
        if (start == end) {
            full = true; 
        }
    }
    
    // delete and return a random item
    public Item dequeue() throws java.util.NoSuchElementException {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        if (full) full = false;
        if (N>0 && N == a.length/4) resize(a.length/2); 
        int toDequeue = StdRandom.uniform(0, N - 1);
        Item item = a[toDequeue];
        a[toDequeue] = a[--N];
        a[N] = null;
        return item;
        //Item item = a[end = ++end % a.length];
        //a[end] = null;
        //N--;
            
    }   
    
    // return (but do not delete) a random item
    public Item sample() throws java.util.NoSuchElementException {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        return a[StdRandom.uniform(0, N - 1)];
    }
    
    // return an independent iterator over items in random order
    public Iterator<Item> iterator()  {
        return new RandomizedQueueIterator();
    }
    
    private class RandomizedQueueIterator implements Iterator<Item> {
        
        private Item[] qCopy;
        private int iteratorIndex = 0;
        
        public RandomizedQueueIterator() {
            qCopy = (Item[]) new Object[N];
            
            for (int i = 0; i < N; i++) {
                qCopy[i] = a[i];
            }
            
            for (int j = 0; j < N; j++) {
                int randomIndex = StdRandom.uniform(0, N - 1);
                Item randomItem = qCopy[randomIndex];
                qCopy[randomIndex] = qCopy[j];
                qCopy[j] = randomItem;
            }
        }
        
        public boolean hasNext() {
            return iteratorIndex < N;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public Item next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = a[iteratorIndex];
            iteratorIndex++;
            return item;
        }
    }  
    
     // unit testing
    public static void main(String[] args)  {
     RandomizedQueue<Integer> randomQueue = new RandomizedQueue<Integer>();
                
                randomQueue.enqueue(Integer.valueOf(1));
                randomQueue.enqueue(Integer.valueOf(2));
                randomQueue.enqueue(Integer.valueOf(3));
                randomQueue.enqueue(Integer.valueOf(4));
                randomQueue.enqueue(Integer.valueOf(5));
                randomQueue.enqueue(Integer.valueOf(6));
                randomQueue.enqueue(Integer.valueOf(7));
                randomQueue.enqueue(Integer.valueOf(8));
                randomQueue.enqueue(Integer.valueOf(9));
                randomQueue.enqueue(Integer.valueOf(10));
                randomQueue.enqueue(Integer.valueOf(11));

                
                for (Integer x: randomQueue) {
                        StdOut.println(x);
                }
      }
}
