package github.com.wdzdeng.algorithm;

/**
 * 01234567891011121314.....第n位的数字是什么
 * 边界问题让人崩溃
 */
public class DigitAtIndex {
    public static int digitAtIndex(int n){
        if (n<10) return n;
        int a = 0;
        while (n>0){
            a += 1;
            n -= (int)Math.pow(10,a-1)*a*9;
        }
        n += (int)Math.pow(10,a-1)*a*9;
        int b = n%a;
        int c = n/a;
        if (b == 0){

            return ((int)Math.pow(10,a-1)+c-1)%10;
        }else {
            return Integer.parseInt(Integer.toString((int)Math.pow(10,a-1)+c).charAt(b-1)+"");
        }

    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(19));
    }
}
