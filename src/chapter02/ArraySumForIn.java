package chapter02;

//배열의 모든 요소의 합을 구하여 출력
//향상된 For문
public class ArraySumForIn {

	public static void main(String[] args) {
		double[] a = {1.0, 2.0, 3.0, 4.0, 5.0};
		
		for(int i = 0 ; i < a.length ; i++) {
			System.out.println("a["+ i + "] = " + a[i]);
		}
		
		double sum = 0;
		for( double i : a) { //향상된  for문 :: 인덱스를 사용하지 않을때 사용하는것이 유용하다.
			sum += i;
		}
		
		System.out.println("모든 요소의 합은 " + sum + "입니다.");
	}

}
