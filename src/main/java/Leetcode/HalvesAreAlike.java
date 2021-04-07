package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class HalvesAreAlike {
    public static void main(String[] args) {
        Solution22 P =new Solution22();
        String s = "MerryChristmas";
        System.out.println(P.halvesAreAlike(s));
    }



}
class Solution22 {
    public boolean halvesAreAlike(String s) {
        String ss = s.toLowerCase();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
//        String res = "aeiou";
        int left_num = 0,right_num = 0;

//        String ss = s.toLowerCase();
       for(int i=0;i<s.length();i++){
            if(i<s.length()/2 && set.contains(ss.charAt(i))){
                left_num++;
            }else if(i>=s.length()/2 && set.contains(ss.charAt(i))){
                right_num++;
            }
        }
        return left_num==right_num;


    }
}