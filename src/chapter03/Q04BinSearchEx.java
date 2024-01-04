package chapter03;

import java.net.Socket;
import java.util.Scanner;

public class Q04BinSearchEx {
	
	static int binSearchEx(int[] a, int n, int key) {
		//제일 윗부분 인덱스 표 시
		System.out.print("   |");
		for(int k = 0; k < n ; k++) {
			System.out.printf("%4d",k);			
		}
		System.out.println();
		//가로줄 
		System.out.print("---+");
		for(int k = 0; k < 4*n+2 ; k++) {
			System.out.print("-");			
		}
		System.out.println();
		
		int pl = 0 ;  	//검색범위 첫인덱스
		int pr = n - 1;	//검색범위 마지막 인덱스
		
		
		do {
			int pc = (pl+pr)/2;
			
			//화살표 들어가는 부분 
			System.out.print("   |");
			//검색범위 인덱스 시작 부분 표시 
			if( pl != pc ) {
				System.out.printf(String.format("%%%ds<-%%%ds+",(pl * 4) + 1, (pc - pl) * 4),"", "");
			}else {//pl과 pc가 같으면 값을 찾은것이기 때문에 pc만큼 칸 띄우고 화살표후 뒤의 띄어쓰기X 
				System.out.printf(String.format("%%%ds<-+",   pc * 4 + 1), "");
			}
			
			if ( pc != pr ) {
				System.out.printf(String.format("%%%ds->\n",(pr - pc) * 4 - 2), "");
			}else {// pl과 pr가 같으면 바로 닫힘 
				System.out.println("->");
			}
			
			//이진트리 중앙값이 되는 인덱스 출력
			System.out.printf("%3d|", pc);
			//배열 출력 
			for ( int k = 0 ; k < n ; k++ ) {
				System.out.printf("%4d",a[k]);
			}
			System.out.println("\n   |");
			
			//이진트리 검색
			if(a[pc]==key) return pc;
			else if (a[pc] < key) pl = pc+1;
			else pr = pc -1;			
		}while(pl<=pr);
		return -1 ; //검색실패
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];				// 요솟수가 num 인 배열 

		System.out.println("오름차순으로 입력하세요.");

		System.out.print("x[0] : ");		// 맨앞 요소를 입력받음
		x[0] = stdIn.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]);	// 바로 앞의 요소보다 작으면 다시 입력 받음
		}

		System.out.print("검색 값 : ");			// 키값을 입력받음
		int ky = stdIn.nextInt();

		int idx = binSearchEx(x, num, ky);	// 배열 x에서 값이 ky인 요소를 검색

		if (idx == -1)
			System.out.println("그 값의 요소는 존재하지 않습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
		stdIn.close();
	}
	
}
