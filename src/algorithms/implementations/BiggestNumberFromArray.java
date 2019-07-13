package algorithms.implementations;

import java.util.Arrays;

public class BiggestNumberFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {54, 546, 548, 60};
		printLargestNumberFromArray(arr);
		
		int arr2[] =  {1, 34, 3, 98, 9, 76, 45, 4};
		printLargestNumberFromArray(arr2);

	}
	
	static void printLargestNumberFromArray(int arr[]) {
		int n = arr.length;
		String strArr[] = new String[n];
		for(int i=0; i<n; i++) {
			strArr[i] = ""+arr[i];
		}
		Arrays.sort(strArr);
		for(int i=n-1; i>=0; i--) {
			System.out.print(strArr[i]);
		}
		System.out.println();
	}

}
