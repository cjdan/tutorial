package Leetcode;

import java.util.LinkedList;

public class GetDecimalValue {


    public static void main(String[] args) {
        Solution4 P = new Solution4();
        LinkedList<Integer> head = new LinkedList<Integer>();
        head.add(1);
        head.add(0);
        head.add(1);
        System.out.println(P.getDecimalValue(head));

    }
}
class Solution4 {
    public int getDecimalValue(LinkedList<Integer> head) {
        int result = 0;
        int length = head.size();
        for (int num:head){
            result += num*Math.pow(2, length-1);
            length--;
        }
        return result;

    }
}
