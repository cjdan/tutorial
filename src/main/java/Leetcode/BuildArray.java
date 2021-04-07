package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuildArray {
    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        Solution21 P = new Solution21();
        System.out.println(P.buildArray(target,n));
    }

}
class Solution21 {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int max_num = 0;
        for(int tar:target){
            max_num = tar;
        }


        for(int i=1;i<max_num+1;i++){
            result.add("Push");
            boolean flage =false;
            for(int tar:target){
//                boolean flage =false;
                if(i ==tar){
                    flage = true;
                    break;
                }
            }
            if (!flage){
                result.add("Pop");
            }
        }
        return result;



    }
}
