package daa;

import java.io.File;
import java.util.*;

public class QuickSortAndInsertionSort {

    private static Integer l = 100;
    private static Double[] arr;

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
        sortArray(arr,0,arr.length-1);
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;
        
        System.out.println("\nSorted Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.print("\nRunning Time: "+ runningTime + "ns");
    }

    private static void sortArray(Double[] arr,Integer start,Integer end) {
        Integer arraySize = end+1;
        if(arraySize>l) {
            quickSort(arr,start,end);
        } else {
            insertionSort(arr);
        }
    }

    private static void insertionSort(Double[] arr) {
        Double temp;
    	for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(arr[j-1]>arr[j])
                {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void quickSort(Double[] arr,Integer start, Integer end) {
        if(start<end) {
            Integer pivot = splitArr(arr,start,end);

            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }

    public static int splitArr(Double[] arr,Integer start,Integer end) {
        Random selectPivot = new Random();
        Integer pivot = start + (selectPivot.nextInt(end-start+1));
        swap(arr,start,pivot);
        pivot = start;
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
