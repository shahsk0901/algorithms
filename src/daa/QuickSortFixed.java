package daa;

public class QuickSortFixed {
	public static void main(String[] args) {
	
		int arr[] = {10,6,20,1,50,7,9,25,4,18,76};
		//int arr[] = {6,7,9,1,4};
		splitPivot(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void splitPivot(int[] sortArray, int first, int last) {
		int pivot,i,j,temp;
		pivot = sortArray[first];
		i = last+1;
		j = last;
		
		while(j >= 0) {
			if(sortArray[j]>=pivot) {
				i--;
				temp = sortArray[j];
				sortArray[j] = sortArray[i];
				sortArray[i] = temp;
			}
			j--;
		}
		pivot = i;
		//splitPivot(sortArray,0,pivot-1);
	}
}
