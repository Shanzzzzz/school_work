package school_work;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.System;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class mergesort{

	public static int S = 50;
	public static int N = 10000000;
    public static long count = 0;

	// Merge sort function
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
			count++;
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

	// Hybrid sort function of merge sort and insertion sort
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

	// Helper function to generate array based on seed
	public static int[] generateArr(int N,int seed){
		int arr[] = new int[N];
		Random r = new Random(seed);

		for(int i=0; i<N; i++){
			arr[i] = 1 + r.nextInt(N);
		}

		return arr;
	}

    public static void main(String[] args) {
		long start, end;
		double avg_hybrid=0,avg_merge=0;
		long count_merge=0,count_hybrid=0;

		double[] time_hybrid = new double[10];
		double[] time_merge = new double[10];

		for(int i=0; i<10; i++){
			int[] slot = generateArr(N, i);
			int[] slot_copy = Arrays.copyOf(slot, N);

			start = System.currentTimeMillis();
			msort(0, slot.length-1, slot);
			end = System.currentTimeMillis();
			avg_merge += (end-start);
			count_merge += count;

			count = 0;
	
			start = System.currentTimeMillis();
			mixsort(0, slot_copy.length-1, slot_copy);
			end = System.currentTimeMillis();
			avg_hybrid += (end-start);
			count_hybrid += count;
			
			count = 0;
		}
		
		avg_merge /= 10;
		avg_hybrid /= 10;
		count_merge /= 10;
		count_hybrid /= 10;

		System.out.println("Average time taken (merge sort) : " + avg_merge + " ms");
		System.out.println("Average comparisons (merge sort) : " + count_merge);
		System.out.println("Average time taken (hybrid sort) : " + avg_hybrid + " ms");
		System.out.println("Average comparisons (hybrid sort) : " + count_hybrid);
    }


}
