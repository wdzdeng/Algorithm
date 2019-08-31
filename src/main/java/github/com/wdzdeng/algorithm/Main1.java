package github.com.wdzdeng.algorithm;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i<n;++i){
            numbers[i] = sc.nextInt();
        }
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] lens = new int[n+1];
        lens[0] = 1;
        int max = 1;
        for (int i = 1; i<n;++i){
            lens[i] = 1;
            for(int j = 0; j<i; ++j){
                if (numbers[j]<=numbers[i]){
                    lens[i] = Math.max(lens[i],lens[j]+1);
                }
            }
            max = Math.max(max,lens[i]);        }
        System.out.println(max);
//        for (int j = 0; j<n;++j){
//            lens[j] = 1;
//            for(int k = 0; k<j; ++k){
//                if (numbers[k]<numbers[j]) {
//                    lens[j] = Math.max(lens[k]+1,lens[j]);
//                }
//            }
//        }
//        int max = 0;
//        for (int temp: lens){
//            max = Math.max(max, temp);
//        }
//        System.out.println(max);
//        //System.out.println(Arrays.stream(lens).max().getAsInt());
    }
}
