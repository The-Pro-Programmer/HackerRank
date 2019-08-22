package algorithms.implementations;

import java.util.Arrays;
import java.util.List;

public class NonDivisibleSubset {
	
	/*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
        int f[] = new int[k];
        Arrays.fill(f, 0);
        for(Integer num : s){
            f[num%k]++;
        }
        if(k%2==0){
            f[k/2] = Math.min(1, f[k/2]);
        }
        int res = Math.min(f[0], 1);
        for(int i=1; i<=k/2; i++){
            res += Math.max(f[i], f[k-i]);
        }
        return res;
    }

	
}
