package chapter05;

import java.util.Scanner;

public class Hanoi {
	
	//no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
	//기둥번호를 정수 1,2,3으로 나타냄 ==> 따라서 기둥번호의 합이 6이므로 목표기둥이 어느 기둥이라도 중간기둥은 6-x-y로 나타낼 수 있음.
	//(중간기둥: 하노이의 탑 특성상 옮길 목표의 기둥과 기존 초기에 있는 기둥 외의 다른 기둥을 말하며 이 기둥에 탑을 옮겨야 최소로 하노이의 탑을 쌓을 수 있다.)
	static void move (int no, int x, int y) {
		if(no>1) {
			move(no-1,x,6-x-y);
		}
		System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n",no,x,y);
		
		if(no>1) {
			move(no-1,6-x-y,y);
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("하노이의 탑");
		System.out.print("원반의 개수 : ");
		int n = stdIn.nextInt();
		
		move(n,1,3);
		
		stdIn.close();
	}
}
