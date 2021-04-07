package Leetcode;

import scala.math.Ordering;

public class Calculate {
    public static void main(String[] args) {
        Solution8 P = new Solution8();
        String s = "AB";
        System.out.println(P.calculate(s));
    }
}
class Solution8 {
    public int calculate(String s) {
        int x = 1,y = 0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i)=='A'){
                x = 2 * x + y;
            }else {
                y = 2 * y + x;
            }
        }
        return x+y;

    }
}
