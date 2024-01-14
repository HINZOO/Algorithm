package chapter04;

import java.util.Scanner;

//intQueue.java를 사용한 int 고정길이 큐 사용예
public class IntQueueTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IntQueue que = new IntQueue(64); // 최대 64개를 인큐할수 있는 큐 
		
		while(true) {
		 System.out.println();
		 System.out.printf("현재 데이터 개수: %d / %d\n", que.size(), que.getCapacity());
		 System.out.print("(1) 인큐   (2) 디큐   (3) 피크  (4) 덤프  (5) 검색  (0) 종료 :  ");
		 
		 int menu = scanner.nextInt();
		 
		 if(menu == 0 ) break;
		 
		 int x;
		 switch (menu) {
			 case 1:
				 System.out.print("데이터: ");
				 x = scanner.nextInt();
				 try {
					 que.enque(x);
				 }catch(IntQueue.OverflowIntQueueException e) {
					 System.out.println("큐가 가득 찼습니다.");
				 }
				 break;
			 case 2:
				 try {
					 x = que.deque();
					 System.out.println("Dequeue한 데이터는 " + x + "입니다.");
				 }catch(IntQueue.EmptyIntQueueException e) {
					 System.out.println("큐가 비어 있습니다.");
				 }
				 break;
			 case 3:
				 try{
					 x = que.peek();
					 System.out.println("Peek한 데이터는 "+ x + "입니다.");
				 }catch(IntQueue.EmptyIntQueueException e) {
					 System.out.println("큐가 비어있습니다.");
				 }
				 break;
			 case 4:
				 que.dump();
				 break;
			 case 5:
				 System.out.print("데이터 : ");
					x = scanner.nextInt();
					int n = que.search(x);
					if (n != 0)
						System.out.printf("%d번째 데이터로 인덱스 [%d] 의 위치에 저장되어 있습니다.\n", n, que.indexOf(x));
					else
						System.out.println("그 데이터는 등록되어 있지 않습니다.");
					break;				 	
		 }
		
		}		
		scanner.close();
	}

}
