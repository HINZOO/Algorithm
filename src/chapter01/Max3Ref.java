package chapter01;

import java.util.Scanner;// 1) 전체 프로그램 앞머리에 작성.

public class Max3Ref {
  Scanner stdIn = new Scanner(System.in); // 2) main 메서드의 앞쪽 (키보드 값을 입력받는 3.보다 앞)에 작성한다.
  int num = stdIn.nextInt(); // 3) 키보드로 입력한 정수값을 읽는다
}
// 🍊 System.in 은 키보드와 연결된 표준 입력 스트림이다.
// 🍊 자료형에 따라 호출해야 하는 메서드는 다르며 , 다음과 같다.
/**
 * nextBoolean() : (Boolean) true 또는 false
 * nextByte() : (byte) -128 ~ +127
 * nextShort() : (short) -32768 ~ + 32767
 * nextInt() : (int) -2147483648 ~ +2147483647
 * nextLong() : (Long) -9223372036854775808 ~ +9223372036854775807
 * nextFloat() : (float) +- 3.40282347E+38 ~ +- 1.40239846E-45
 * nextDouble() : (double) +-1.79769313486234507E+378 ~
 * +-4.94065645841246544E-324
 * next() : (String) 문자열 (공백, 줄바꿈 문자로 구분)
 * nextLine() : (String) 문자열 1줄
 */