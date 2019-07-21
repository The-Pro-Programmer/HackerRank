package algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Anagrams {

    // Complete the anagram function below.
    static int anagram(String s) {
        int len = s.length();
        if(len%2!=0){
            return -1;
        }
        String left = s.substring(0, len/2);
        String right = s.substring(len/2);
        int cnt1 = getDistinctCharCount(left);
        int cnt2 = getDistinctCharCount(right);
        if(cnt1>cnt2){
            String temp = left;
            left = right;
            right = temp;
        }
        int count = 0;
        int[] charCnt = new int[26];
        Arrays.fill(charCnt, 0);
        for(int i=0; i<len/2; i++){
            int pos = left.charAt(i) - 'a';
            charCnt[pos] = charCnt[pos] + 1;
        }
        for(int i=0; i<len/2; i++){
            int pos = right.charAt(i) - 'a';
            int cnt = charCnt[pos];
            if(cnt<=0){                
                count++;
            }
            cnt--;
            charCnt[pos] = cnt;
        }
        return count;
    }

    static int getDistinctCharCount(String str){
        Set<Character> chset = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            chset.add(str.charAt(i));
        }
        return chset.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
