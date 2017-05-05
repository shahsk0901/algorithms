package daa;

import java.util.*;
import java.io.*;

public class GenerateArray {
	
	private static Integer inputSize;
	private static Integer type;
	private static Integer k;
	private static Writer file;
	
    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	System.out.print("1) Order Statistics\n2) Sorting Algorithm\n\nGive choice ");
    	type = scan.nextInt();
    	if(!type.equals(1) && !type.equals(2)) {
    		System.out.println("Wrong Input! Run Again");
    		System.exit(0);
    	}
    	System.out.print("Give size of array: ");
    	inputSize = scan.nextInt();
    	if(type == 1) {
    		System.out.print("\nGive k-th element: ");
        	k = scan.nextInt();
    	}
    	System.out.print("\nChoose input type:\n1) Uniform Data Distribution\n2) Normalized Data Distribution\n\nGice choice: ");
    	Integer dataOption = scan.nextInt();
    	scan.close();
    	if(type == 1) {
        	try {
        		file = new FileWriter("src/daa/orderStatisticsInput.txt");
        		file.write(k+" "+inputSize+"\n");
        		file.close();
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    	} else {
    		try {
        		file = new FileWriter("src/daa/sortingAlgorithmInput.txt");
        		file.write(inputSize+"\n");
        		file.close();
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    	switch(dataOption) {
    	case 1:
    		uniformArray(inputSize);
    		break;
    	case 2:
    		normalArray(inputSize);
    		break;
    	default:
    		System.out.println("Wrong Choice! Run Again.");
    	}
    	
    }
    
	public static void uniformArray(Integer inputSize) {
        Random rnd = new Random();
        Double rndMax = 10001.0;
        Double rndMin = 0.0;
        try {
        	if(type == 1) {
        		file = new FileWriter("src/daa/orderStatisticsInput.txt",true);
        	} else {
        		file = new FileWriter("src/daa/sortingAlgorithmInput.txt",true);
        	}
        	for(int i=0;i<inputSize;i++) {
        		Double temp = rndMin + (rnd.nextDouble() * (rndMax-rndMin));
        		Double n = Math.floor(temp);
        		try {
        			file.write(n+"\n");
        		} catch(Exception e) {
        			e.printStackTrace();
        		}
        	}
        	file.close();
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
	public static void normalArray(Integer inputSize) {
        Random rnd = new Random();
        
        try {
        	if(type == 1) {
        		file = new FileWriter("src/daa/orderStatisticsInput.txt",true);
        	} else {
        		file = new FileWriter("src/daa/sortingAlgorithmInput.txt",true);
        	}
        	for(int i=0;i<inputSize;i++) {
        		Double temp = 500 + (rnd.nextGaussian() * 50);
        		Double n = Math.floor(temp);
        		try {
        			file.write(n+"\n");
        		} catch(Exception e) {
        			e.printStackTrace();
        		}
        	}
        	file.close();
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
