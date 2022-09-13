package school_work;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.lang.System;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class mixsort {
	
	public static long count = 0;
	public static int S;
	public static int N;

	public static void main(String[] args) {
		boolean saveResults = true;

		int[] sizes		= {10000000}; //1000, 5000, 10000, 50000, 100000, 500000, 1000000, 5000000, 
		int[] threshold = {1,100,200,300,400,500,600,700,800,900,1000};


		// add header to result file
		try{
			String f = "01/output/results.txt";
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
			out.println("N,S,count,time taken(ms)");
			out.close();
		}
		catch(IOException err){
			System.out.println("File Not Found");
		}

		for(int n=0; n<sizes.length; n++){
			N = sizes[n];
			// for(int m=0; m<threshold.length; m++){
			for(int m=40; m<=60; m+=1){
				count = 0;
				// S = threshold[m];
				S = m;

				//Reading input file into an array
				int[] slot = new int[N];
				File file = new File("01/input/" + N + ".txt");
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

				//sort the array and record time
				long start = System.currentTimeMillis();
				mixsort(0,N-1,slot);
				long end = System.currentTimeMillis();

				// for(int q=0; q<N; q++){
				// 	System.out.print(slot[q] + " ");
				// }
				// System.out.println();

				for(int i=0; i<N-1; i++){
					if(slot[i] > slot[i+1]){
						System.out.println("ERRORRRRRRRRRRRRRRRRRRRR");
						break;
					}
				}

				//print results
				System.out.println("N = " + N + " S = " + S + " count = " + (count-1) + " Time taken: " + (end - start) + " ms");

				if(saveResults){
					try{
						String f = "01/output/sorted_" + "N" + N + "_S" + S + ".txt";
						PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
						for(int k=0; k<N; k++){
							out.write(slot[k]+",");
							
						}
						out.close();

						f = "01/output/results.txt";
						out = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
						out.println(N+","+S+","+count+","+(end - start));
						out.close();
					}
					catch(IOException err){
						System.out.println("File Not Found");
					}
				}
				//save sorted array into output file

			}
		}
	}
	
	public static void mixsort(int n, int m, int[] slot) {
		
		if( (m-n+1) <= S){
			insertionsort(n,m,slot);
			return;
		}
		
		int mid = (n+m)/2; 
			
		mixsort(n,mid,slot);
		mixsort(mid+1,m,slot);
		merge(n,m,slot);	
	}
	
	public static void insertionsort(int n, int m, int[] slot)	{
		if((m-n) <= 0){
			return;
		}


		for (int i=n+1; i < m+1; i++){ 	
			for (int j=i; j > n; j--) {
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
			count++;
		}

		while(a < left.length){
			slot[idx++] = left[a++];
		}

		while(b < right.length){
			slot[idx++] = right[b++];
		}
		
	}
	
	public static int[] generateArr(int N,int seed){
		int arr[] = new int[N];
		Random r = new Random(seed);

		for(int i=0; i<N; i++){
			arr[i] = 1 + r.nextInt(N);
		}

		return arr;
	}
}
		
		
	




