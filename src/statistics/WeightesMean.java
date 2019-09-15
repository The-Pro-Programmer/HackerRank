package statistics;

import java.util.Scanner;

public class WeightesMean {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float sumW = 0;
        float sumXW = 0;
        float x[] = new float[n];
        for(int i=0; i<n; i++){
            x[i] = sc.nextFloat();
        }
        for(int i=0; i<n; i++){
            float w = sc.nextFloat();
            sumW += w;
            sumXW += (x[i]*w);
        }
        float weightedMean = (sumXW/sumW);
        System.out.println(String.format("%.1f",weightedMean));
        sc.close();
    }
}


