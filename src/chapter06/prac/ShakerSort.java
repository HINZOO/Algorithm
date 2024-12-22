package chapter06.prac;

import java.util.Scanner;

public class ShakerSort {

    static void swap(int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    //양방향 버블 정렬 (bidirectional bubble sort) === 칵테일 정렬(cocktail sort) === 셰이커 정렬(shaker sort)
    //패스의 스캔방향을 교대로 변경 기존대로 뒤부터 스캔하여 보다가 스왑지점이 나오면
    //앞부터 스캔하여 스왑시켜나가는 형식의 반복..
    static void shakerSort(int[] a, int n){
        int left =  0;
        int right = n-1;
        int last = right;

        while (left < right){
            for (int j = right ; j> left ; j--){
                if(a[j-1] > a[j]){
                    swap(a, j-1, j);
                    last = j;
                }
            }
            left = last;

            for(int j = left ; j < right ; j++){
                if(a[j] > a[j+1]){
                    swap(a, j, j+1);
                    last = j;
                }
            }
            right = last;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("양방향 버블 정렬 (셰이커 정렬)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int [] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.println("x["+ i +"] : ");
            x[i] = stdIn.nextInt();
        }

        shakerSort(x,nx);
        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x["+ i +"] = "+x[i]);
        }
    }
}
