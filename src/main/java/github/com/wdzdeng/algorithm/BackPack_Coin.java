package github.com.wdzdeng.algorithm;

import java.util.Arrays;

/**
 * 我把这类题也归为背包
 * 背包里各个元素可以无限用
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 */
public class BackPack_Coin {
    /**
     * 使用一维数组
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange1(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 99999);
        dp[0] = 0;
        for (int i = 1; i<= amount; ++i){
            for (int j = 0; j<coins.length; ++j){
                if (i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        if (dp[amount] == 99999) return -1;
        return dp[amount];
    }

    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     * @param coins
     * @param amount
     * @return
     */
    public static int change(int[] coins, int amount){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin: coins){
            for (int i = 1; i<= amount ;++i){
                if (i >= coin){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
    public  static void main(String[] args){
        int[] coins = new int[]{1,2,5};
        int amount = 5;
        System.out.println(change(coins,amount));
    }
}
