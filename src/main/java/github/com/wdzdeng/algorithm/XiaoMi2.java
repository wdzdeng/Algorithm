package github.com.wdzdeng.algorithm;

public class XiaoMi2 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5,6};

        System.out.println(sumMin(nums, 2));
    }
    private static int sumMin(int[] nums, int n){
        int[] accumulate = new int[nums.length];//空间换时间，用O(1)时间复杂度求和
        accumulate[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            accumulate[i] = nums[i] + accumulate[i-1];
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; ++i){

        }
        return  1;
    }
    private static int getSum(int[] accumulate, int left, int right){
        return left == 0 ? accumulate[right] : accumulate[right] - accumulate[left-1];
    }
}
