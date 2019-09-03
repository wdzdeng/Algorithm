package github.com.wdzdeng.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class TenXun3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] as = new int[n];
        for(int i = 0; i < n; ++i){
            as[i] = sc.nextInt();
        }
        int sum = Arrays.stream(as).sum();
        if (m >= sum){
            System.out.println(n+1);

        }else {
            System.out.println(((sum/m)+1)+n);
        }


    }
}
