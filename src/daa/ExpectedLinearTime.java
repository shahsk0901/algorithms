package daa;

import java.util.*;

public class ExpectedLinearTime {

    private static Integer pivot;

    public static void main(String[] args) {

        //Integer[] arr = {147,287,889,277, 873, 119, 815, 550, 424, 668, 137, 814, 933, 661, 557, 180, 168, 733, 89, 121, 250,12, 595, 916, 889, 139, 964, 635, 180, 75,954,26,93,888,1000,1,17,99,150,77,31,44,55,20,147};
        //Double[] arr = {10.0,9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0,1.0,0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,22.0};
        //Integer[] arr = {52,26,85,10,97,1};
        //Integer[] arr = {63, 98, 38,1,80,2};
        Integer[] arr = {3,1,4,2,5,7,9,80,12,0,15,27,59,11};
        /*Random selectK = new Random();
        Integer k = selectK.nextInt(arr.length);*/
        Integer k = arr.length;
        System.out.println("Initial Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }

        Integer kElement = quickSort(arr,0,arr.length-1,k-1);
        System.out.println("\n\n"+k+"-smallest: " + kElement);
    }

    public static Integer quickSort(Integer[] arr,Integer start, Integer end,Integer k) {
        if(start<=end) {
            pivot = splitArr(arr,start,end);
            if(k<pivot) {
                quickSort(arr,start,pivot-1,k);
            } else if(k>pivot) {
                quickSort(arr,pivot+1,end,k);
            }
        }
        return arr[pivot];
    }

    @SuppressWarnings("Duplicates")
    public static int splitArr(Integer[] arr,Integer start,Integer end) {
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

    public static void swap(Integer[] arr,Integer first,Integer last) {
        Integer temp;
        temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
