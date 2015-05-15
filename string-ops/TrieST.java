public class TrieST<Value> {
    
    private static final int R = 256;
    private Node root = new Node();
    
    
    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }
    
    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }
    //egs put(root, "sea", 1, 0)
    private Node put(Node x, String key, Value val, int d) {
        if (x == null) new Node();
        if (d == key.length()) { //if d is length of the key, then thats the last character, so we assign the value at that node and return that node
            x.value = val;
            return x;
        }
        char c = key.charAt(d); //get the charAt value
        x.next[c] = put(x.next[c], key, val, d+1); //
        return x;
    }
    
    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.value;    
    }
    
    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (key.length() == d) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }
    
    public boolean contains(String key) {
        return get(key) != null;
    }
}