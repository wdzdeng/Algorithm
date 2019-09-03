package github.com.wdzdeng.algorithm;

import java.util.Scanner;

public class TenXun1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int as ;
        int bs ;
        int boxJishu = 0;
        for (int i = 0; i<n ;++i){
            as = sc.nextInt();
            if (as % 2 == 1) boxJishu ++;
        }
        int keyJishu = 0;
        for (int j = 0; j<m; ++j){
            bs = sc.nextInt();
            if (bs % 2 == 1) keyJishu ++;
        }
        int boxOushu = n - boxJishu;
        int keyOushu = m - keyJishu;
        int num = Math.min(boxJishu, keyOushu) + Math.min(boxOushu, keyJishu);
        System.out.println(num);
    }
}
