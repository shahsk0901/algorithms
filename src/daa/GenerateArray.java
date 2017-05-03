package daa;

import java.util.Random;
import java.io.*;

public class GenerateArray {
	
	GenerateArray() {
	}
	
    public static void main(String[] args) {
    	generateArray(inputSize);
    }
    
	public void generateArray(Integer inputSize) {
        Random rnd = new Random();
        Double rndMax = 10000.00;
        Double rndMin = 0.00;
        try {
        	Writer file = new FileWriter("src/daa/input.txt");
        	for(int i=0;i<inputSize;i++) {
        		Double temp = rndMin + (rnd.nextDouble() * (rndMax-rndMin));
        		Integer n = (int) Math.floor(temp);
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
