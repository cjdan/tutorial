package Leetcode;

import java.util.Arrays;

public class LargestAltitude {
    public static void main(String[] args) {
        Solution2 P = new Solution2();
        int[] gain = {-5,1,5,0,-7};
        System.out.println(P.largestAltitude(gain));
    }


}
class Solution2 {
    public int largestAltitude(int[] gain) {
        int[] res = new int[gain.length+1];
        res[0]=0;
        int max = 0;
        for(int i=0;i< gain.length;i++){
            res[i+1] = res[i]+gain[i];
            if (max<res[i+1]){
                max = res[i+1];
            }
        }
        return max;

    }
}
