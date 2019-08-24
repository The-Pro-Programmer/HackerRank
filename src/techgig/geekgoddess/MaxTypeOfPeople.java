package techgig.geekgoddess;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.Arrays;
import java.util.Scanner;

public class MaxTypeOfPeople {
    public static void main(String args[] ) throws Exception {

    	//Write code here
        Scanner sc = new Scanner(System.in);
        int qs = sc.nextInt();
        for(int q=1; q<=qs; q++){
            String str = sc.next();
            int len = str.length();
            int max = 0;
            int charcnt[] = new int[26];
            Arrays.fill(charcnt, 0);
            for(int i=0; i<len; i++){
                char ch = str.charAt(i);
                int index = (int)(ch - 'a');
                int val = charcnt[index];
                val++;
                charcnt[index] = val;
                if(val>max){
                    max = val; 
                }
            }
            for(int i=0; i<26; i++){
                if(charcnt[i]==max){
                    System.out.println((char)(i+'a'));
                    break;
                }
            }
        }
        sc.close();
   }
}
