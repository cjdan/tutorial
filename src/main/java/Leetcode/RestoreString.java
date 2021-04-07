package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class RestoreString {
    public static void main(String[] args) {
        Solution24 p = new Solution24();
        String s = "abc";
        int[] indices={2,3,1};
        System.out.println(p.restoreString(s,indices));


    }
}
class Solution24 {
    public String restoreString(String s, int[] indices) {
        ArrayList<String> arrayList = new ArrayList( Arrays.asList(s));
        for(int num:indices){

        }

        return "";
    }
}
