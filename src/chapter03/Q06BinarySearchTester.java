package chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class Q06BinarySearchTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요소 수 : ");
		int num = scanner.nextInt();
		int[] x = new int [num];
		
		System.out.println("오름차 순으로 입력하세요.");
		
		System.out.print("x[0]: ");
		x[0] = scanner.nextInt();
		
		for (int i = 1; i < num ; i++) {
			do {
				System.out.print("x["+ i + "]: " );
				x[i] = scanner.nextInt();				
			}while (x[i] < x[i-1]);
		}
		
		System.out.print("검색할 값 : ");
		int ky = scanner.nextInt();
		
		int idx = Arrays.binarySearch(x,ky);//ky가 없을때  삽입포인트가 x 라면 idx = -x-1 의 값을 반환한다.
											//ky값이 배열의 마지막값보다 더 큰수라면 배열의 길이를 삽입포인트X값으로 생각하여 -X-1을 반환.
		
		if(idx < 0) System.out.println("그 값의 요소가 없습니다. 삽입포인트는" + (-idx-1) +"입니다.");
		else System.out.println("그 값은 x["+ idx +"]에 있습니다.");
		scanner.close();		
	}
}
