package daa;

import java.util.*;
import java.io.*;

public class QuickSortFixed {
	
	private static Double[] arr;
	private static Integer depth = 0;

    public static void main(String[] args) { 	
    	
    	File file = new File("src/daa/sortingAlgorithmInput.txt");
    	try {
    		Scanner scanFile = new Scanner(file);
    		Integer inputSize = scanFile.nextInt();
    		arr = new Double[inputSize]; 
    		for(int i=0;i<inputSize;i++) {
    			arr[i] = scanFile.nextDouble();
    		}
    		scanFile.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	System.out.println("Initial Array:");
    	for(int i=0;i<arr.length;i++) {
    	    System.out.print(arr[i] + " ");
    	}
    	
    	long startTime = System.nanoTime();
        quickSort(arr,0,arr.length-1);
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;
        
        System.out.println("\nSorted Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.print("\nRunning Time: "+ runningTime + " ms");
        System.out.println("\nDepth: "+depth);
    }

    public static void quickSort(Double[] arr,Integer start, Integer end) {
    	if(start<end) {
            Integer pivot = splitArr(arr,start,end);
            depth++;
            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }

    public static int splitArr(Double[] arr,Integer start,Integer end) {
        Integer pivot = start;
        Integer first = pivot+1;
        Integer last = end;

        while(first<last) {
            while(arr[first]<=arr[pivot] && first < last) {
                first++;
            }
            while(arr[last]>arr[pivot]) {
                last--;
            }
            if(first<last)
                swap(arr,first,last);
        }
        if(arr[pivot]<arr[last]) {
            return pivot;
        } else {
            swap(arr,pivot,last);
            return last;
        }
    }

    public static void swap(Double[] arr,Integer first,Integer last) {
        Double temp;
        temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
