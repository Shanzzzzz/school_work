package Dijkstra;

public class DijkstraDriver {
    public static void main(String[] args) {
        Dijkstra D = new Dijkstra();

        int V = 10;
		// int E = V-1;
		Graph G = new Graph(V, "gnn");
	
		int res = D.dijkstra_a(G, 9, 4, V);
        System.out.println(G.adj_matrix[9][6]);
		System.out.println(res);
    }
}
