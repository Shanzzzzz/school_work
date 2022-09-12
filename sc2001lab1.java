package school_work;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.lang.System;

public class sc2001lab1 {
	
	public static long count = 0;
	public static int S;
	public static int N;

	public static void main(String[] args) {
				
        // int range = max - min + 1;
        // int length = (int) (Math.random() * range) + min;


		// int[] sizes		= {5000};
		// int[] threshold = {100};

		int[] sizes		= {1000, 5000, 10000, 50000, 100000}; //, 500000, 1000000, 5000000, 10000000
		int[] threshold = {5,10,50,100,500};
        
        // System.out.print("Please enter the range of integers in dataset:");
		// Scanner sc = new Scanner(System.in);
		// int x =  sc.nextInt();
 
        // generate random numbers within 1 to length
        // for (int i = 0; i < length; i++) {
        //     int rand = (int)(Math.random() * x);
        //     slot[i] = rand;
        //     System.out.print(slot[i] + " ");
        // }
        
        // System.out.println("");
        
        // int n = 0;
        // int m = length-1;
        // mixsort(n,m,slot);
        // System.out.println("Sorted");
        // for (int i = 0; i < length; i++) {
        //     System.out.print(slot[i] + " ");
        // }


		for(int i=0; i<sizes.length; i++){
			
			N = sizes[i];
			
			
			for(int j=0; j<threshold.length; j++){
				count = 0;
				S = threshold[j];
				int[] slot = new int[N];

				File file = new File("school_work/input/" + N + ".txt");

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

				// for(int i = 0;i<1000;i++){
				// 	System.out.println(slot[i] + " ");
				// }

				long start = System.currentTimeMillis();
				mixsort(0,N-1,slot);
				long end = System.currentTimeMillis();

				// for(int q=0; q<N; q++){
				// 	System.out.print(slot[q] + " ");
				// }
				// System.out.println();

				System.out.println("N = " + N + " S = " + S + " count = " + (count-1) + " Time taken: " + (end - start) + " ms");

				try{
					String f = "school_work/output/sorted_" + "N" + N + "_S" + S + ".txt";

					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));

					for(int k=0; k<N; k++){
						out.write(slot[k]+",");
						
					}

					out.close();
				}
				catch(IOException err){
					System.out.println("File Not Found");
				}
			}

		}
			

		
	}
	
	public static void mixsort(int n, int m, int[] slot) {
		
		if( (m-n+1) <= S)
			insertionsort(n,m,slot);
		
		else {
			int mid = (n+m)/2; 
			
			mixsort(n,mid,slot);
			mixsort(mid+1,m,slot);
			slot = merge(n,m,slot);	
	    } 
				
	}
	
	/*public static void mergesort(int n, int m, int[] slot)	{	
		
		int mid = (n+m)/2; 
		
	    if (m-n <= S) 
	    	return;
	    
	    else if (m-n > S) {
			mergesort(n,mid,slot);
			mergesort(mid+1,m,slot);
	    } 
	    
	    merge(n,m,slot);
	}*/
	
	public static void insertionsort(int n, int m, int[] slot)	{
		
		for (int i=1; i < m+1; i++) 	
			for (int j=i; j > 0; j--) {
				if (slot[j] < slot[j-1]) {
					int tmp = slot[j];
					slot[j] = slot[j-1];
					slot[j-1] = tmp;
					count++;
				}
				else {
					count++;
					break;
				}
					
			}
	}

	// non in-place sorting

	public static int[] merge(int n, int m, int[] slot){
		int[] arr = new int[m-n+1];
		int idx = 0;
		int mid = (m+n)/2;
		int a = n, b = mid + 1;

		if(m - n <= 0){
			return null;
		}

		while(a <= mid && b <= m){
			if(slot[a] <= slot[b]){
				arr[idx++] = slot[a++];
				count++;
			}
			else{
				arr[idx++] = slot[b++];
				count++;
			}
		}

		while(a <= mid){
			arr[idx++] = slot[a++];
		}
		
		while(b <= mid){
			arr[idx++] = slot[b++];
		}

		return arr;
	}

	
	// in-place sorting

	/*
	public static void merge(int n, int m, int[] slot)	{		
		int mid = (n+m)/2;
	    int a = n, b = mid+1, i, tmp;
	    
	    if (m-n <= 0)
	    	return;
	    
	    while (a <= mid && b <= m) {  
	    	
			if (slot[a] > slot[b]) {
				tmp = slot[b++];
				
				for (i = ++mid; i > a; i--)
					slot[i] = slot[i-1];
				
				slot[a++] = tmp;
				count++;
				
			}
				
			else if (slot[a] < slot[b]) {
				a++; 
				count++;
			}
			
	   		else {
	   			
	   			if (a == mid && b == m) 
	   				break;
	   			
	   			tmp = slot[b++];
	            a++;
	            
	            for (i = ++mid; i > a; i--)
	            	slot[i] = slot[i-1];
	            
	            slot[a++] = tmp;
	            count++;
	            
	         }
			
			
	        
		}
	}
	*/
}
		
		
	




