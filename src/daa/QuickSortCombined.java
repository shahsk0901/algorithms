package daa;

import java.util.*;

public class QuickSortCombined {

    private static Integer selectedPivot;

    public static void main(String[] args) {

        Integer[] arr = {147,287,889,277, 873, 119, 815, 550, 424, 668, 137, 814, 933, 661, 557, 180, 168, 733, 89, 121, 250,12, 595, 916, 889, 139, 964, 635, 180, 75,954,26,93,888,1000,1,17,99,150,77,31,44,55,20,147};
        //Double[] arr = {10.0,9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0,1.0,0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,22.0};
        //Integer[] arr = {52,26,85,10,97,1};
        //Integer[] arr = {63, 98, 38,1,80,2};
        //Integer[] arr = {1,10,1,1,1,1,1,2,3};

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose pivot option:\n1) First element as pivot\n2) Random element as pivot\n" +
                "3) Median of 3 random elements\n");
        System.out.print("Enter option: ");
        Integer option = scan.nextInt();
        scan.close();

        System.out.println("Initial Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }

        quickSort(arr,0,arr.length-1,option);
        System.out.println("\nSorted Array:");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(Integer[] arr,Integer start, Integer end,Integer option) {
        if(start<end) {
            Integer pivot = getPivot(arr,start,end,option);
            Integer splitPoint = splitArr(arr,start,end,pivot);

            quickSort(arr,start,splitPoint-1,option);
            quickSort(arr,splitPoint+1,end,option);
        }
    }

    public static Integer getPivot(Integer arr[],Integer start,Integer end,Integer option) {
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

    @SuppressWarnings("Duplicates")
    public static int splitArr(Integer[] arr,Integer start,Integer end,Integer pivot) {

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
