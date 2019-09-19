package github.com.wdzdeng.algorithm;

import java.util.Scanner;

public class Main4 extends Object{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < chars.length; ++i){
            int count = 1;
            if (i + 1 < chars.length){
                if (chars[i+1] == chars[i]){
                    int j = i + 1;
                    for (; j < chars.length; ++j){
                        if (chars[j] == chars[i]) count++;
                        else break;
                    }
                    sb.append(count);
                    sb.append(chars[i]);
                    i = j-1;
                }
                else sb.append(chars[i]);
            }
            else {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());

    }
}
