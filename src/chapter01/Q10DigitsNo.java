package chapter01;

import java.util.Scanner;

// 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성하세요
// 예를들어 135를 입력하면 그 수는 3자리입니다. 를 출력하고 1314를 입력하면 그 수는 4자리입니다 라고 출력합니다.
public class Q10DigitsNo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n;
    do {
      System.out.print("양의 정수를 입력하세요 : ");
      n = scanner.nextInt();
    } while (n < 0);

    String strNumber = String.valueOf(n);

    // 🍊 자리수 계산을 10으로 나눈값으로 계산 할 수 있다.
    // int no = 0; // 자릿수
    // while (n > 0) {
    // n /= 10; // n을 10으로 나눕니다
    // no++;
    // }

    System.out.println("그 수는 " + strNumber.length() + "자리 입니다.");

    scanner.close();
  }

}
