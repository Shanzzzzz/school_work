package Dijkstra;

public class PQArrayDriver {
    public static void main(String[] args) {
        PQArray pq = new PQArray(100);
        //pq.insert(1,10);
        System.out.println(pq.insert(2,5));
        System.out.println(pq.insert(3,15));
        pq.insert(4,0);
        pq.updateKey(4, 10);
        pq.print();
    }
}
