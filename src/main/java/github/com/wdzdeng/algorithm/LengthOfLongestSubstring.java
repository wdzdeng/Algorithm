package github.com.wdzdeng.algorithm;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null ) return 0;
        HashMap<Object,Integer> map = new HashMap<>();
        int longest = 0;
        int current = 0;
        int start = 0;
       for (int i = 0; i < s.length(); ++i){
           char c = s.charAt(i);
           if (null == map.get(c)){
               map.put(c, i);
               ++current;
           }else {
               if (map.get(c)<start){
                   current++;
                   map.put(c,i);
               }else {
                   longest = Math.max(longest,current);
                   current = i - map.get(c);
                   start = map.get(c)+1;
                   map.put(c,i);
               }
           }
       }
       return Math.max(longest,current);

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
