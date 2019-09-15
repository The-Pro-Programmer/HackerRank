package statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MeanMedianMode {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Double> list = new ArrayList<>();
        Map<Double, Integer> occurances = new HashMap<>();
        Double sum = 0d;
        int max = 0;
        Double mode = Double.MAX_VALUE;
        for(int i=0; i<n; i++){
            Double d = sc.nextDouble();
            list.add(d);
            int cnt = 1;
            if(occurances.containsKey(d)){
                cnt += occurances.get(d);
            }
            occurances.put(d, cnt);
            sum += d;
            if(cnt>max){
                max = cnt;
            }
        } 
        Collections.sort(list);
        Double mean = (sum/n);
        Double median = 0d;
        if(n%2==0){
            median = (list.get(n/2) + list.get((n/2)-1))/2;
        }else{
            median = list.get(n/2);
        }
        for(Map.Entry<Double, Integer> entry : occurances.entrySet()){
            if(entry.getValue()==max){
                if(entry.getKey()<mode){
                    mode = entry.getKey();
                }
            }
        }
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        sc.close();
    }
}

