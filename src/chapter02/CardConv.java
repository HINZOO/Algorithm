package chapter02;

import java.util.Scanner;

//입력받은 10진수를 2진수  ~ 36진수로 기수 변환하여 출력
public class CardConv {
	
	//정수값 x를 r진수로 변환하여 배열d에 아랫자리부터 넣어두고 자릿수를 변환
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//char배열인것에 주의!
		
		do {
			d[digits++] = dchar.charAt(x % r); //r로 나눈 나머지를 저장
			x /= r; 
			//예를들어 14를 2진수로 변환한다면 14 % 2 인 0을 d[0] = 0 저장하고
			// x = 14/2 =7 이 됨
			// 다시 7%2 를 한 1을 d[1]=1 에 저장
			// x = 7/2 = 3 이됨 이과정을 반복..
			// d[0]= 0, d[1]=1, d[2]=1, d[3]=1 이되고 x가 0되면서 종료됨. 이렇게 생성한 배열을 역순으로 정렬할때 비로소 2진법 값이 완성됨!
		} while(x != 0);
		
		//문자열을 역순으로 정렬
		for(int i = 0 ; i < digits /2 ; i++) {
			char t = d[i];
			d[i] = d [digits - i - 1];
			d[digits - i -1 ] = t;
		}
		return digits;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int no;						// 변환하는 정수
		int cd;						// 기수
		int dno;					// 변환 후의 자릿수
		int retry;					// 다시 한번 ?
		char[] cno = new char[32]; 	// 변환 후 각 자리의 숫자를 넣어 두는 문자 배열
		
		System.out.println("10진수를 기수 변환 합니다.");
		do {
			do {
				 System.out.print("변환하는 음이 아닌 정수: ");
				 no = scanner.nextInt();
			} while(no < 0);
			
			do {
				System.out.print("어떤 진수로 변환 할까요? (2~36) : ");
				cd = scanner.nextInt();
			}while( cd < 2 || cd > 36);
			
			dno = cardConv(no, cd, cno);
			System.out.print(cd + " 진수로 ");
			for(int i =0 ; i < dno; i++) {
				System.out.print(cno[i]);				
			}
			System.out.print("입니다. ");
			
			System.out.print("한번 더 할까요? (1..예/0..아니요) :  ");
			retry = scanner.nextInt();
			
		}while(retry == 1);
		
		scanner.close();
	}
}
