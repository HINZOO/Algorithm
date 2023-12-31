package chapter01;

import java.util.Scanner;

public class SumVervose2 {
  public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);

    int n;

    System.out.println("1부터 n까지의 합을 구합니다.");

    do {
      System.out.print("n 값 : ");
      n = stdIn.nextInt();
    } while (n <= 0);

    int sum = 0;

    for (int i = 1; i < n; i++) {// n-1 까지는 + 를 붙임.
      System.out.print(i + " + ");
      sum += i; // n-1 까지 더함.
    }

    // 🔥
    // System.out.print(n + " = "); // 마지막 원소에는 = 을 붙임
    // sum += n; // 마지막 원소 더함
    // System.out.println(sum);

    System.out.println(n + " = " + (sum + n)); // 🔥 한줄로도 정리가능
    stdIn.close();
  }
}
