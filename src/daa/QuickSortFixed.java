package daa;

import java.io.FileReader;
import java.util.*;
import java.io.*;

public class QuickSortFixed {

    static Double[] arr;
    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Give array size: ");
    	Integer inputSize = scan.nextInt();
        System.out.print("Give k: ");
        Integer k = scan.nextInt();
    	scan.close();
    	System.out.print("\n");
    	
    	arr = new Double[inputSize];

        try {
        	File file = new File("src/daa/input.txt");
        	Scanner fileScan = new Scanner(new FileReader(file));
        	for(int i=0;i<inputSize;i++) {
        		arr[i] = fileScan.nextDouble();
        	}
        } catch(Exception e) {
        	e.printStackTrace();
        }

    	//generateArray(inputSize);

    	//Integer[] arr = {147,287,889,277, 873, 119, 815, 550, 424, 668, 137, 814, 933, 661, 557, 180, 168, 733, 89, 121, 250,12, 595, 916, 889, 139, 964, 635, 180, 75,954,26,93,888,1000,1,17,99,150,77,31,44,55,20};
        //Double[] arr = {10.0,9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0,1.0,0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,22.0};
        //Integer[] arr = {52,26,85,10,97,1};
        //Integer[] arr = {63, 98, 38,1,80,2};
        //Double[] arr = {1.0,10.0,1.0,1.0,1.0,1.0,1.0,2.0};
    	
    	System.out.println("Initial Array:");
    	for(int i=0;i<arr.length;i++) {
    	    System.out.print(arr[i] + " ");
    	}

        quickSort(arr,0,arr.length-1);
        System.out.println("\nSorted Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*public static void generateArray(Integer inputSize) {
        Random rnd = new Random();
        Double rndMax = 10000.00;
        Double rndMin = 0.00;
    	arr = new Double[inputSize];
    	for(int i=0;i<inputSize;i++) {
    		arr[i] =  rndMin + (rnd.nextDouble() * (rndMax-rndMin));
    	}
    }*/

    public static void quickSort(Double[] arr,Integer start, Integer end) {
        if(start<end) {
            Integer pivot = splitArr(arr,start,end);

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
