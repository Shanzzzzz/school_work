package Dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    
    int i, j, size, e=0;
    int maxWeight = 100;
    // private int type;
    // private int maxEdge;

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

    public void readFile(int[][] adj_matrix, int V){
        int E=20;
        int s,d,w;
        File file = new File("Dijkstra/test_cases/1.in");

        try{
            Scanner sc = new Scanner(file);
            // sc.useDelimiter(",");
            sc.nextInt();
            for(int i=0; i<E; i++){
                s = sc.nextInt();
                d = sc.nextInt();
                w = sc.nextInt();

                adj_matrix[s][d] = w; 
            }
            sc.close();
        }
        catch(FileNotFoundException ff){
            System.out.println("File Not Found");
        }
    }

    // public Graph(int V, String arg){
    //     size = V;
    //     adj_matrix = new int[V][V];
    //     readFile(adj_matrix, V);
    // }

    public Graph(int V, int E, int type){
        // adjacency list implementation
        size = V;
        if(type == 0){
            for (int i = 0; i < V; i++) {
                adj_list.add(new ArrayList<>());
            }

            //fixed number of edges
            // int E = V-1;
            
            //random number of edges
            // int E = (int)(Math.random()*maxEdge)+1;
    
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
            // int maxEdge = V*(V-1);
        
            adj_matrix = new int[V][V];

            //fixed number of edges
            //int E = V-1;
        
            //random number of edges
            // int E = (int)(Math.random()*maxEdge)+1;
            
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

    public int getWeight(int s, int e, int type){
        int w = Integer.MAX_VALUE;

        if(type == 0){
            for(Node n : adj_list.get(s)){
                if(n.getID() == e){
                    w = n.getWeight();
                }
            }
        }
        else if (type == 1){
            w = adj_matrix[s][e];
        }

        return w;
    }

    public void print(int type){
        ArrayList<Node> arr;
        if(type == 0){
            for(int i=0; i<adj_list.size(); i++){
                System.out.print(i + " : ");
                arr = adj_list.get(i);
                for(int j=0; j<arr.size(); j++){
                    System.out.print(arr.get(j).getID() + "(" + arr.get(j).getWeight() + ") ");
                }
                System.out.println();
            }
        }
    }
}
