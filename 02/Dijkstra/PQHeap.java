package Dijkstra;

public class PQHeap {
    private Node[] queue;
    private int capacity;
    private int size;

    // Initialize the instance variables
    public PQHeap(int capacity){
        queue = new Node[capacity+1];
        this.capacity = capacity;
        size = 0;
    }

    // Swap the two Node at position first and second
    public void swap(int first, int second){
        Node temp = queue[first];
        queue[first] = queue[second];
        queue[second] = temp;
    }

    // Finds the index of the smaller child of the Node at N [Return -1 if the Node is a leaf]
    public int smallerChildIndex(int N){
        int res;
        if(queue[N*2] == null){
            res = -1;
        }
        else if(queue[N*2].getWeight() > queue[N*2 + 1].getWeight()){
            res = N*2 + 1;
        }
        else{
            res = N*2;
        }

        return res;
    }

    // Move the Node at N upwards as long as it is smaller than the parent
    public void siftUp(int N){
        Node node = queue[N];
        while(N > 1 && queue[N/2].getWeight() > node.getWeight()){
            swap(N/2, N);
            N = N/2;
            node = queue[N];
        }
    }

    // Move the Node at N downwards as long as it is larger then the smaller child
    public void siftDown(int N){
        Node node = queue[N];
        int idx = smallerChildIndex(N);
        // Node at N is a leaf
        if(idx == -1){ 
            return;
        }
        // Swap Node at N with the smallest child until it is smaller then both child
        while(idx != -1 && N < size && node.getWeight() > queue[idx].getWeight()){
            swap(N, idx);
            N = idx;
            idx = smallerChildIndex(N);
        }
    }

    // Insert a new Node into the queue
    public int insert(int id, int key){
        Node node = new Node(id, key);

        if(size == capacity){
            return size;
        }

        queue[++size] = node;
        siftUp(size);
        return size;
    }

    // public void remove(){

    // }

    // Updates the weight of the Node based on id and fix the heap
    public void updateWeight(int id, int newWeight){
        for(int i=1; i<=size; i++){
            if(queue[i].getID() == id){
                queue[i].setWeight(newWeight);
                siftUp(i);
                siftDown(i);
                break;
            }
        }
    }

    // Return the root node in the heap
    public Node checkFront(){
        return queue[1];
    }

    // Remove and return the root node in the heap
    public Node getFront(){
        Node node = queue[1];
        swap(1, size);
        size--;
        siftDown(1);
        return node;
    }
    
    // Check is the heap is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // Print the queue
    public void print(){
        for(int i=1; i<=size; i++){
            System.out.print(queue[i].getWeight() + " ");
        }
        System.out.println();
    }
}
