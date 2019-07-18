package algorithms.implementations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BinaryMadness {
	
	static List<String> odd0 = new ArrayList<String>();
	static List<String> odd1 = new ArrayList<String>();
	

	public static void main(String[] args) {
		List<BigInteger> nums = new ArrayList<BigInteger>();
		nums.add(new BigInteger("341"));
		nums.add(new BigInteger("455"));
		nums.add(new BigInteger("496"));
		nums.add(new BigInteger("992"));
		nums.stream().forEach(num -> getSubStrings(num));
	}

	
	static void getSubStrings(BigInteger num){
        String str = num.toString(2);
        int len = str.length();
        int odd0count = 0, odd1count=0;
        for(int i=0; i<len; i++){
            String sub = str.charAt(i)+"";
            if(getCharCount(sub, '0')%2!=0) {
				odd0count++;
			}
			if(getCharCount(sub, '1')%2!=0) {
				odd1count++;
			}
            for(int j=i+1; j<len; j++){
                sub += str.charAt(j);
                if(getCharCount(sub, '0')%2!=0) {
					odd0count++;
				}
				if(getCharCount(sub, '1')%2!=0) {
					odd1count++;
				}
            }
        }
        System.out.println(odd0count + " " + odd1count);
    }
    
    static int getCharCount(String str, char ch){
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==ch){
                cnt++;
            }
        }
        return cnt;
    }
	
}
