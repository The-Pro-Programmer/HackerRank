package datastructures.stacks;

import java.util.Stack;

public class BalancingBrackets{
	
	public static void main(String args[]){
		
		int dels = getBalancingDeletions("((()))");
		System.out.println(dels);
		dels = getBalancingDeletions("((()))))");
		System.out.println(dels);
		dels = getBalancingDeletions("((()()()))))");
		System.out.println(dels);
		dels = getBalancingDeletions("((()()()))))(((");
		System.out.println(dels);
	}
	
	static int getBalancingDeletions(String b){
		int count = 0;
		Stack<String> st = new Stack<>();
		for(int i=0; i<b.length(); i++){
			String str = ""+b.charAt(i);
			if(str.equals("(")){
				st.push(str);
			}else{
				if(st.isEmpty()){
					count++;
				}else{
					st.pop();
				}
			}
		}
		while(!st.isEmpty()) {
			st.pop();
			count++;
		}
		
		return count;
	}
	
}