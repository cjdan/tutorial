package Leetcode;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        Solution20 P=new Solution20();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(P.runningSum(nums)));
    }
}

class Solution20 {
    public int[] runningSum(int[] nums) {
        for(int i=1;i< nums.length;i++){
            nums[i] = nums[i] +nums[i-1];
        }
        return nums;
    }
}
