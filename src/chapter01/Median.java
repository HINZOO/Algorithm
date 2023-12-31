package chapter01;

import java.util.Scanner;

public class Median {
  // 3개의 정수값을 입력하고 중앙값을 구하여 출력
  static int med3(int a, int b, int c) {
    if (a >= b) {// 참이 아닌경우는 a < b 이다 를 생각하여 알고리즘을 해석해 나가면 됨.
      if (b >= c)
        return b;
      else if (a <= c)
        return a;
      else
        return c;
    } else if (a > c) {
      return a;
    } else if (b > c) {
      return c;
    } else {
      return b;
    }
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("세 정수의 중앙값을 구합니다.");
    System.out.print("a의 값: ");
    int a = stdIn.nextInt();
    System.out.print("b의 값: ");
    int b = stdIn.nextInt();
    System.out.print("c의 값: ");
    int c = stdIn.nextInt();

    System.out.println("중앙값은 " + med3(a, b, c) + "입니다.");
    stdIn.close();
  }
}
