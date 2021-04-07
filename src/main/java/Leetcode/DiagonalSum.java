package Leetcode;

import java.util.Arrays;

public class DiagonalSum {
    public static void main(String[] args) {
        Solution5 P = new Solution5();
        int[][] mat = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(P.diagonalSum(mat));
    }
}
class Solution5 {
    public int diagonalSum(int[][] mat) {
        int left=0;
        int right=mat.length-1;
        int sum = 0;

        for (int[] ints : mat) {
            if (left!=right) {
                sum += ints[left] + ints[right];
            }
            else {
                sum += ints[left];
            }
            left++;
            right--;
        }
        return sum;
    }
}