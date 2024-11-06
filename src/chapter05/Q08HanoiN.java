package chapter05;

import java.util.Scanner;

public class Q08HanoiN {

	static void move(int no, int x, int y) {
		int[] xstk = new int[100];
		int[] ystk = new int[100];
		int[] sstk = new int[100];
		int pointer = 0; // 스텍 포인터
		int sw = 0;

		while (true) {
			if (sw == 0 && no > 1) {
				xstk[pointer] = x;
				ystk[pointer] = y;
				sstk[pointer] = sw;
				pointer++;
				no = no - 1;
				y = 6 - x - y;
				continue;
			}
			System.out.printf("원반 [%d]을 %d 기둥에서 %d 기둥으로 이동\n", no, x, y);

			if (sw == 1 && no > 1) {
				// PUSH
				xstk[pointer] = x;
				ystk[pointer] = y;
				sstk[pointer] = sw;
				pointer++;
				no = no - 1;
				y = 6 - x - y;
				if (++sw == 2)
					sw = 0;
				continue;
			}
			do {
				if (pointer-- == 0)
					return; // 스텍이 비어있는 경우 리턴
				// POP
				x = xstk[pointer];
				y = ystk[pointer];
				sw = sstk[pointer] + 1;
				no++;
			} while (sw == 2);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("하노이의 탑");
		System.out.print("원반의 개수 : ");
		int n = stdIn.nextInt();

		move(n, 1, 3); // 제1기둥에 쌓인 n 개를 제3기둥으로 이동
		stdIn.close();
	}
}
