package Leetcode;

public class CountNegatives {
    public static void main(String[] args) {
        Solution25 P = new Solution25();
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(P.countNegatives(grid));

    }
}
class Solution25 {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[rows-i-1][cols-j-1]>=0){
                    break;
                }else{
                    result++;
                }
            }
        }
        return result;

    }
}
