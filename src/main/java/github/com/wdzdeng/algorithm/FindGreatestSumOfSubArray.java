package github.com.wdzdeng.algorithm;

/**
 * 找到数组里连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {
    public int findGreatestSum(int[] array){
        int maxsum = Integer.MIN_VALUE;
        int currentsum = array[0];
        for (int i = 1; i < array.length; ++i){
            if (array[i]<0){
                maxsum = Math.max(maxsum, currentsum );
            }
            if (currentsum < 0) currentsum = array[i];
            else  currentsum += array[i];
        }
        maxsum = Math.max(maxsum, currentsum );
        return maxsum;

    }
}
