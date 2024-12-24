package chapter06;

import java.util.Scanner;

public class ShellSort2 {
    //증분값을 서로 배수가 되지 않도록 만들어야 효율적으로 정렬가능
    //ex h=...-> 121 -> 40 -> 13 -> 4 -> 1
    //수열을 사용하면 셸 정렬 알고리즘을 간단하게 만들 수 있을 뿐만 아니라 효율적인 결과를 얻을 수 있다.
    static void shellSort(int[] a, int n) {
        int h;
        for (h = 1; h < n; h = h * 3 + 1) { //h의 초깃값을 구함  1부터 3n+1규칙으로 증가, n을 넘지는 않는 가장 큰 h 값을 만든다.

        }
        //그 h를 가장 큰 증분으로 지정하고 나눠감
        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int temp = a[i];
                for (j = i - h; j >= 0 && a[j] > temp; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("셸 정렬 ver.2");
        System.out.print("요솟수: ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        shellSort(x, nx);
        System.out.println("오름차 순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]= " + x[i]);
        }
        sc.close();
    }
}
