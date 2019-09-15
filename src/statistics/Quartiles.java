package statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quartiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q1=0, q2=0, q3=0;
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            nums.add(num);
        }
        Collections.sort(nums);
        if(n%2==0){
            List<Integer> lower50 = nums.subList(0, n/2);
            q1 = getMedian(lower50);
            q2 = getMedian(nums);
            List<Integer> upper50 = nums.subList(n/2, n);
            q3 = getMedian(upper50);
        }else{
            List<Integer> lower50 = nums.subList(0, n/2);
            q1 = getMedian(lower50);
            q2 = nums.get(n/2);
            List<Integer> upper50 = nums.subList(1+n/2, n);
            q3 = getMedian(upper50);
        }
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        sc.close();
    }

    static int getMedian(List<Integer> nums){
        int n = nums.size();
        if(n%2==0){
            return (nums.get(n/2) + nums.get((n/2)-1))/2;
        }else{
            return nums.get(n/2);
        }
    }
}

