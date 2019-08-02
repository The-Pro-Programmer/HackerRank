package algorithms.implementations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long count = 0;
        int len = s.length();
        if(n>=len){
            long factor = n/len;
            int as = getAs(s);
            long rem = n%len;
            count = (long)(as*factor);
            if(rem!=0){
                String small = s.substring(0, (int)rem);  
                count += getAs(small);
            }
        }else{
            String small = s.substring(0, (int)n);
            count = getAs(small);
        }
        return count;
    }

    static int getAs(String str){
        int len =str.length();
        int count = 0;
        for(int i=0; i<len; i++){
            if(str.charAt(i)=='a'){
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
