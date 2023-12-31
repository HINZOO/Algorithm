package chapter01;

import java.util.Scanner;

public class JudgeABC1 {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("1.A , 2.B , 3.C  ");
    System.out.print("정수를 입력하세요: ");
    int n = stdIn.nextInt();

    if (n == 1)
      System.out.println("A");
    else if (n == 2)
      System.out.println(" B");

    // else
    // System.out.println("C");

    else if (n == 3)
      System.out.println("C");

    // else; 가 숨어있기 때문에 마무리를 else if 로 끝내면 아무 작업도 하지 않는 4분기 코드가 된다.
    stdIn.close();
  }

}

/*
 * 🍊 연산자와 피연산자
 * 연산자 : +, - 등의 연산기호
 * 피연산자 : 연산의 대상이 되는 것.
 * 연산자는 피연산자의 수에 따라 세종류가 존재.
 * 1. 단항 연산자 : 피연산자 1개 ex) a++
 * 2. 2항 연산자 : 피연산자 2개 ex) a > b
 * 3. 3항 연산자 : 피연산자 3개 ex) a? b : c
 * 
 * 3항 연산자는 조건연산자 이며
 * a ? b : c ; 일때
 * a가 true 이면 b, false 이면 c를 반환한다.
 * 
 * 
 */
