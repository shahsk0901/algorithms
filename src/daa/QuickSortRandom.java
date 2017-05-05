package daa;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class QuickSortRandom {

	private static Double[] arr;
	private static Writer output;
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
    	
    	Scanner scan = new Scanner(System.in);
        System.out.print("Enter k: ");
        Integer k = scan.nextInt();
        scan.close();
    	
        try {
        	output = new FileWriter("src/daa/output/QuickSortRandom.txt");
        	output.write("Quicksort using insertion sort\n n = "+ arr.length + " k = "+k+"\n\nArray before Sorting:\n");
        	for(int i=0;i<arr.length;i++) {
                output.write(arr[i] + "\n");
            }
        	output.close();
        	
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
        
        try {
        	output = new FileWriter("src/daa/output/QuickSortRandom.txt",true);
        	output.write("\nAfter sorting:\n");
        	for(int i=0;i<arr.length;i++) {
                output.write(arr[i] + "\n");
            }
        	output.write("\n\n"+k+"-smallest: " + arr[k-1]);
        	output.write("\n\nTop "+k+" elements are:\n");
            for(int i=arr.length-1;i>arr.length-k-1;i--) {
                output.write(arr[i]+"\n");
            }
            output.close();
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        System.out.print("\nRunning Time: "+ runningTime + "ns");
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
