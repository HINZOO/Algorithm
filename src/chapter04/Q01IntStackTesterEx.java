package chapter04;

import java.util.Scanner;

public class Q01IntStackTesterEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IntStack stack = new IntStack(64);// 최대 64개를 푸시할 수 있는 스택
		
		while(true) {
			System.out.println(); //메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", stack.size(), stack.getCapacity());
			System.out.print("(1) 푸시  (2) 팝  (3) 피크  "+
							 "(4) 덤프  (5) 검색  (6) 비움  " +
							 "(7) 출력  (0) 종료 :  ");
			
			
			int menu = scanner.nextInt();
			if(menu == 0) break; // 0 입력시 종료
			
			int x;
			switch(menu) {
			case 1:
				System.out.print("데이터: ");
				x = scanner.nextInt();
				try {
					stack.push(x);					
				}catch(IntStack.OverflowIntStackException e ) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
				
			case 2:
				try {
					x = stack.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				}catch(IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
				
			case 3:
				try {
					x = stack.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				}catch(IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
				
			case 4:
				stack.dump();
				break;
			
			case 5://검색
				System.out.print("찾고자 하는 값 : ");
				x = scanner.nextInt();
				int idx = stack.indexOf(x);
				if(idx > 0) System.out.println("꼭대기에서 " + (stack.size() - idx) +"번째에 있습니다.");
				else System.out.println("찾고자 하는 값이 없습니다.");
				break;
				
			case 6://비움
				stack.clear();
				System.out.println("스택을 모두 비웠습니다.");
				break;
				
			case 7://출력
				System.out.println("용량 : " + stack.getCapacity());
				System.out.println("데이터수 : " + stack.size());
				System.out.println("비어 " + (stack.isEmpty()  ? "있습니다."
														: "있지 않습니다."));
				System.out.println("가득 " + (stack.isFull() ? "차 있습니다."
														: "차 있지 않습니다."));
				break;
				
			}	
			
		}
		scanner.close();
	}
}
