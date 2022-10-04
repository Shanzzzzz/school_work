package Dijkstra;

import java.util.ArrayList;

public class Dijkstra {
	public int[] dijkstra_a(Graph G, int source, int V) {
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
				if(S[i]!=1 && G.adj_matrix[min.getID()][i] > 0 && (d[i] > d[min.getID()] + G.getWeight(min.getID(), i, 1))) {
					// delete(Q,i);
					d[i] = d[min.getID()] + G.getWeight(min.getID(), i, 1);
					pi[i] = min.getID();
                    Q.updateKey(i, d[i]);
					// insert(Q,i,d[i]);
				}
			}
		}
		
		return d;
	}

    public int[] dijkstra_b(Graph G, int source, int V){
		int i,neighbour_id;
		Node min,n;

		int d[] = new int[V];
		int pi[] = new int [V];
		int S[] = new int[V];
		
		for(i=0; i<V; i++) {
			d[i] = Integer.MAX_VALUE;
			pi[i] = -1;
			S[i] = 0;
		}
		
		d[source] = 0;
		
        PQHeap Q = new PQHeap(V);
		
		for(i=0; i<d.length; i++) {
			Q.insert(i, d[i]);
		}
		
		while(!Q.isEmpty()) {
            min = Q.getFront();
			S[min.getID()] = 1;

			ArrayList<Node> neighbours = G.adj_list.get(min.getID());
			
			for(i=0; i<neighbours.size(); i++){	// for every node adjacent to min node
				n = neighbours.get(i);
				neighbour_id = n.getID();
				if(S[neighbour_id]!=1 && d[neighbour_id] > d[min.getID()] + G.getWeight(min.getID(), neighbour_id, 0)) {
					d[neighbour_id] = d[min.getID()] + G.getWeight(min.getID(), neighbour_id, 0);
					pi[neighbour_id] = min.getID();
                    Q.updateWeight(neighbour_id, d[i]);
				}
			}
		}
		
		return d;
    }
}
