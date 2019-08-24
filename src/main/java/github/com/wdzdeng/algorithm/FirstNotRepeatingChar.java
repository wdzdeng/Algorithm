package github.com.wdzdeng.algorithm;
/**
 * LinkedHashMap记录插入顺序
 */

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public static int first(String str){
        char[] chars = str.toCharArray();
        LinkedHashMap<String, Integer> map = new LinkedHashMap();
        for (int i = 0; i < chars.length; ++i){
            if (map.get(chars[i]+"") == null) map.put(chars[i]+"", 1);
            else map.put(chars[i]+"",map.get(chars[i]+"")+1);
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                char c =  entry.getKey().charAt(0);
                for (int j = 0; j<chars.length; ++j){
                    System.out.println(c);
                    if (chars[j] == c) return j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(first("google"));
    }
}
