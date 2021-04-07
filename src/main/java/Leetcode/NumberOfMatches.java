package Leetcode;

public class NumberOfMatches {
    public static void main(String[] args) {
        Solution6 P = new Solution6();
        int n = 7;
        System.out.println(P.numberOfMatches(n));
    }
}
class Solution6 {
    public int numberOfMatches(int n) {
        int count =0;
        while(n!=1){
            if(n%2==0){
                n /= 2;
                count += n;
            }
            else {
                n=(n+1)/2;
                count += n-1;
            }
        }
        return count;
    }
}

