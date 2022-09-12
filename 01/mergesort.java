package school_work;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System;
import java.util.Scanner;

public class mergesort{

    public static int count = 0;

    public static void msort(int n, int m, int[] slot)	{	
		
		int mid = (n+m)/2; 

        if(m - n <= 0){
            return;
        }
		
		msort(n,mid,slot);
		msort(mid+1,m,slot);
	
	    merge(n,m,slot);
	}

	public static void merge(int n, int m, int[] slot)	{
		int a = 0, b = 0, idx = n;		
		int mid = (n+m)/2;
	    int lsize = mid - n + 1;
		int rsize = m - mid;

		int left[] 	= new int[lsize];
		int right[] = new int[rsize];

		for(int i=0; i<lsize; i++){
			left[i] = slot[n + i];
		}
		for(int i=0; i<rsize; i++){
			right[i] = slot[mid + i + 1];
		}

		while(a < left.length && b < right.length){
			if(left[a] <= right[b]){
				slot[idx++] = left[a++];
			}
			else{
				slot[idx++] = right[b++];
			}
		}

		while(a < left.length){
			slot[idx++] = left[a++];
		}

		while(b < right.length){
			slot[idx++] = right[b++];
		}
		
	}

    public static void main(String[] args) {
        int N = 500000;

        		//Reading input file into an array
        
		int[] slot = new int[N];
		File file = new File("input/" + N + ".txt");
		try{
			Scanner sc = new Scanner(file);
			sc.useDelimiter(",");
			for(int k=0; k<N; k++){
				slot[k] = sc.nextInt(); 
			}
			sc.close();
		}
		catch(FileNotFoundException ff){
			System.out.println("File Not Found");
		}

        long start = System.currentTimeMillis();
		mergesort(0, slot.length-1, slot);
		long end = System.currentTimeMillis();

        System.out.println(" Time taken: " + (end - start) + " ms");

        

        // for(int i=0; i<1000; i++){
        //     System.out.print(slot[i] + ",");
        // }
    }
}
