package github.com.wdzdeng.algorithm;

import java.util.Scanner;

public class TenXun5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < t; ++i){
            int left = sc.nextInt();
            int right = sc.nextInt();
            getAnswer(left, right);
        }
    }
    private static void getAnswer(int left, int right){
        System.out.println(left*right);
    }
}
