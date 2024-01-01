package chapter02;

import java.util.Arrays;

//배열을 복사
public class CloneArray {
	public static void main(String[] args) {
		int[] a  = {1, 2, 3, 4, 5};
		int[] b = a.clone();
		
		b[3] = 0;
		
		System.out.println("a = " + Arrays.toString(a));//a = [1, 2, 3, 4, 5]
		System.out.println("b = " + Arrays.toString(b));//b = [1, 2, 3, 0, 5]
		// b는 a 본체가 아닌 그 복제임을 확인할 수 있다.
		
	}
}	
