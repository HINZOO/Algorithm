package chapter02;

import java.util.Arrays;

public class Q02ReverseArrayEx {
	static void swap (int[] a, int idx1, int idx2) {
		System.out.println(Arrays.toString(a));
		System.out.println( "a[" + idx1 +"] 과 a[" + idx2 +"] 을 교환합니다.");
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,5,1,3,9,6,7};

		swap(arr, 0, 6);
		swap(arr, 1, 5);
		swap(arr, 2, 4);
		System.out.println(Arrays.toString(arr));
		System.out.println("역순 정렬을 마쳤습니다.");		
	}
}

/* 정답
 * class ReverseArrayEx {

	//--- 배열 요소 a[idx1]과 a[idx2]를 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
	}

	//--- 배열 a의 요소를 역순으로 정렬 ---//
	static void reverse(int[] a) {
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length / 2; i++) {
			System.out.println("a[" + i + "]와 a[" + (a.length - i - 1) + "]을 교환합니다.");
			swap(a, i, a.length - i - 1);
			System.out.println(Arrays.toString(a));
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수는  : ");
		int num = stdIn.nextInt();      // 요솟수

		int[] x = new int[num];         // 요솟수가 num인 배열 

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		reverse(x);      // 배열 a의 요소를 역순으로 정렬

		System.out.println("역순 정렬을 마쳤습니다.");
	}
}
*/
