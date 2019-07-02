package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort1 {

	// Complete the insertionSort1 function below.
	static void insertionSort1(int n, int[] arr) {
		int i, v;
		i = n - 2;
		v = arr[n - 1];
		while (i >= 0) {
			if (v < arr[i]) {
				arr[i + 1] = arr[i];
			} else {
				arr[i + 1] = v;
				break;
			}
			print(arr);
			i--;
		}
		if (i == -1) {
			arr[i + 1] = v;
		}
		print(arr);

	}

	static void print(int[] arr) {
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		insertionSort1(n, arr);

		scanner.close();
	}
}
