package github.com.wdzdeng.algorithm;

import java.util.Scanner;

public class Kuaishou3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        if(line1.trim().isEmpty()) {
            System.out.println(line2);
            return;
        }
        if (line2.trim().isEmpty()){
            System.out.println(line1);
            return;
        }
        String[] t1 = line1.split(" ");
        String[] t2 = line2.split(" ");
        StringBuffer sb = new StringBuffer();
        int len1 = -1;
        int len2 = -1;
        while (len1<t1.length && len2<t2.length){
            for (int j = 0; j < 4; ++j){
                len1 += 1;
                if (len1 >= t1.length) break;
                sb.append(t1[len1]);
                sb.append(" ");
            }
            if (len1 >= t1.length) {
                for (int k = len2+1; k<t2.length ;++k){
                    sb.append(t2[k]);
                    sb.append(" ");
                }
                break;
            }
            len2 += 1;
            if (len2 == t2.length) continue;
            sb.append(t2[len2]);
            sb.append(" ");
        }
        String newStr = sb.toString();
        System.out.println(newStr.trim());
    }
}
