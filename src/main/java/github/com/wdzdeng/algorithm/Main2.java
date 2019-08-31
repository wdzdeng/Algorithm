package github.com.wdzdeng.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; ++i) {
            numbers[i] = sc.nextInt();
        }
        int[] lens = new int[n];
        if (n <= 1) {
            System.out.println(n);
            return;
        }
        int lg = 0;
        for(int i = 0; i< numbers.length; ++i){
            int temp = Arrays.binarySearch(lens, 0 ,lg, numbers[i]);
            if (temp < 0){//不存在
                temp = -1*(temp +1);
            }
            lens[temp] = numbers[i];
            if (temp == lg) ++lg;
        }
        System.out.println(lg);
    }
}
