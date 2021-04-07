package Leetcode;

public class SumOddLengthSubarrays {
    public static void main(String[] args) {
        Solution7 P = new Solution7();
        int[] arr = {1,4,2,5,3};
        System.out.println(P.sumOddLengthSubarrays(arr));
        /*
        给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

子数组 定义为原数组中的一个连续子序列。

请你返回 arr 中 所有奇数长度子数组的和 。

         */
    }
}
class Solution7 {
    public int sumOddLengthSubarrays(int[] arr) {

        int len = arr.length, res = 0;
        for(int i = 0; i < len; i ++){
            int LeftOdd = (i+1)/2, LeftEven = i/2+1;
            int RightOdd = (len-i)/2, RightEven = (len-1-i)/2+1;
            res += arr[i]*(LeftOdd*RightOdd + LeftEven*RightEven);
        }
        return res;
    }
}

