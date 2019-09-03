package github.com.wdzdeng.algorithm;

import java.util.Scanner;

public class Test {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(";");
        if (strs[0].length() != strs[1].length()) {
            System.out.println(false);
            return;
        }
        String s = strs[0] +strs[0];
        int[][] ints = new int[s.length()+1][s.length()+1];
        int max = 0;
        for (int i = 0; i < s.length(); ++i){
            for (int j = 0; j<strs[1].length(); ++j){
                if (s.charAt(i) == strs[1].charAt(j)){
                    ints[i+1][j+1] = ints[i][j] +1;
                    max = Math.max(max, ints[i+1][j+1]);
                }
            }
        }
        System.out.println(max);
        System.out.println(max >= strs[1].length());
        System.out.println(2222);

    }
}
