package algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        int n = queries.length;
        String op[] = new String[n];
        Set<Integer> weights = new HashSet<>();
        char prev = s.charAt(0);
        weights.add(prev-'a'+1);
        int sum = prev-'a'+1;
        for(int i=1; i<s.length(); i++){
            char next = s.charAt(i);
            if(prev==next){
                sum += (prev-'a'+1);
                weights.add(sum);
            }else{
                weights.add(next-'a'+1);
                prev = next;
                sum = (prev-'a'+1);
            }
        }
        for(int i=0; i<n; i++){
            op[i] = (weights.contains(queries[i])) ? "Yes" : "No";
        }
        return op;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
