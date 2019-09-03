package github.com.wdzdeng.algorithm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class TenXun2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a= new long[n];
        long[] b = new long[n];
        long[] cnt = new long[n];
        BigDecimal aSum = new BigDecimal(0);
        BigDecimal bSum = new BigDecimal(0);
        for (int i = 0; i<n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            cnt[i] = a[i] -b[i];
            aSum = aSum.add(BigDecimal.valueOf(a[i]));
            bSum = bSum.add(BigDecimal.valueOf(b[i]));
        }
        bSum = bSum.multiply(BigDecimal.valueOf(n));
        BigDecimal cntSum = new BigDecimal(0);
        Arrays.sort(cnt);
        for (int i = 0; i<n; ++i){
            BigDecimal temp = new BigDecimal(cnt[i]);
            cntSum  =  cntSum.add(temp.multiply(BigDecimal.valueOf(n-i)));
        }
        System.out.println(bSum.add(cntSum).subtract(aSum));
    }
}
