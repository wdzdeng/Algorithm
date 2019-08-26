package github.com.wdzdeng.algorithm;

import java.util.Scanner;

public class Kuaishou2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 1 ; i<= m ; ++i){
            int num = sc.nextInt();
            int count = 0;
            while (count<10000){
                num = getNewValue(num);
                if (num == 1){
                    System.out.println(true);
                    break;
                }
                count++;
            }
            if (count == 10000) System.out.println(false);
        }

    }
    public static int getNewValue(int num){
        int newValue = 0;
        while (num > 0){
            int r = num%10;
            num /= 10;
            newValue += r*r;
        }
        return newValue;
    }
}
