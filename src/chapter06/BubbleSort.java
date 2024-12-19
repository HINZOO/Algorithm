package chapter06;

import java.util.Scanner;

public class BubbleSort {

	// a[idx1]과 a[idx2]의 값 교환
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}

	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {// 전이 후보다 값이 크면
					swap(a, j - 1, j);// 위치바꿈 ==> 값비교, 교환하는 과정을 합쳐서 패스라 한다
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬 ver1");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		//요소값 입력
		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx);//버블정렬

		System.out.println("오름차 순으로 정렬했습니다.");
		//정렬결과 출력
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]= " + x[i]);
		}

	}

}
