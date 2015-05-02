package ff;

public class FordFulkerson {
    
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;
    
    public FordFulkerson(FlowNetwork G, int s, int t) {
        value = 0.0;
       
        while (hasAugmentingPath(G, s, t) {
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }
            
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle));
            }

            value += bottle;
        }
      }
         
   public double value() {
       return value;
   }
   
   public boolean inCut(int v) {
       return marked[v];
   }
   
   public hasAugmentingPaths(G, s, t) {
       edgeTo = new FlowEdge[G.V()];
       marked = new boolean[G.V()];
       
       Queue<Integer> queue = new Queue();
       
       queue.enqueue(s);
       
       while (!queue.isEmpty()) {
           int v = queue.dequeue();
           
           for (FlowEdge e: G.adj(v)) {
               int w = e.other(v);
               if (e.residualCapacityTo(W) > 0 && !marked[w]) {
                   marked[w] = true;
                   edgeTo[w] = e;
                   q.enqueue[w];
               }
           }
       }
       
       return marked[t];
   }
               
           
       