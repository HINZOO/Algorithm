package chapter02;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
	
	//배열 요소를 바꾸는 함수.
	static void swap( int[] a, int idx1, int idx2 ) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//배열 a의 요소를 역순으로 정렬 
	static void reverse( int[] a ) {
		for(int i = 0 ; i < a.length/2 ; i++) {
			swap(a, i, a.length - i - 1);
			//양끝 배열의 값을 바꿔주면서 좁혀나가면 reverse가 된다.
			//배열의 수가 홀수일 때는 a.length/2 값에 해당되지않으므로 중앙값의 인덱스를 가진 값은 변함없이 유지된다.
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요소 수 : ");
		int num = scanner.nextInt();
		
		int[] x = new int[num]; //요소수 만큼의 방의 크기를 가진 배열 생성
		
		for(int i = 0; i < num ; i++) {
			System.out.print("x[" + i + "]: " );
			x[i] = scanner.nextInt();//배열의 각 값 입력
		}
		
		reverse(x);//역순배열 
		
		System.out.println("요소를 역순으로 정렬했습니다.");
		System.out.println("x = " + Arrays.toString(x)); //배열을 String 으로 출력 
		scanner.close();
	}

}
