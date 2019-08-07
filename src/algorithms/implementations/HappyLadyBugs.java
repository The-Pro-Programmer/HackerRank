package algorithms.implementations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HappyLadyBugs {


    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        int len = b.length();
        if(!b.contains("_")){
            if(b.length()==1){
                return "NO";
            }
            //check if bugs are happy
            Map<String, Integer> charCount = getCharCount(b);
            if(containsMonoCount(charCount)){
                return "NO";
            }
            for(int i=1; i<len-1; i++){
                char ch = b.charAt(i);
                char left = b.charAt(i-1);
                char right = b.charAt(i+1);
                if(!(ch==left || ch == right)){
                    return "NO";
                }
            }
            return "YES";
        }
        //if string contains only _ then happy case
        String temp = b.replace("_", "");
        if(temp.length()<1){
            return "YES";
        }
        Map<String, Integer> charCount = getCharCount(b);
        if(containsMonoCount(charCount)){
            return "NO";
        }
        return "YES";
    }

    static Map<String, Integer> getCharCount(String str){
        Map<String, Integer> count = new HashMap<>();
        int len = str.length();
        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(ch!='_'){
                String temp = ""+ch;
                int cnt = 1;
                if(count.containsKey(temp)){
                    cnt += count.get(temp);
                }
                count.put(temp, cnt);
            }
        }
        return count;
    }

    static boolean containsMonoCount(Map<String, Integer> count){
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if(entry.getValue()==1){
                return true;
            }
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
