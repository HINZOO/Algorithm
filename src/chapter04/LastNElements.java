package chapter04;

import java.util.Scanner;
// 원하는 개수만큼 값을 입력받고 요소수가 N인 배열에 마지막 N개를 저장
// 예를들어 1, 2, 3, 4, 5,.., 9. 10, 11, 12 를 순서대로 전달받았다면, 3,4,5,...,12 까지를 저장함.(최신순 N 개)
public class LastNElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int N = 10;
		int[] a = new int[N];		//입력받은값을 저장
		int cnt = 0;				//입력받은개수
		int retry;					//반복
		
		System.out.println("정수를 입력하세요.");
		
		 do {
			 System.out.printf("%d 번째 정수: ", cnt + 1);
			 a[cnt++ % N] = scanner.nextInt(); 
			 //cnt % N 값은 0부터 N까지의 값만 출력되므로, 해당 범위의 인덱스안에서만 주어진값이 입력된다.
			 System.out.print("계속 할까요? (1.예 / 2.아니요) : ");
			 retry = scanner.nextInt();			 
		 }while(retry == 1);
		
		 int i = cnt - N; // 입력횟수(cnt)가 N보다 많이 입력되었다면, 
		 				  //ex) cnt =11(12번입력) N =10  이면  i=2 부터 11까지 출력되며
		 				 // a[2],a[3],...a[0],a[1] 까지 출력된다. 
		 if (i < 0) i = 0; //만약 cnt가 N보다 작게 입력되었다면 0부터 cnt 까지 출력 
		 for (; i < cnt ; i++) {
			 System.out.printf("%2d 번째 정수 = %d\n", i+1 , a[i%N]);
		 }
		
		
		scanner.close();
	}
}
