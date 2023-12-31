package chapter01;

import java.util.Scanner;

public class SumFor2 {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n;
    System.out.println("1부터 n까지의 합을 구합니다.");

    do {
      System.out.print("n값 : ");
      n = stdIn.nextInt();
    } while (n <= 0);

    int sum = 0;

    for (int i = 1; i <= n; i++)
      sum += i;

    System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");

    stdIn.close();

  }
}
// do {} while(조건식);
// {} 안의 루프를 한번 실행하고 조건이 true 이면 loop를 돌고 아니면 넘어간다.
// 위의 예제에서 음수 n 의 값을 입력하는 것을 막기 위해 do while문을 사용한것.
// 🍊 사전 판단 반복 ( while, for 문 ) : 루프 본문을 한 번도 실행하지 않을 수 있습니다.
// 사후 판단 반복 (do while) : 루프 본문을 한 번은 반드시 실행합니다.
