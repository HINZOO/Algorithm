package chapter02;

import java.util.Scanner;

public class Q03SumOf {
	public static int sumOf (int[] a) {
		int sum = 0;
		for(int i = 0 ; i < a.length ; i++ ) {
			sum += a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요소 수: ");
		int num = scanner.nextInt();
		
		int[] arr = new int [num];
		
		for(int i = 0 ; i < num ; i++) {
			System.out.print("arr["+i+"]: ");
			arr[i] = scanner.nextInt();
			
		}
		System.out.println("요소들의 총 합은 " + sumOf(arr)  + "입니다.");
		
		scanner.close();
		
	}
}
