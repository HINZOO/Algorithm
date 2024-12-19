package chapter06.prac;
import java.util.Scanner;
public class BubbleSortEx2 {

	// 배열교환
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	// 버블정렬
	static void bubbleSort(int[] a, int n) {
		int diffCount = 0; // 비교회수
		int changeCount = 0; // 교환횟수

		for (int i = 0; i < n - 1; i++) {
			int exchg = 0;
			System.out.printf("패스%d : \n", i + 1);
			for (int j = n - 1; j > i; j--) {
				for (int m = 0; m < n - 1; m++) {
					System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : ((a[j - 1] > a[j]) ? '+' : '-'));
				}
				System.out.printf("%3d\n", a[n - 1]);
				diffCount++;
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					changeCount++;
					exchg++;
				}
			}
			for (int m = 0; m < n; m++) {
				System.out.printf("%3d  ", a[m]);
			}
			System.out.println();
			if(exchg == 0) break;
		}
		System.out.println("비교를 " + diffCount + "회 했습니다.");
		System.out.println("교환을 " + changeCount + "회 했습니다.");
	}
	

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순교환정렬(버블 정렬)");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx);				// 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
		
		stdIn.close();
	}
}
