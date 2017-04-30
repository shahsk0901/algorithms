package daa;

public class QuickSort {
	public static void main(String[] args) {
		Integer[] arr = {54,26,93,17,77,31,44,55,20};
		
		quickSort(arr,0,arr.length-1);
		
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
		Integer pivot = start;
		Integer first = pivot+1;
		Integer last = end;
		
		while(first<last) {
			while(arr[first]<arr[pivot]) {
				first++;
			}
			while(arr[last]>arr[pivot]) {
				last--;
			}
			if(first<last)
				swap(arr,first,last);
		}
		if(first>last)
		swap(arr,pivot,last);
		return last;
	}
	
	public static void swap(Integer[] arr,Integer first,Integer last) {
		Integer temp;
		temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}
}
