/*
 * This class represents a Maximum priority queue
 */
public class MaxPQ<Key extends Comparable<Key>> {
    
    public Key[] pq;
    private int N = 0;
    
    public MaxPQ(int N) {
        pq = (Key[]) new Comparable[N + 1];  
    }
    
    public boolean isEmpty() {
        return N == 0;
    }
    
    public int size() {
        return N;
    }
    
    public void insert(Key key) {
        pq[++N] = key;
        swim(key)
    }
    
    public Key delMax() {
        Key max = pq[1]; //Return the first element since it would be the maximum key
        exchange(1, N+1); //Move the first element to the last leaf ahe firstnd the last one to t
        p[N+1] = null; //Delete the max element that was just moved
        sink(1) //Now re-heapify
    }
    
    /*
     * This s to reheapify when the heap is violated
     * Suppose a key is inerted at a certain position
     * we check for heap violation and if theres violation we 
     * exchange the parent key's position with the key that violates
     */
    public void swim(int k) {
        while(less(k/2, k) && k > 1 ) {
            exchange(k, int(k/2));
            k = k/2;
        }
    }
    
    public void less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    
    public void exchange(int i, int j) {
        Key t = pq[j];
        pq[j] = pq[i];
        pq[j] = t;
    }
    
    public Key getMax() {
        return pq[1];
    }
    
    public void sink(int k) {
        while(2*k <= N) {
            int j = 2 * k;
            if(less(j, j+1) && j < N) j++;
            if(!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }
        
    
}