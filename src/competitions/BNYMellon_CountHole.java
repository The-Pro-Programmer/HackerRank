package competitions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution2 {

    /*
     * Complete the 'countHoles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER number as parameter.
     */

    public static int countHoles(int number) {
        String str = ""+number;
        int count = 0;
        int len = str.length();
        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(ch=='8'){
                count+=2;
            }
            if(ch=='0' || ch=='4' || ch=='6' || ch=='9'){
                count +=1;
            }
        }

        return count;
    }

}

public class BNYMellon_CountHole {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int number = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Solution2.countHoles(number);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
