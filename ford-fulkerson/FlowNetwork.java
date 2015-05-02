package ff;

public class FlowNetwork {
    
    private final int V;
    private Bag<FlowEdge>[] adj;
    
    public FlowNetwork(int V) {
        adj = (Bag<FlowEdge>[]) new Bag[V];
        
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<FlowEdge>();
        }
    }
    
    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }
    
    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }
}