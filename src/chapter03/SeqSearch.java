package chapter03;

import java.util.Scanner;

//검색알고리즘 
//1.배열에서 검색
//	1)선형 검색 : 무작위로 늘어서 있는 데이터 모임에서 검색을 수행합니다.
//	2)이진 검색 : 일정한 규칙으로 늘어서 있는 데이터 모임에서 아주빠른 검색을 합니다.
//  3)해시법 : 추가, 삭제가 자주 일어나는 데이터 모임에서 아주 빠른 검색을 수행합니다.
//			- 체인법 : 같은 해시값의 데이터를 선형 리스트로 연결하는 방법
//			- 오픈 주소 법 : 데이터를 위한해시값이 충돌할 때 재해시 하는 방법
//2.선형리스트에서 검색
//3.이진검색트리에서 검색

//1.선형검색 : 배열의 요소를 맨 앞부터 순서대로 수행한다.
public class SeqSearch {
	// 요소수가 n인 배열 a 에서 key 와 값이 같은 요소를 선형 검색
	static int seqSearch(int[] a , int n , int key) {
		int i = 0;
		while(true) {
			if (i==n) {
				return -1; // 검색 실패
			}
			if(a[i] == key) {
				return i; // 검색 성공 인덱스를 반환
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요소수: ");
		int num = scanner.nextInt();
		int[] x = new int [num];
		
		for(int i = 0 ; i < num ; i++) {
			System.out.print("x[" + i + "]: ");
			x[i]= scanner.nextInt(); 
		}
		System.out.print("검색 할 값 : ");
		int ky = scanner.nextInt();
		
		int idx = seqSearch(x, num, ky);
		
		if (idx == -1) System.out.println("그 값의 요소가 없습니다.");
		else System.out.println("그 값은 x[" + idx + "]에 있습니다.");
		
		scanner.close();
	}
	
}


/*
무한 루프의 구현
무한루프는 break문이나 return문을 사용하려 루프에서 빠져나올 수 있다.
while (true) {} 
for(;true;) {}
do{} while(true) // do while의 경우 끝까지 읽지않으면 무한루프인지 알 수 없기 때문에 권장하지 않는다.

*/