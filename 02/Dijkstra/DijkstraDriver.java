package Dijkstra;

public class DijkstraDriver {
    public static void main(String[] args) {
        long time = 0;
        Dijkstra D = new Dijkstra();

        int V = 1000;
        int E;
		// int E = V-1;
        int c = 0;
        // long start = System.nanoTime();
        for(int i=V; i<=V*(V-1); i+=5000){
            c++;
            // V = i;
            E = i ;
            Graph G = new Graph(V, E, 0);
            D = new Dijkstra();
            long start = System.nanoTime();
            // long start = System.currentTimeMillis();
            D.dijkstra_b(G, 0, V);
            long end = System.nanoTime();
            // long end = System.currentTimeMillis();
            System.out.print((end - start)+",");
            time += end - start;
        }
        // long end = System.nanoTime();

        System.out.println("Time taken: " + (time*1.0/c));
        // System.out.println("Time taken: " + (time/100)/1000000);
        // System.out.println(G.getWeight(9, 4, 0));
		// System.out.println(res);

        
    }
}
