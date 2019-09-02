package algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GemStones {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int len = arr.length;
        int count = 0;
        Map<String, Integer> charMap = new HashMap<>();
        for(int i=0; i<len; i++){
            System.out.println(charMap);
            String str = arr[i];
            Set<String> chars = new HashSet<String>();
            for(int j=0; j<str.length(); j++){                
                String temp = ""+str.charAt(j);
                if(chars.add(temp)){
                    int cnt = charMap.containsKey(temp) ? charMap.get(temp) : 0;
                    cnt++;
                    charMap.put(temp, cnt);
                }
            }
        }
        for(Integer val : charMap.values()){
            if(val>=len){
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
