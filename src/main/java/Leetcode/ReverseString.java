package Leetcode;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString1 p = new ReverseString1();
        char[] s = {'a','b','c'};
        System.out.println(p.reverseString(s));

    }
}
class ReverseString1 {
    public char[] reverseString(char[] s) {
        char temp;
        for(int i=0;i<s.length/2;i++){
            temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
        return s;
    }
}
