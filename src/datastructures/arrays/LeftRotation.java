package datastructures.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Refer array-left-rotation-English.pdf

public class LeftRotation {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        try{

            String result = "";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            for(int i=d; i<n; i++){
              bufferedWriter.write(a[i] + " ");
            }

            for(int i=0; i<d; i++){
              bufferedWriter.write(a[i] + (i==d-1 ? "" : " "));
            }

            result = result.trim();

            
        
        bufferedWriter.newLine();

        bufferedWriter.close();

        }catch(IOException e){

        }
        
        scanner.close();
		
	}

}
