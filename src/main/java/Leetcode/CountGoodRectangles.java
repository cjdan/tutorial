package Leetcode;

import scala.Array;

import java.util.*;
import java.util.stream.Collectors;

public class CountGoodRectangles {
    public static void main(String[] args) {
        int[][] rectangles = {{5,8},{3,9},{5,12},{16,5}};
        Solution23 P= new Solution23();
        System.out.println(P.countGoodRectangles(rectangles));
    }
}
class Solution23 {
    public int countGoodRectangles(int[][] rectangles) {
//
        ArrayList<Integer> list= new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int i =0;
        for(int [] rectangle:rectangles){
            list.add(Math.min(rectangle[0],rectangle[1]));
            set.add(Math.min(rectangle[0],rectangle[1]));
            i++;
        }
        ArrayList<Integer> list1= new ArrayList<>();
        list1.add(0);
        int j=0;

        for(int num:set){
            int count = 0;
            for(int num1:list){
                if(num==num1){
                    count++;
                }
            }
            if (count>list1.get(j)){
                list1.add(count);
                j++;
            }
        }
        return list1.get(j);
    }
}
