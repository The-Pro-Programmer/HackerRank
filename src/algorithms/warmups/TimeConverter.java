package algorithms.warmups;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class TimeConverter {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String str) {
        String timeStr = str.substring(0, str.length()-2);
        String timeZoneStr = str.substring(str.length()-2);
        String timeArr[] = timeStr.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        if(timeZoneStr.equals("PM")){            
            if(hour!=12){
                hour += 12;
                timeStr = hour + timeStr.substring(2);
            }
        }else{
            if(hour==12){
                timeStr = "00" + timeStr.substring(2);

            }
        }
        return timeStr;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
