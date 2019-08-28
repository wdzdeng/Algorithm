package github.com.wdzdeng.algorithm;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {

    public boolean isValid(String s) {
       HashMap<Character,Character> map = new HashMap<>();
       map.put(')','(');
       map.put(']','[');
       map.put('}','{');
       Stack<Character> vector = new Stack<>();
       for(int i = 0; i<s.length();++i){
           if (map.keySet().contains(s.charAt(i))){
               Character c = vector.isEmpty() ? null : vector.pop();
               if (map.get(s.charAt(i)) != c){
                   return false;
               }
           }else {
               vector.push(s.charAt(i));
           }
       }
       return vector.isEmpty();

    }

    public static void main(String[] args) {
        IsValid is =  new IsValid();
        System.out.println(is.isValid("([)]"));
    }
}
