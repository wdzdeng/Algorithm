package github.com.wdzdeng.algorithm;

import java.util.Scanner;

/**
 * 多重背包问题
 * 有一个体积为V的背包，有m种物品，每种物品有体积和价值，且数量一定。求背包能装下的最大价值。
 * 第一行两个整数V和m。
 * 接下来m行，每行3个整数，表示第i种物品的数量、体积和价值。
 */
public class BackPack_Multiple {
    /**
     * 使用一纬数组，同样不容易理解
     * @return
     */
    public static int backpack1(){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int m = sc.nextInt();
        int[] volumes = new int[m + 1];
        int[] values = new int[m+1];
        int[] numbers = new int[m+1];
        for (int i = 1; i<m+1; ++i){
            numbers[i] = sc.nextInt();
            volumes[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        int[] dp = new int[v+1];
        for (int i = 1; i<m+1; ++i){
            for (int j = v; j>0; --j){
                for (int k = 1; k<= numbers[i];++k){
                    if (j >= volumes[i]*k){
                        dp[j] = Math.max(dp[j], values[i]*k+dp[j-k*volumes[i]]);
                    }
                }
            }
        }
        System.out.println(dp[v]);
        return dp[v];
    }

    /**
     * 使用二维数组——更符合人类思维
     * @param
     */
    public static int backpack2(){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int m = sc.nextInt();
        int[] volumes = new int[m + 1];//体积
        int[] values = new int[m+1];//价值
        int[] numbers = new int[m+1];//数量
        for (int i = 1; i<m+1; ++i){
            numbers[i] = sc.nextInt();
            volumes[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        int[][] dp = new int[m+1][v+1];
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= v; ++j){
                for (int k = 1; k <= numbers[i]; ++k){
                    if(j >= k*volumes[i]){
                        dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i][j]), dp[i-1][j-k*volumes[i]]+k*values[i]);//这一步需要注意！！！！
                    }else {
                        if(k == 1) dp[i][j] = dp[i-1][j];
                        break;
                    }
                }
            }
        }
        System.out.println(dp[m][v]);
        return dp[m][v];
    }

    public static void main(String[] args) {
        backpack2();
    }
}
