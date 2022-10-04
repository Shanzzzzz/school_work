package Dijkstra;

public class DijkstraDriver {
    public static void main(String[] args) {
        long time = 0;
        Dijkstra D = new Dijkstra();

        int V = 1000;
        int E = (V-1)*V;
		// int E = V-1;
        
        // for(int i=0; i<10; i++){
            Graph G = new Graph(V, E, 0);
            D = new Dijkstra();
            // G.print(0);
            long start = System.nanoTime();
            // long start = System.currentTimeMillis();
            D.dijkstra_b(G, 0, V);
            long end = System.nanoTime();
            // long end = System.currentTimeMillis();
            // System.out.println((end - start)/1000000.0);
            // time += end - start;
        // }

        System.out.println("Time taken: " + (end - start)/1000000.0);
        // System.out.println("Time taken: " + (time/100)/1000000);
        // System.out.println(G.getWeight(9, 4, 0));
		// System.out.println(res);

        
    }
}
