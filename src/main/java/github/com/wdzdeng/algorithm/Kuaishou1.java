package github.com.wdzdeng.algorithm;

import java.util.Scanner;

public class Kuaishou1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 1; i <=  m; ++i){
            String a = sc.next();
            String b = sc.next();
            String[] version1 = a.split("\\.");
            String[] version2 = b.split("\\.");
            int[] v1 = new int[4];
            int[] v2 = new int[4];
            for (int j = 0; j<version1.length; ++j){
                v1[j] = Integer.parseInt(version1[j]);
            }
            for (int j = 0; j<version2.length; ++j){
                v2[j] = Integer.parseInt(version2[j]);
            }
            for (int k = 0; k< 4; ++k){
                if (v2[k] < v1[k]){
                    System.out.println(false);
                    break;
                }
                else if (v2[k] > v1[k]){
                    System.out.println(true);
                    break;
                }
                else {
                    if (k == 3 ) System.out.println(false);
                }

            }
        }
    }
}
