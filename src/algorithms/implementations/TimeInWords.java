package algorithms.implementations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeInWords {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        if(m==15){
            return "quarter past " + getStr(h);
        }
        if(m==45){
            if(h==12){
                h = 0;
            }
            return "quarter to " + getStr(h+1);
        }
        if(m==0){
            return getStr(h) + " o' clock";
        }
        if(m==30){
            return "half past " + getStr(h);
        }
        if(m<30){
            if(m==1){
                return getStr(m) + " minute past " + getStr(h);
            }
            return getStr(m) + " minutes past " + getStr(h);
        }
        if(m>30){
            if(h==12){
                h = 0;
            }
            if(m==1){
                return getStr(60-m) + " minute to " + getStr(h+1);
            }
            return getStr(60-m) + " minutes to " + getStr(h+1);
        }
        return "";
    }

    static String getStr(int num){
        if(num==0){
            return "zero";
        }
        String[] single_digits = new String[]{ "zero", "one",  "two", "three", "four", 
                                        "five", "six", "seven",  
                                            "eight", "nine"}; 
  
        /* The first string is not used, it is to make  
        array indexing simple */
        String[] two_digits = new String[]{"ten", "eleven", "twelve",  
                                        "thirteen", "fourteen", 
                                        "fifteen", "sixteen", "seventeen", 
                                        "eighteen", "nineteen"}; 
  
        /* The first two string are not used, they are to make array indexing simple*/
        String[] tens_multiple = new String[]{"", "", "twenty", "thirty", "forty",  
                                            "fifty","sixty", "seventy",  
                                            "eighty", "ninety"}; 

        if(num<10)
            return single_digits[num];
        if(num<20)
            return two_digits[num-10];
        {
            int n10 = num/10;
            int n1 = num%10;
            if(n1==0){
                return tens_multiple[n10];
            }else{
                return tens_multiple[n10]+" " + single_digits[n1];
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
