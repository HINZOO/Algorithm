package chapter06;

import java.util.Scanner;

public class ShellSort {

    static void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) { //h/=2 는 h= h/2 임 //증분값 설정
            for (int i = h; i < n; i++) {
                int j;
                int temp = a[i];
                for (j = i - h; j >= 0 && a[j] > temp; j = j - h) {
                    a[j + h] = a[j]; //두값을 비교했을때 앞의 번의 값이 작으면 swap
                }
                a[j + h] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("셸 정렬 ver.1");
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
    }
}
