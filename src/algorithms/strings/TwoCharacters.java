package algorithms.strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class TwoCharacters {

    // Complete the alternate function below.
    static int alternate(String s) {
        int max = 0;
        Set<String> chars = getDistinctChars(s);
        ArrayList<String> pairs = getPairs(chars);
        for(String pair : pairs){
            String temp = s;
            for(String remove : chars){
                if(!remove.equals(""+pair.charAt(0)) && !remove.equals(""+pair.charAt(1))){
                    temp = temp.replace(remove, "");
                }
            }
            if(isAlternate(pair, temp)){
                int len = temp.length();
                if(len>max){
                    max = len;
                }
            }
        }
        return max;
    }

    static boolean isAlternate(String pair, String str){
        char c0 = pair.charAt(0);
        char c1 = pair.charAt(1);
        int len = str.length();
        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(i%2==0){
                if(ch!=c0){
                    return false;
                }
            }else{
                if(ch!=c1){
                    return false;
                }
            }
            
        }
        return true;
    }

    static ArrayList<String> getPairs(Set<String> set){
        ArrayList<String> pairs = new ArrayList<>();
        int n = set.size();
        String arr[] = new String[n];
        arr = set.toArray(arr);
        for(int i=0; i<n-1; i++){
            String s1 = arr[i];
            for(int j=i+1; j<n; j++){
                String s2 = arr[j];
                pairs.add(s1+s2);
            }
        }
        return pairs;
    }

    static Set<String> getDistinctChars(String str){
        int len = str.length();
        Set<String> set = new LinkedHashSet<String>();
        for(int i=0; i<len; i++){
            set.add(""+str.charAt(i));
        }
        return set;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
