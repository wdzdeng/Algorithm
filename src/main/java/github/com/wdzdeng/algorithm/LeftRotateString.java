package github.com.wdzdeng.algorithm;

/**
 * 旋转一个字符串，思路和循环队列相同。
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        char[] chars = new char[str.length()];
        for (int i = 0; i<str.length(); ++i){
            chars[i] = str.charAt((i + n) % str.length());
        }
        return new String(chars);
    }
}
