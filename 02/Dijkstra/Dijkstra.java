package Dijkstra;

public class Dijkstra {
	public void main(String[] args) {
		int V = 10;
		// int E = V-1;
		Graph G = new Graph(V, 1);
	
		dijkstra_a(G, 0, V);

	}


	void dijkstra_a(Graph G, int source, int V) {
		int i;
		
		int d[] = new int[V-1];
		int pi[] = new int [V-1];
		int S[] = new int[V-1];
		
		for(i=0; i<V; i++) {
			d[i] = Integer.MAX_VALUE;
			pi[i] = -1;
			S[i] = 0;
		}
		
		d[source] = 0;
		
        PQArray Q = new PQArray(V-1);
		
		for(i=0; i<d.length; i++) {
			Q.insert(i, d[i]);
		}
		
		while(!Q.isEmpty()) {
            int u = Q.getFront().getWeight();
			S[u] = 1;
			
			for(i=0; i<V; i++) {
				if(S[i]!=1 && (d[i] > d[u] + G.adj_matrix[u][i])) {
					// delete(Q,i);
					d[i] = d[u] + G.adj_matrix[u][i];
					pi[i] = u;
                    Q.updateKey(i, d[i]);
					// insert(Q,i,d[i]);
				}
			}
		}
		
	}

    public void dijkstra_a(Graph graph, Node source){
        
    }
}
