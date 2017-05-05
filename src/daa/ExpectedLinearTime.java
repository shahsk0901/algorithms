package daa;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class ExpectedLinearTime {

    private static Integer pivot;
    private static Double[] arr;
    private static Integer k;

    public static void main(String[] args) {

    	File file = new File("src/daa/orderStatisticsInput.txt");
    	try {
    		Scanner scanFile = new Scanner(file);
    		k = scanFile.nextInt();
    		Integer inputSize = scanFile.nextInt();
    		arr = new Double[inputSize]; 
    		for(int i=0;i<inputSize;i++) {
    			arr[i] = scanFile.nextDouble();
    		}
    		scanFile.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}

        /*System.out.println("Initial Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }*/

        long startTime = System.nanoTime();
        Double kElement = quickSort(arr,0,arr.length-1,k);
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;
        try {
            Writer File = new FileWriter("src/daa/output/ExpectedLinearTimeOutput.txt");
            File.write(k+"-smallest: " + kElement + "\n\nRunning Time: "+ runningTime + " ns");
            File.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\n"+k+"-smallest: " + kElement);
        
        System.out.print("\nRunning Time: "+ runningTime + " ms");
    }

    public static Double quickSort(Double[] arr,Integer start, Integer end,Integer k) {
        if(start<=end) {
            pivot = splitArr(arr,start,end);
            Integer kth = pivot - start + 1;
            if(k<kth) {
                quickSort(arr,start,pivot-1,k);
            } else if(k>kth) {
                quickSort(arr,pivot+1,end,k-kth);
            }
        }
        return arr[pivot];
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
