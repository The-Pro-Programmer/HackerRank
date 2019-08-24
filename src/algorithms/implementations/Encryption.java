package algorithms.implementations;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replace(" ", "");
        String op = "";
        int len = s.length();
        double sqrt = Math.sqrt(new Double(len));
        int row = (int)Math.floor(sqrt);
        int col = (row*row>=len) ? row : (int)Math.ceil(sqrt);
        if(row*col<len && row<col){
            row = col;
        }
        char[][] grid = new char[row][col];
        int index = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(index>=len){
                    break;
                }
                char ch = s.charAt(index);
                grid[i][j] = ch;
                index++;
            }
        }
        for(int j=0; j<col; j++){
            for(int i=0; i<row; i++){
                char ch = grid[i][j];
                if(ch>='a' && ch<='z')
                    op += ch;
            }
            op += " ";
        }
        return op.substring(0, op.length()-1);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
