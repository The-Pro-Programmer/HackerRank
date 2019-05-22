package algorithms.warmups;

import java.util.Scanner;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
        for(int i=1; i<=n; i++){
            int j=n-i;
            while(j>0){
                System.out.print(" ");
                j--;
            }
            for( j=1; j<=i; j++){
                System.out.print("#");
            }
            System.out.println();
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
