package Leetcode;

public class NumberOfSteps {
    public static void main(String[] args) {
        Solution1 P = new Solution1();
        System.out.println(P.numberOfSteps(10));
    }
}
class Solution1 {
    public int numberOfSteps (int num) {
        int res = 0;
        while(num!=0){
            res++;
            if (num % 2==0){
                num = num/2;
            }else{
                num -= 1;
            }
        }
        return res;

    }
}

