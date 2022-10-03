package Dijkstra;

public class DijkstraDriver {
    public static void main(String[] args) {
        Dijkstra D = new Dijkstra();

        int V = 100;
		// int E = V-1;
		Graph G = new Graph(V, 1);
	
		int res = D.dijkstra_a(G, 0, 2, V);
		System.out.println(res);
    }
}
