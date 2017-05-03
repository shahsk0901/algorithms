package daa;

import java.util.*;

public class QuickSortRandom {


    public static void main(String[] args) {

        //Integer[] arr = {147,287,889,277, 873, 119, 815, 550, 424, 668, 137, 814, 933, 661, 557, 180, 168, 733, 89, 121, 250,12, 595, 916, 889, 139, 964, 635, 180, 75,954,26,93,888,1000,1,17,99,150,77,31,44,55,20};
        //Double[] arr = {10.0,9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0,1.0,0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,22.0};
        Integer[] arr = {52,26,85,10,97,1};
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

    public static void quickSort(Integer[] arr,Integer start, Integer end) {
        if(start<end) {
            Integer pivot = splitArr(arr,start,end);

            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }

    public static int splitArr(Integer[] arr,Integer start,Integer end) {
        Random selectPivot = new Random();
        Integer pivot = selectPivot.nextInt(arr.length);
        Integer first = start;
        Integer last = end;

        while(first<pivot && last>pivot) {
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
