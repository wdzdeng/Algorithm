package github.com.wdzdeng.algorithm;

public class LiKou53 {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; ++i){
            if (nums[i] <= 0){
                max = Math.max(max, temp);
                if (temp < 0) temp = nums[i];
                else temp += nums[i];
            }else {
                if (temp < 0) temp =nums[i];
                else temp += nums[i];
            }
        }
        max = Math.max(max, temp);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
