package Dijkstra;

public class PQArray {
    private Node[] queue;
    private int capacity;
    private int size;

    // Array implementation
    public PQArray(int capacity){
        queue = new Node[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public int insert(int id, int weight){
        int i;
        Node node = new Node(id, weight);

        if(capacity == size){
            return size;
        }

        if(size == 0){
            queue[0] = node;
            size++;
        }
        else{
            for(i=size - 1; (i >=0 && queue[i].getWeight() > weight); i--){
                queue[i+1] = queue[i];
            }
            queue[i+1] = node;
        }

        // for(i=0; i<capacity; i++){
        //     if(queue[i] == null){
        //         queue[i] = node;
        //         size++;
        //         break;
        //     }
        //     else if(weight <= queue[i].getWeight()){
        //         for(int j=size-1; j>=i; j--){
        //             queue[j+1] = queue[j]; 
        //         }
        //         queue[i] = node;
        //         size++;
        //         break;
        //     }
        // }
        return size;
    }

    public boolean remove(int id){
        boolean flag = false;

        for(int i=0; i<size; i++){
            if(queue[i].getID() == id){
                for(int j=i; j<size; j++){
                    queue[j] = queue[j+1];
                }
                flag = true;
                size--;
                break;
            }
        }
        return flag;
    }

    public void updateKey(int id, int newKey){
        if(remove(id) == true){
            insert(id, newKey);
        }
    }

    public Node checkFront(){
        return queue[0];
    }

    public Node getFront(){
        Node res = null;

        if(!isEmpty()){
            res = queue[0];
            for(int i=0; i<size-1; i++){
                queue[i] = queue[i+1];
            }
            size--;
        }

        return res;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        for(int i=0; i<size; i++){
            System.out.print(queue[i].getWeight() + " ");
        }
        System.out.println();
    }
}
