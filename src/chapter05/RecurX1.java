package chapter05;

import java.util.Scanner;

import chapter04.IntStack;

//앞쪽 재귀함수는 n-2 하고 나서 n-1을 할 수 없기 때문에 재귀함수 제거가 어렵다
//이때 스택의 개념을 써서 n을 임시저장한 후 저장한 n을 꺼내서 n-1의 계산에 활용한다.

public class RecurX1 {
	static void recur(int n) {
		IntStack s = new IntStack(n); //이전에 만든 intStack을 사용.
//-- 원본 --//
//		if (n > 0) {
//			recur(n - 1);
//			System.out.println(n);
//			recur(n - 2);
//		}
		while(true) {
			if (n > 0) {
				s.push(n);
				n = n - 1;
				continue;//while문의 맨 앞으로 돌아감. 
			}
			if(s.isEmpty()!=true) {//스택이 비어있지 않으면
				n = s.pop(); //다시 n을 꺼냄
				System.out.println(n);
				n = n - 2 ;
				continue;
			}
			break; //n이 0이고 스택이 비어있으면 while문을 빠져나감
		}
		
	}
	//출력예시 4입력시 1 ,2, 3, 1, 4, 1, 2 출력됨.
	//n = 4 이면 우선 stack에 4, 3, 2 ,1  이 순차적으로 담김
	//두번째 if절로 넘어와서 1을 꺼내 출력, n= 1-2 = -1
	//첫번째 if절로 넘어와서 n >0 조건에 맞지 않으므로 두번째 조건으로 넘어옴
	///두번째 if절로 넘어와서 2를 꺼내 출력. n= 2-2 = 0
	//첫번째 if절로 넘어와서 n >0 조건에 맞지 않으므로 두번째 조건으로 넘어옴
	///두번째 if절로 넘어와서 3를 꺼내 출력. n= 3-2 = 1
	//첫번째 if절로 넘어와서 stack에 1을 푸시 (현재 스택 : 4 ,*1(추가))
	//두번째 if절로 넘어와서 1을 꺼내 출력 n = 1-2 = -1;
	//첫번째 if절로 넘어와서 n >0 조건에 맞지 않으므로 두번째 조건으로 넘어옴
	//두번째 if절로 넘어와서 4를 꺼내 출력. n= 4-2 = 2
	//다시 첫번째 if절로 넘어와서 stack에 2, 1을 담음
	//두번째 if절로 넘어와서 2를 꺼내 출력. n= 2-2 = 0
	//...반복

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int x = scanner.nextInt();

		recur(x);//재귀를 모두 제거했다! 
		scanner.close();
	}
}
