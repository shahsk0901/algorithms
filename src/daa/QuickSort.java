package daa;

import java.util.*;

public class QuickSort {
	
	public static void main(String[] args) {
						
		Integer[] arr = {147,287,889,277, 873, 119, 815, 550, 424, 668, 137, 814, 933, 661, 557, 180, 168, 733, 89, 121, 250,12, 595, 916, 889, 139, 964, 635, 180, 75,954,26,93,888,1000,1,17,99,150,77,31,44,55,20};
		
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
		swap(arr,pivot,last);
		return last;
	}
	
	public static void swap(Integer[] arr,Integer first,Integer last) {
		Integer temp;
		temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}
}
