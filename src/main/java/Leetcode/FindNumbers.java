package Leetcode;

public class FindNumbers {
    public static void main(String[] args) {
        Solution3 P = new Solution3();
        int[] nums = {555,901,482,1771};
        System.out.println(P.findNumbers(nums));
    }


}
class Solution3 {
    public int findNumbers(int[] nums) {
        int sum = 0;
        for(int num:nums){
            String s = String.valueOf(num);
            if (s.length() % 2==0){
                sum+=1;
            }
        }
        return sum;
    }
}
