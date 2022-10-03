package Dijkstra;

public class Dijkstra {
	public int dijkstra_a(Graph G, int source, int destination, int V) {
		int i;
		Node min;

		int d[] = new int[V];
		int pi[] = new int [V];
		int S[] = new int[V];
		
		for(i=0; i<V; i++) {
			d[i] = Integer.MAX_VALUE;
			pi[i] = -1;
			S[i] = 0;
		}
		
		d[source] = 0;
		
        PQArray Q = new PQArray(V);
		
		for(i=0; i<d.length; i++) {
			Q.insert(i, d[i]);
		}
		
		while(!Q.isEmpty()) {
            min = Q.getFront();
			S[min.getID()] = 1;
			
			for(i=0; i<V; i++) {
				if(S[i]!=1 && G.adj_matrix[min.getID()][i] > 0 && (d[i] > d[min.getID()] + G.adj_matrix[min.getID()][i])) {
					// delete(Q,i);
					d[i] = d[min.getID()] + G.adj_matrix[min.getID()][i];
					pi[i] = min.getID();
                    Q.updateKey(i, d[i]);
					// insert(Q,i,d[i]);
				}
			}
		}
		
		return d[destination];
	}

    // public void dijkstra_a(Graph graph, Node source){
        
    // }
}
