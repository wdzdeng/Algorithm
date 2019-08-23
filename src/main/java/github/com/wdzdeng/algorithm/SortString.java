package github.com.wdzdeng.algorithm;

import java.util.ArrayList;

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

    }

}
