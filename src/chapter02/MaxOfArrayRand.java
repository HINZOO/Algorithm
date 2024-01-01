package chapter02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {
	
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
		System.out.print("사람 수 : ");
		int num = stdIn.nextInt();
		
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
/*
 * [Random 클래스]
 * Random 클래스의 인스턴스는 일련의 의사난수(진짜 난수와 비슷한 가짜 난수=예측가능한숫자로써 암호화용으로는 사용불가)를 생성한다.
 * 난수는 seed(씨앗)라는 수의 값을 바탕으로 여러 연산을 수행하여 얻게된다.
 * Random 클래스에서는 48bit의 seed를 사용하고, 이 seed는 선형합동법이라는 계산법에 의해 특정 수 (난수)로 바뀐다.
 * 인스턴스의 생성은 크게 두가지로 가능
 * 	1) Random rand = new Random();
 *  2) Random rand = new Random(n); //seed를 지정
 *	Math 클래스에서도 사양은 조금 다르지만 난수를 생성하는 라이브러리를 제공한다.
 *
 *  * Random 클래스의 메서드
 *  nextBoolean() : t/f
 *  nextInt() : int 값의 양음의 범위 중 하나
 *  nextInt(n) : 0 ~ n-1 숫자
 *	nextLong() : Long값의 양음 범위 중 하나
 *	nextDouble() : 0.0 이상 1.0 미만
 *	nextFloat() : 0.0 이상 1.0 미만
 */

