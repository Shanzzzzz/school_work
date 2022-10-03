package Dijkstra;

import java.util.ArrayList;

public class Graph {
    
    int i, j, size, e=0;
    int maxWeight = 20;
    // private int type;
    private int maxEdge;

    int[][] adj_matrix;
    ArrayList<ArrayList<Node>> adj_list = new ArrayList<>();
    
    public boolean hasNode(ArrayList<Node> arr, int id){
        boolean flag = false;
        for(int i=0; i<arr.size(); i++){
            Node n = arr.get(i);
            if(n.getID() == id){
                flag = true;
                break;
            }
        }

        return flag;
    }

    public Graph(int V, int type){
        // adjacency list implementation
        size = V;
        maxEdge = V*(V-1);
        if(type == 0){
            for (int i = 0; i < V; i++) {
                adj_list.add(new ArrayList<>());
            }

            //fixed number of edges
            //int E = V-1;
            
            //random number of edges
            int E = (int)(Math.random()*maxEdge)+1;
    
            //generate E random edges
            while(e<E){
                i = (int)(Math.random()*V);
                j = (int)(Math.random()*V);
                if(i!=j && !hasNode(adj_list.get(i), j)){
                    int w = (int)(Math.random()*maxWeight)+1;
                    adj_list.get(i).add(new Node(j, w));
                    e++;
                }
            }
        }


        // adjacency matrix implementation
        else if(type == 1){
            int i, j, e=0;
            int maxWeight = 20;
            int maxEdge = V*(V-1);
        
            adj_matrix = new int[V][V];

            //fixed number of edges
            //int E = V-1;
        
            //random number of edges
            int E = (int)(Math.random()*maxEdge)+1;
            
            //initialize the matrix
            for(i=0; i<V; i++) {
                for(j=0; j<V; j++){
                    adj_matrix[i][j]=0;
                }
            }
        
            //generate E random edges
            while(e<E){
                i = (int)(Math.random()*V);
                j = (int)(Math.random()*V);
                if(i!=j && adj_matrix[i][j]==0){
                    adj_matrix[i][j]=(int)(Math.random()*maxWeight)+1;
                    e++;
                }
            }
        
        }
    }

    public void print(){

    }
}
