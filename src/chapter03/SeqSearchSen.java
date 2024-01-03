package chapter03;

import java.util.Scanner;

//선형검색 (보초법; sentinel method)
// 종료조건의 비용을 반으로 줄이는 방법으로 
// 맨 끝 요소에 검색하기 전에 값을 저장한다.
// 이를 통해 보초는 반복문에서 종료 판단횟수를 2회에서 1회로 줄이는 역할을 함.
public class SeqSearchSen {
	static int seqSearch(int[] a , int n , int key) {
		int i = 0;
		a[n] = key ; //보초를 추가
		
		while(true) {
			
			if(a[i] == key) {
				break;
			}
			i++;
		}
		return i == n ? -1 : i ; //마지막 보초값을 출력하면 실패이므로 -1을 반환 아니면 idx를 반환.
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요소수: ");
		int num = scanner.nextInt();
		int[] x = new int [num+1];//보초요소 추가
		
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
