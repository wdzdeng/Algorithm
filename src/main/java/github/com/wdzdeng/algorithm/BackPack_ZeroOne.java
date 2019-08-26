package github.com.wdzdeng.algorithm;

import java.util.Scanner;

/**
 * 01背包问题
 *
 * 现有一个容量大小为V的背包和N件物品，
 * 每件物品有两个属性，体积和价值，请问这个背包最多能装价值为多少的物品？
 *
 * 输入描述:
 * 第一行两个整数V和n。
 * 接下来n行，每行两个整数体积和价值。1≤N≤1000,1≤V≤20000。
 * 每件物品的体积和价值范围在[1,500]。
 */
public class BackPack_ZeroOne {
    /**
     * 使用一维数组，一纬数组考虑需要更加抽象
     * @return
     */
    public static int backPack1(){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int[] volumes = new int[n+1];//体积
        int[] values = new int[n+1];//价值
        int[] dp = new int[v+1];
        for (int i = 1; i<= n; ++i){
            volumes[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        for (int j = 1; j <= n; ++j){//元素的遍历一定要放在外层，
            for (int i = v; i>= 1; --i){//背包的空间的遍历一定要放在内层，因为需要动态的更新，并且需要从V到1的遍历，这样才符合01背包，不然可能有些元素会算重掉
                if (i >= volumes[j]){
                    dp[i] = Math.max(dp[i], values[j]+dp[i-volumes[j]]);
                }
            }
        }
        return dp[v];
    }

    /**
     * 使用二维数组，二维数组对思维要求较低，容易理解
     * @return
     */
    public static int backPack2(){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int[] volumes = new int[n+1];//体积
        int[] values = new int[n+1];//价值
        int[][] dp = new int[n+1][v+1];
        for (int i = 1; i<= n; ++i){
            volumes[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        for(int i = 1; i <= n; ++i){
            for (int j = 1; j <= v; ++j){
                if (j >= volumes[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-volumes[i]]+values[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][v];
    }


    public static void main(String[] args) {
        System.out.println(backPack2());
    }
}
