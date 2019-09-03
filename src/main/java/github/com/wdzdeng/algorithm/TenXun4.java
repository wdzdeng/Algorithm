package github.com.wdzdeng.algorithm;

import java.math.BigDecimal;
import java.util.Scanner;

public class TenXun4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        BigDecimal[] sum = new BigDecimal[n+1];
        for (int i = 0; i<n; ++i){
            height[i] = sc.nextInt();
            if (i == 0){
                sum[i] = BigDecimal.valueOf(height[i]);
            }else {
                sum[i] = sum[i -1].add(BigDecimal.valueOf(height[i]));
            }
        }
        sum[n] = sum[n - 1].add(BigDecimal.valueOf(height[n-1]));
        System.out.println(getAnswer(height,sum,n));
    }
    private static BigDecimal getAnswer(int[] height, BigDecimal[] sum, int n){
        BigDecimal ans = new BigDecimal(0);
        int left[] = new int[n +1];
        int right[] = new int[n +1];
        processLR(height, left, right);
        for (int i = 1;i<=n; ++i){
            BigDecimal tempSum = sum[right[i] -1].subtract((left[i]-2>=0) ? sum[left[i]-2]:new BigDecimal(0));
            BigDecimal tmp = tempSum.multiply(BigDecimal.valueOf(height[i-1]));
            if (ans.compareTo(tmp)<0) ans = tmp;
        }
        return ans;

    }
    private  static void processLR(int[] heights, int[] left, int[] right){
        int n = heights.length;
        int[] tempArr = new int[n +2];
        tempArr[0] = -1;
        for(int i = 1; i<= n; i++){
            tempArr[i] = heights[i-1];
        }
        tempArr[tempArr.length -1] = -1;
        for (int i = 1;i<=n;i++){
            int k = i;
            while (tempArr[i] <= tempArr[k-1]) k = left[k-1];
            left[i] = k;
        }
        for (int i = n; i>0; i--){
            int k = i;
            while (tempArr[i] <= tempArr[k+1]) k = right[k+1];
            right[i] = k;
        }
    }
}
