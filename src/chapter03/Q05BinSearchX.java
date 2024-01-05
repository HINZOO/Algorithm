package chapter03;

import java.util.Scanner;

public class Q05BinSearchX {
	static int binSearchX(int[] a, int n, int key) {
		
		int pl = 0;
		int pr = n -1;
		do {
			int pc = (pl + pr)/2;
			if(a[pc]==key) {
				for(int i = pl ; i<pc ; i++) {
					if(a[i]==key) {
						return i; 
					}
				}					
				return pc;
			}
//답지는 이렇게 썼다..
//			for ( ; pc > pl; pc--)	// key와 같은 맨앞의 요소를 검색합니다
//				if (a[pc - 1] < key)
//					break;
//			return pc;
			else if (a[pc] < key) {							
				pl = pc + 1;				
			} else {
				pr = pc - 1;
			} 			
				
		}while (pl <= pr);
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int num = scanner.nextInt();
		int[] x = new int[num];				// 요솟수가 num 인 배열 

		System.out.println("오름차순으로 입력하세요.");

		System.out.print("x[0] : ");		// 맨앞 요소를 입력받음
		x[0] = scanner.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = scanner.nextInt();
			} while (x[i] < x[i - 1]);	// 바로 앞의 요소보다 작으면 다시 입력 받음
		}

		System.out.print("검색 값 : ");			// 키값을 입력받음
		int ky = scanner.nextInt();

		int idx = binSearchX(x, num, ky);	// 배열 x에서 값이 ky인 요소를 검색

		if (idx == -1)
			System.out.println("그 값의 요소는 존재하지 않습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
		scanner.close(); 
	}
}
