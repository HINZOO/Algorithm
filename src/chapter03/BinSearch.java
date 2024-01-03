package chapter03;

import java.util.Scanner;

//이진검색
//검색대상이 정렬되어있음을 가정합니다.
//중앙값을 찾아 검색하려는 값보다 크면 중앙값 앞 범위를, 중앙값이 키값보다 작으면 중앙값 뒤의 범위를 검색하며
//검색범위를 줄여가며 검색하는 방법으로 검색범위가 더 없거나 키와 중앙값이 같을때 종료 된다.
public class BinSearch {
	//요소수가 n개인 배열 a에서 key 와 같은 요소를 이진검색
	static int binSeacrh (int[] a, int n, int key) {
		int pl = 0; 	//검색범위의 첫번째 인덱스
		int pr = n - 1; //검색범위의 끝 인덱스
		
		do {
			int pc = (pl+pr) / 2 ; //중앙요소의 인덱스
			if(a[pc] == key) return pc;
			else if (a[pc] < key) pl = pc+1; //첫번째 인덱스를 중앙값보다 크게 설정 pc+1 ~ pr
			else pr = pc-1;  //마지막 인덱스를 중앙값보다 하나 작게 설정  1 ~pr
		}while(pl<=pr); //첫번째 인덱스가 마지막인덱스보다 크면 종료한다. 
		
		return -1; //검색실패 
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요소수: ");
		int num = scanner.nextInt();
		int[] x = new int [num];
		
		System.out.println("오름차 순으로 입력하세요.");
		
		System.out.print("x[0]: "); //첫요소 입력받음
		x[0] = scanner.nextInt();
		
		for(int i = 1 ; i < num ; i++) {
			do {
				System.out.print("x[" + i + "]: ");
				x[i]= scanner.nextInt(); 
			} while (x[i] < x[i-1]);//앞의 요소보다 작으면 다시 입력.
		}
		System.out.print("검색 할 값 : ");
		int ky = scanner.nextInt();
		
		int idx = binSeacrh(x, num, ky);
		
		if (idx == -1) System.out.println("그 값의 요소가 없습니다.");
		else System.out.println("그 값은 x[" + idx + "]에 있습니다.");
		
		scanner.close();
	}
	
}
