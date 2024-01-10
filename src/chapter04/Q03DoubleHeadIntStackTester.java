package chapter04;

import java.util.Scanner;

import chapter04.DoubleHeadIntStack.AorB;

public class Q03DoubleHeadIntStackTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		DoubleHeadIntStack s = new DoubleHeadIntStack(64);	// 최대 64개 푸시할 수 있는 머리가 둘인 스택

		while (true) {
			System.out.println("현재 데이터 개수 : "+
												 "A : " + s.size(DoubleHeadIntStack.AorB.StackA) + "/" + 
												 "B : " + s.size(DoubleHeadIntStack.AorB.StackB));
			System.out.print("( 1) A 푸시 ( 2) A 팝 ( 3) A 피크 " + "( 4) A 덤프 ( 5) A 검색 ( 6) A 비움\n" +
							 "( 7) B 푸시 ( 8) B 팝 ( 9) B 피크 " + "(10) B 덤프 (11) B 검색 (12) B 비움\n" +
							 "(13)   출력 ( 0) 종료 : ");
			
			AorB stkA = DoubleHeadIntStack.AorB.StackA;
			AorB stkB = DoubleHeadIntStack.AorB.StackB;
			

			int menu = stdIn.nextInt();
			if (menu == 0) break;

			int n, x = 0;
			switch (menu) {
			 case 1:													// A에 푸시
				System.out.print("데이터 : ");
				x = stdIn.nextInt();
				try {
					s.push(stkA, x);
				 } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			 case 2:													// A에서 팝
				try {
					 x = s.pop(stkA);
					System.out.println("팝한 데이터는 " + x + "입니다.");
				 } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			 case 3:													// A에서 피크
				try {
					 x = s.peek(stkA);
					System.out.println("피크한 데이터는 " + x + "입니다.");
				 } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			 case 4:													// A를 덤프
				s.dump(stkA);
				break;

			 case 5:													// A에서 검색
				System.out.print("검색할 데이터 : ");
				x = stdIn.nextInt();
				n = s.indexOf(stkA, x);
				if (n >= 0)
					System.out.println("꼭대기에서 " + (s.size(stkA) - n) +"번째에 있습니다.");
				else
					System.out.println("그 데이터가 없습니다.");
				break;

			 case 6:													// 비웁니다
				s.clear(stkA);
				break;

			 case 7:													// B에 푸시
				System.out.print("데이터 : ");
				x = stdIn.nextInt();
				try {
					s.push(stkB, x);
				 } catch (DoubleHeadIntStack.OverflowDoubleHeadIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			 case 8:													// B에서 팝
				try {
					 x = s.pop(stkB);
					System.out.println("팝한 데이터는 " + x + "입니다.");
				 } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			 case 9:													// B에서 피크
				try {
					 x = s.peek(stkB);
					System.out.println("피크한 데이터는 " + x + "입니다.");
				 } catch (DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			 case 10:													// B를 덤프
				s.dump(stkB);
				break;

			 case 11:													// B에서 검색
				System.out.print("검색할 데이터 : ");
				x = stdIn.nextInt();
				n = s.indexOf(stkB, x);
				if (n >= 0)
					System.out.println("꼭대기에서 " + (s.size(stkB) - (s.getCapacity() - n) + 1) +"번째에 있습니다.");
				else
					System.out.println("그 데이터가 없습니다.");
				break;

			 case 12:													// 비웁니다
				s.clear(stkB);
				break;

			 case 13:													// 데이터 출력
				System.out.println("용량 : " + s.getCapacity());
				System.out.println("A의 데이터수 : " + s.size(stkA));
				System.out.println("B의 데이터수 : " + s.size(stkB));
				System.out.println("A는 비어 " + (s.isEmpty(stkA) ? "있습니다."
																										: "있지 않습니다."));
				System.out.println("B는 비어 " + (s.isEmpty(stkB) ? "있습니다."
																										: "있지 않습니다."));
				System.out.println("가득 차 " + (s.isFull() ? "있습니다."
																										: "있지 않습니다."));
				break;
			}
		}
		stdIn.close();
	}
}
