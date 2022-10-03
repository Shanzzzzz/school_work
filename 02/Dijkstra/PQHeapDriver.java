package Dijkstra;

public class PQHeapDriver {
    public static void main(String[] args) {
        PQHeap pq = new PQHeap(128);
        System.out.println(pq.insert(1, 10));
        pq.insert(2, 5);
        pq.insert(3, 1);
        pq.updateWeight(1, 0);
        pq.print();
    }
}
