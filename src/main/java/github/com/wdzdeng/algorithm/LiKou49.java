package github.com.wdzdeng.algorithm;

import java.util.*;

public class LiKou49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
       for (int i = 0; i<strs.length; ++i){
           String s = strs[i];
           char[] characters = s.toCharArray();
           Arrays.sort(characters);
           String newStr = new String(characters);
           if (map.get(newStr) == null){
               List<String> list = new ArrayList<>();
               list.add(s);
               map.put(newStr, list);
           }else {
               map.get(newStr).add(s);
           }
       }
       for (Map.Entry<String, List<String>> entry: map.entrySet()){
           lists.add(entry.getValue());
       }
       return lists;

    }


    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(strs);
    }
}
