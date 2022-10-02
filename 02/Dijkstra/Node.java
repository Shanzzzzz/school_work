package Dijkstra;

public class Node {
    private int id;
    private int weight;

    public Node(int id){
        this.id = id;
        this.weight = Integer.MAX_VALUE;
    }

    public Node(int id, int weight){
        this.id = id;
        this.weight = weight;
    }

    public int getID(){
        return id;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
}
