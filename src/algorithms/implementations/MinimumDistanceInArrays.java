package algorithms.implementations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumDistanceInArrays {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        Integer min = Integer.MAX_VALUE;
        int n = a.length;
        for(int i=0; i<n; i++){
            int key = a[i];
            for(int j=n-1; j>i; j--){
                if(key==a[j] && Math.abs(j-i)<min){
                    min = Math.abs(i-j);
                }
            }
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
