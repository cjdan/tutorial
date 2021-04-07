//package Leetcode;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class OddCells {
//    public static void main(String[] args) {
//        OddCells1 P = new OddCells1();
//        int m = 2;
//        int n = 2;
//        int[][] indices = {{1,1},{0,0}};
//        System.out.println(P.oddCells(m,n,indices));
//
//
//    }
//}
//class OddCells1 {
//    public int oddCells(int m, int n, int[][] indices) {
//        Set<Integer> left_set = new HashSet<>();
//        Set<Integer> right_set = new HashSet<>();
//        int result = 0;
//        for(int[] indice:indices){
//            if(!left_set.contains(indice[0])){
//                left_set.add(indice[0]);
//                result = result + n- Math.max(1,right_set.size());
//            }else {
//                left_set.remove(indice[0]);
//                result = result-n + Math.max(1,right_set.size());
//            }
//            if(!right_set.contains(indice[1])){
//                right_set.add(indice[1]);
//                result = result + m - Math.max(1,left_set.size());
//            }else {
//                right_set.remove(indice[1]);
//                result = result - m + Math.max(1,left_set.size());
//            }
//        }
//        return result;
//    }
//}