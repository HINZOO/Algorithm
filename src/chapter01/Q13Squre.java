package chapter01;

import java.util.Scanner;

public class Q13Squre {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("정사각형을 출력합니다.");
    int n;
    do {
      System.out.print("변의 길이 : ");
      n = scanner.nextInt();
    } while (n <= 0); // 양수인 경우만 체크

    for (int i = 0; i < n; i++) {
      System.out.println("*".repeat(n));
    }

    scanner.close();
  }
}
// 🍊 답
// do {
// System.out.print("변의 길이 : ");
// n = stdIn.nextInt();
// } while (n <= 0);

// for (int i = 1; i <= n; i++) {
// for (int j = 1; j <= n; j++)
// System.out.print('*');
// System.out.println();
// }