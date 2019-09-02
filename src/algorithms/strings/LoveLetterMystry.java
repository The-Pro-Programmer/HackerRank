package algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoveLetterMystry {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        int count = 0;
        int len = s.length();
        String left = "", right="";
        if(len%2==0){
            left = s.substring(0, len/2);
            right = s.substring(len/2);
        }else{
            left = s.substring(0, len/2);
            right = s.substring(1 + len/2);
        }
        right = rev(right);
        System.out.println(left + " " + right);
        if(left.equals(right)){
            return 0;
        }
        len = left.length();
        for(int i=0; i<len; i++){
            char lch = left.charAt(i);
            char rch = right.charAt(i);
            if(lch!=rch){
                if(lch>rch){
                    char temp = lch;
                    lch = rch;
                    rch = temp;
                }
                while(lch!=rch){
                    rch--;
                    count++;
                }
            }
        }
        return count;
    }

    public static String rev(String str){
        String op = "";
        int len = str.length();
        for(int i=len-1; i>=0; i--){
            op += str.charAt(i);
        }
        return op;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
