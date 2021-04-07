package Leetcode;

import java.util.Arrays;

public class PrintNumbers {
    public static void main(String[] args) {
        int n = 1;
        Solution9 P = new Solution9();
        System.out.println(Arrays.toString(P.printNumbers(n)));
    }
}
class Solution9 {
    public int[] printNumbers(int n) {
        int[] result =new int[(int) (Math.pow(10,n)-1)];
        for(int i=1;i<(Math.pow(10,n));i++){
            result[i-1] = i;
        }
        return result;

    }
}
