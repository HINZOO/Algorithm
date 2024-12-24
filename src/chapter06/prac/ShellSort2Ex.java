package chapter06.prac;

import java.util.Scanner;

public class ShellSort2Ex {

    static int shellSort(int[] a, int n) {
        int count = 0;
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
                    count++;
                }
                a[j + h] = temp;
                count++;
            }
        }
        return count;
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

        int count = shellSort(x, nx);
        System.out.println("오름차 순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]= " + x[i]);
        }
        System.out.println("요소의 이동 회수는 " + count + "회입니다.");
        sc.close();
    }
}
