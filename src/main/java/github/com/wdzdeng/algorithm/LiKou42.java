package github.com.wdzdeng.algorithm;

public class LiKou42 {
    //暴力
    public static int trap1(int[] height) {
        int leftMax = 0;
        int water = 0;
        for (int i = 0; i < height.length; ++i){
            if (height [i] >= leftMax){
                leftMax = height[i];
                continue;
            }
            int rightMax = 0;
            for (int j = i+1 ;j<height.length; ++j){
                rightMax = Math.max(rightMax, height[j]);
            }
            int h = Math.min(leftMax,rightMax);
            if (h <= height[i]) continue;
            water += (h - height[i]) ;
        }
        System.out.println(water);
        return water;

    }
    //提前记录下左右的最大值
    public static int trap2(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int lMax = 0;
        for (int i = 0; i < height.length; ++i){
            leftMax[i] = lMax;
            lMax = Math.max(lMax, height[i]);
        }
        int rMax = 0;
        for (int j = height.length-1; j >= 0; --j){
            rightMax[j] = rMax;
            rMax = Math.max(rMax, height[j]);
        }
        int water = 0;
        for (int k = 0; k < height.length; ++k){
            if (Math.min(leftMax[k],rightMax[k])<= height[k]) continue;
            water += (Math.min(leftMax[k],rightMax[k])-height[k]);
        }
        System.out.println(water);
        return water;
    }
    public static void main(String[] args) {
        int[] temp = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap2(temp);
    }
}
