package algorithms.warmups;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long summax = 0, summin = 0;
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(i!=0){
                summax += arr[i];
            }
            if(i<n-1){
                summin += arr[i];
            }
        }
        System.out.println(summin + " " + summax);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}