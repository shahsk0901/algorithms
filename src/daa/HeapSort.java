package daa;
import java.io.*;
import java.util.*;


public class HeapSort {
    private static int N;
    private static double array[];
    
    public static void sorting(double array[])
    {
      heapify(array);
      for(int i=N; i>0; i--)
          {
            swap(array,0,i);
            N = N-1;
            maxheap(array,0);
          
          }
    }
    
   
    public static void heapify(double array[])
    {
        N = array.length-1;
        for(int i=N/2;i>=0;i--)
            maxheap(array,i);
    }
    
    public static void maxheap(double array[], int i)
    {
        int left_element = 2*i;
        int right_element = 2*i+1;
        int max_element=i;
        if(left_element<=N && array[left_element]> array[i])
           max_element = left_element;
        if (right_element <= N && array[right_element] > array[max_element])        
           max_element = right_element;
        
        if(max_element!=i)
        {
            swap(array,i, max_element);
            maxheap(array,max_element);
        }
        
    }
    
    public static void swap(double array[], int i, int j)
    {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        
    }
    
    public static void main(String[] args) throws IOException 
    {
        

    	File file = new File("src/daa/sortingAlgorithmInput.txt");

    	try {

    		Scanner scanFile = new Scanner(file);

    		Integer inputSize = scanFile.nextInt();

    		array = new double[inputSize]; 

    		for(int i=0;i<inputSize;i++) {

    			array[i] = scanFile.nextDouble();

    		}

    		scanFile.close();

    	} catch(Exception e) {

    		e.printStackTrace();

    	}
        System.out.println("Unsorted array:");
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        
        long startTime = System.nanoTime();
        sorting(array);
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;
        
        System.out.println("\nSorted array:");
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println("\n\nRunning time:" +runningTime+" ns");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter k-th element:");
        int k = sc.nextInt();
        sc.close();
        System.out.println("\nk=" +k);
        System.out.println();
        System.out.println("Kth smallest element is" +array[k-1]);
        System.out.println("the top k elements are as follows:");
        
        //System.out.println("array size: " +(array.length-1));
        for(int i=array.length-1;i>array.length-k-1;i--)
        {
            System.out.println(i+1+": "+array[i]+"");
            System.out.println();
        }
    }
        
        
    }