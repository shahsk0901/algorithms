package daa;

import java.io.File;
import java.util.*;

public class QuickSort3Hueristic {


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

        quickSort(arr,0,arr.length-1);
        System.out.println("\nSorted Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(Double[] arr,Integer start, Integer end) {
        if(start<end) {
            Integer pivot = splitArr(arr,start,end);

            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }

    @SuppressWarnings("Duplicates")
    public static int splitArr(Integer[] arr,Integer start,Integer end) {
        Integer medianOf3[] = new Integer[3];
        Random number = new Random();
        medianOf3[0] = start + (number.nextInt(end-start+1));
        medianOf3[1] = start + (number.nextInt(end-start+1));
        medianOf3[2] = start + (number.nextInt(end-start+1));

        Integer pivot = Math.max(Math.min(medianOf3[0],medianOf3[1]),Math.min(Math.max(medianOf3[0],medianOf3[1]),medianOf3[2]));
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

    public static void swap(Integer[] arr,Integer first,Integer last) {
        Integer temp;
        temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
