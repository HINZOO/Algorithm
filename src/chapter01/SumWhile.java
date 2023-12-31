package chapter01;

import java.util.Scanner;

public class SumWhile {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("1부터 n까지의 합을 구합니다.");
    System.out.print("n값 : ");
    int n = stdIn.nextInt();

    int sum = 0;// 합
    int i = 1;

    while (i <= n) {// i 가 n 이하면 반복함
      sum += i; // sum에 i를 더함
      i++; // i를 1만큼 증가시킴.
    }

    System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    System.out.println("i의 최종값: " + i);// n+1
    stdIn.close();
  }
}

// 🍊 While문 반복
// 어떤 조건이 성립하는 동안 처리를 반복하여 실행하는 것을 반복구조라 하며 루프라고 부른다.
// While문은 실행전 반복을 계속할지 판단하는데 이런 구조를 사전판단반복이라고 한다.
// while(제어식) {명령문}
// 위의 예제에서 최종 i 값은 n이 아니라 n+1이라는 점을 기억해라.
