package daa;

import java.util.*;

public class QuickSort {
	
	private static Integer[] arr;
	public static void main(String[] args) {
		
		//Take the size of the array and k-th element from user
		Scanner scan = new Scanner(System.in);
		System.out.print("Give size of array: ");
		Integer n = scan.nextInt();
		/*System.out.print("Enter k: ");
		Integer k = scan.nextInt();
		System.out.println(k+" "+n);*/
		scan.close();
		
		generateArray(n);
		System.out.println("Array is as below:");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		
		quickSort(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void quickSort(Integer[] arr,Integer start, Integer end) {
		if(start<end) {
			Integer pivot = splitArr(arr,start,end);
			
			quickSort(arr,start,pivot-1);
			quickSort(arr,pivot+1,end);
		}
	}
	
	public static int splitArr(Integer[] arr,Integer start,Integer end) {
		Integer pivot = start;
		Integer first = pivot+1;
		Integer last = end;
		
		while(first<last) {
			while(arr[first]<arr[pivot]) {
				first++;
			}
			while(arr[last]>arr[pivot]) {
				last--;
			}
			if(first<last)
				swap(arr,first,last);
		}
		if(first>last)
		swap(arr,pivot,last);
		return last;
	}
	
	public static void swap(Integer[] arr,Integer first,Integer last) {
		Integer temp;
		temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}
	
	public static void generateArray(Integer n) {
		arr = new Integer[n];
		for(int i=0;i<n;i++) {
			Random rand = new Random();
			arr[i] = rand.nextInt(10000);
		}
	}
}
