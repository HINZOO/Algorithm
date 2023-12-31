package chapter01;

import java.util.Scanner;

public class Q16NumPira {
  static void spira(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print(' ');
      }
      for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
        System.out.print(i % 10);// 10이 넘어가면 자리수가 이상해지므로 ...
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n;

    System.out.println("피라미드를 출력합니다.");
    do {
      System.out.print("단수는 : ");
      n = scanner.nextInt();

    } while (n <= 0);
    spira(n);

    scanner.close();
  }
}
