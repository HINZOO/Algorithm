package chapter05;

import java.util.Scanner;

public class Q05RecurCount {
	static int count;
	
	static void recur(int n) {
		count++;
		if(n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();
		
		recur(x);
		
		System.out.println("메서드를 호출한 횟수 : " + count);
		stdIn.close();
	}
}
