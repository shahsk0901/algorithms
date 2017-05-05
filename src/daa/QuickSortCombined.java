package daa;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class QuickSortCombined {

    private static Integer selectedPivot;
    private static Double[] arr;
    private static Writer output;
    private static Integer depth = 0;

    public static void main(String[] args) {
    	
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Choose pivot option:\n1) First element as pivot\n2) Random element as pivot\n" +
                "3) Median of 3 random elements\n");
        System.out.print("Enter option: ");
        Integer option = scan1.nextInt();
        System.out.print("\nEnter k: ");
        Integer k = scan1.nextInt();
        scan1.close();
        
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
    	
        try {
        	output = new FileWriter("src/daa/output/QuickSortCombined.txt");
        	output.write("Quicksort using combined hueristics\n n = "+ arr.length + " k = "+k+"\n\nArray before Sorting:\n");
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
        quickSort(arr,0,arr.length-1,option);
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;
        
        try {
        	output = new FileWriter("src/daa/output/QuickSortCombined.txt",true);
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
        
        System.out.println("\nSorted Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.print("\nRunning Time: "+ runningTime + " ns");
        System.out.println("\nDepth: "+depth);
    }

    public static void quickSort(Double[] arr,Integer start, Integer end,Integer option) {
        if(start<end) {
            Integer pivot = getPivot(arr,start,end,option);
            Integer splitPoint = splitArr(arr,start,end,pivot);
            depth++;
            quickSort(arr,start,splitPoint-1,option);
            quickSort(arr,splitPoint+1,end,option);
        }
    }

    public static Integer getPivot(Double arr[],Integer start,Integer end,Integer option) {
        if(option == 1) {
            selectedPivot = start;
        } else if(option == 2) {
            Random selectPivot = new Random();
            selectedPivot = start + (selectPivot.nextInt(end-start+1));
        } else if(option ==3) {
            Integer medianOf3[] = new Integer[3];
            Random number = new Random();
            medianOf3[0] = start + (number.nextInt(end-start+1));
            medianOf3[1] = start + (number.nextInt(end-start+1));
            medianOf3[2] = start + (number.nextInt(end-start+1));

            selectedPivot = Math.max(Math.min(medianOf3[0],medianOf3[1]),Math.min(Math.max(medianOf3[0],medianOf3[1]),medianOf3[2]));
        }
        return selectedPivot;
    }

    public static int splitArr(Double[] arr,Integer start,Integer end,Integer pivot) {

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
