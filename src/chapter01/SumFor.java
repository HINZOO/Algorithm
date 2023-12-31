package chapter01;

import java.util.Scanner;

public class SumFor {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("1부터 n까지의 합을 구합니다.");
    System.out.print("n값 : ");
    int n = stdIn.nextInt();

    int sum = 0;

    for (int i = 1; i <= n; i++)
      sum += i;

    System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");

    stdIn.close();

  }

}
// 🍊 반복문은 While문 보다 for 문을 사용하는 것이 좋다.
// for ( 초기화 부분 ; 제어식 ; 업데이트 부분) { 명령문 }
// 순서도를 작성할때 육각루프로 표현한다.
