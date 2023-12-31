package chapter01;

import java.util.Scanner;

// 정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메서드를 작성하세요
// static int sumof(int a, int b);
public class Q08SumOf {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("정수 하나를 입력하세요: ");
    int a = scanner.nextInt();
    System.out.print("또 다른 정수를 입력하세요: ");
    int b = scanner.nextInt();

    int sum = sumof(a, b);
    System.out.println("두 수를 포함하여 사이의 모든 정수 합은 " + sum + "입니다.");
    scanner.close();

  }

  public static int sumof(int a, int b) {
    int sum = 0;
    if (a > b) {// 만약 a 가 크면 a 와 b의 값을 체인지 시켜 무조건 b가 더 크게 설정한다.
      int temp = a;
      a = b;
      b = temp;
    }
    for (int i = a; i <= b; i++) {// 합계계산
      sum += i;
    }
    return sum;// 반환
  }

}

// // 연습1-8 [정답]1~~

// // 정수a, b를 포함하여 그 사이의 모든 정수의 총합을 구합니다

// import java.util.Scanner;

// class SumOf {

// static int sumof(int a, int b) {
// int min; // a, b의 작은 쪽의 값
// int max; // a, b의 큰 쪽의 값

// if (a < b) {
// min = a;
// max = b;
// } else {
// min = b;
// max = a;
// }

// int sum = 0; // 총합
// for (int i = min; i <= max; i++)
// sum += i;
// return sum;
// }

// public static void main(String[] args) {
// Scanner stdIn = new Scanner(System.in);

// System.out.println("a와 b를 포함하여 그 사이에 있는 모든 정수의 총합을 구합니다.");
// System.out.print("a의 값 : ");
// int a = stdIn.nextInt();
// System.out.print("b의 값 : ");
// int b = stdIn.nextInt();

// System.out.println("정수 a, b 사이의 모든 정수의 총합은 " + sumof(a, b) + "입니다.");
// }
// }
