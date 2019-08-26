package github.com.wdzdeng.algorithm;

/**
 * 丑数-经典
 */
public class UglyNumber {
    public static int getUglyNumber(int index){
        int[] uglys = new int[index+1];
        uglys[1] = 1;
        int t2 = 1;
        int t3 = 1;
        int t5 = 1;
        for (int i = 2; i <= index; ++i){
                uglys[i] = Math.min(Math.min(uglys[t2]*2, uglys[t3*3]*3), uglys[t5*5]*5);
                if (uglys[i] == uglys[t2]*2) t2++;
                if (uglys[i] == uglys[t3]*3) t3++;
                if (uglys[i] == uglys[t5]*5) t5++;
        }
        return uglys[index];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(3));
    }
}