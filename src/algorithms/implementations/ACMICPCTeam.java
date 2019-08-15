package algorithms.implementations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACMICPCTeam {


    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int op[] = new int[2];
        int len = topic.length;
        int people = len;
        int maximal = 0;
        int knowmax = 0;
        ArrayList<Integer> knowlist = new ArrayList<>();
        for(int i=0; i<people-1; i++){
            String know1 = topic[i];
            int tlen = know1.length();
            for(int j=i+1; j<people; j++){
                String know2 = topic[j];
                int knowtemp = 0;
                for(int k=0; k<tlen; k++){
                    if(know1.charAt(k)== '1' || know2.charAt(k) == '1'){
                        knowtemp++;
                    }
                }
                knowlist.add(knowtemp);
                if(knowtemp>knowmax){
                    knowmax = knowtemp;
                }
            }
        }
        for(Integer num : knowlist){
            if(num==knowmax){
                maximal++;
            }
        }
        op[0] = knowmax;
        op[1] = maximal;
        return op;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
