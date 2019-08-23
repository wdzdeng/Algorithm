package github.com.wdzdeng.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 固定第一个字符，递归取得首位后面的各种字符串组合；
 *  再把第一个字符与后面每一个字符交换
 *  并同样递归获得首位后面的字符串组合；
 *  递归的出口，就是只剩一个字符的时候，递归的循环过程
 *  就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
 */
public class SortString {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strList = new ArrayList<>();
        if (str == null || str.length()<1) return strList;
        char[] chars = str.toCharArray();
        recursive(chars, 0, strList);
        strList.forEach(it -> System.out.println(it));
        Collections.sort(strList);
        return strList;
    }
    public static void recursive(char[] chars, int index, ArrayList<String> list){
        if (index == chars.length-1){
            list.add(String.valueOf(chars));
            return;
        }
        HashSet set = new HashSet();//去重
        for (int i = index; i < chars.length; ++i){
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(chars, index, i);
            recursive(chars, index+1, list);
            swap(chars,i, index);//交换后再换回来

        }
        set = null;
    }

    public static void swap(char[] chars, int index1, int index2){
        char temp = chars[index2];
        chars[index2] = chars[index1];
        chars[index1] = temp;
    }

    public static void main(String[] s){
        SortString sortString = new SortString();
        sortString.Permutation("abc");
    }

}
