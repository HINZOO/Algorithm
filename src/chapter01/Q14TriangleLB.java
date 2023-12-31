package chapter01;

import java.util.Scanner;

public class Q14TriangleLB {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n;

    System.out.println(" 직각인 이등변 삼각형을 출력합니다.");

    do {
      System.out.print("몇 단 삼각형입니까?: ");
      n = stdIn.nextInt();
    } while (n <= 0);

    // triangleLB(n);
    triangleRB(n);
    stdIn.close();
  }

  public static void triangleLB(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();// 줄바꿈
    }
  }

  public static void triangleLU(int n) {
    for (int i = n; i >= 0; i--) {
      for (int j = i; j > 0; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // --- 왼쪽 위가 직각인 직각삼각형을 출력 ---//
  // static void triangleLU(int n) {
  // for (int i = 1; i <= n; i++) { // i 행( i = 1, 2, ... , n )
  // for (int j = 1; j <= n-i+1; j++) // n - i + 1 개의 '*'을 출력
  // System.out.print('*');
  // System.out.println(); // 줄바꿈
  // }
  // }

  static void triangleRU(int n) {
    for (int i = 1; i <= n; i++) { // i 행( i = 1, 2, ... , n )
      for (int j = 1; j <= i - 1; j++) // i - 1 개의 ' '을 출력
        System.out.print(' ');
      for (int j = 1; j <= n - i + 1; j++) // n - i + 1 개의 '*'을 출력
        System.out.print('*');
      System.out.println(); // 줄바꿈
    }
  }

  static void triangleRB(int n) {
    for (int i = 1; i <= n; i++) { // i 행( i = 1, 2, ... , n )
      for (int j = 1; j <= n - i; j++)
        System.out.print(' ');
      for (int j = 1; j <= i; j++)
        System.out.print('*');
      System.out.println(); // 줄바꿈
    }
  }
}
