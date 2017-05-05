package daa;
import java.io.File;
import java.util.Arrays;
import java.util.*;

public class MedianOfMedian 
{   
    private static Double[] arr;
    
    private static Integer pivot;
    
    private static Integer kelement;
    
    public static void main(String[] args)    
    {       
        File file = new File("src/daa/orderStatisticsInput.txt");
    	try {
    		Scanner scanFile = new Scanner(file);
    		kelement = scanFile.nextInt();
                Integer inputSize = scanFile.nextInt();                
                
                System.out.println(kelement);
                System.out.println(inputSize);
    		arr = new Double[inputSize]; 
    		for(int i=0;i<inputSize;i++) 
                {
    			arr[i] = scanFile.nextDouble();
    		}
    		scanFile.close();
    	} 
        catch(Exception e) 
        {    e.printStackTrace();}
        
        //System.out.println(arr.length);
        
        
        Double arrayofmedians[]=chunkarray(arr,3);
        //System.out.println(Arrays.toString(arrayofmedians));
          
        Integer medianofmedians=(Integer)((arrayofmedians.length-1)/2);
        //System.out.println(medianofmedians);
        
        Double kthelement=kthsmallest(arr,0,arr.length-1,kelement);
        System.out.println(kelement+"th element:"+kthelement);
        
        System.out.println("Time Taken:"+((System.nanoTime()-start))+"ns");
    }

    public static Double[] chunkarray(Double arr[],int chunkSize)
    {
        int numOfChunks=(int)Math.ceil((double)arr.length/chunkSize);
        
        Double output[][]= new Double [numOfChunks][];
        Double medians[]=new Double[numOfChunks];
        
        int pivot=(int)((chunkSize-1)/2);
        
         for(int i = 0; i < numOfChunks; ++i) 
         {
            int start = i * chunkSize;
            int length = Math.min(arr.length - start, chunkSize);

            Double[] temp = new Double[length];
            System.arraycopy(arr, start, temp, 0, length);
            Arrays.sort(temp);
            System.out.println(Arrays.toString(temp));
            output[i] = temp;
                        
            for(int j = 0; j < 5; ++j) 
            {  
                if(j==pivot)
                {   medians[i]=output[i][pivot];
                    System.out.println(medians[i]);
                }   
            }
        }
        return medians;
    }

    public static Integer getMedian(Double[] arr,Integer start, Integer end,Integer k) {
        Integer index = ((start+end)/2);
        Integer median =
    }

    public static Double kthsmallest(Double[] arr,Integer start, Integer end,Integer k) {
        if(start<=end) {
            pivot = getMedian(arr,start, end, k);
            //pivot = splitArr(arr,start,end);
            Integer kth = pivot - start + 1;
            if(k<kth) {
                kthsmallest(arr,start,pivot-1,k);
            } else if(k>kth) {
                kthsmallest(arr,pivot+1,end,k-kth);
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
