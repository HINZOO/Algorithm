package chapter06;

import java.util.Scanner;

public class BubbleSort3 {

	// a[idx1]과 a[idx2]의 값 교환
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}

	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		int k = 0; // a[k] 보다 앞쪽은 정렬을 마친 상태
		while (k < n - 1) {
			int last = n - 1;
			for (int j = n - 1; j > k; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;
				}
			}
			k = last;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬 ver3");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		// 요소값 입력
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx);// 버블정렬

		System.out.println("오름차 순으로 정렬했습니다.");
		// 정렬결과 출력
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]= " + x[i]);
		}

	}

}
