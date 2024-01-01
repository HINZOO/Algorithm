package chapter02;

import java.util.Random;
import java.util.Scanner;

//키 뿐만 아니라 사람수도 난수로 생성하도록 수정하세요.

public class Q01MaxOfArrayRand2 {
	static int maxOf(int[] a) {
		int max = a[0];
		for(int i = 1; i < a.length ; i++) {
			if(a[i]>max) 
				max = a[i];
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		int num = random.nextInt(10) + 1 ; //1부터 10까지의 사람 수 랜덤지정
		System.out.println("사람 수 : " + num);
		
		int[] height = new int [num]; // 요소수가 num인 배열 생성.
		
		System.out.println("키 값은 아래와 같습니다.");
		for (int i = 0 ; i < num ; i++) {
			height[i] = 100 + random.nextInt(90); //0부터 89까지의 난수가 생성 
			System.out.println("height[" + i + "]: " + height[i]);
		}
		
		System.out.println("최댓값은: " + maxOf(height) + "입니다.");
		stdIn.close();
	}
}
