package chapter01;

import java.util.Scanner;

public class SumVervose1 {
  public static void main(String[] args) {

    Scanner stdIn = new Scanner(System.in);

    int n;

    System.out.println("1부터 n까지의 합을 구합니다.");

    do {
      System.out.print("n 값 : ");
      n = stdIn.nextInt();
    } while (n <= 0);

    int sum = 0;

    for (int i = 1; i <= n; i++) {
      if (i < n)
        System.out.print(i + " + ");
      else
        System.out.print(i + " = ");
      sum += i;
    }

    System.out.println(sum);
    stdIn.close();
  }
}

// 예를 들어 n이 10000이라면 9999번을 실행하고 단 한번의 else만 적용된다.
// 이 과정을 실행하기 위해 10000번을 판단해야하는 코드이므로 위의 코드는 바람직 하지 않다.
