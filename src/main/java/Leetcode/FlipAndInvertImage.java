package Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        Solution10 P = new Solution10();
        System.out.println(Arrays.deepToString(P.flipAndInvertImage(image)));

    }
}
class Solution10 {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int[] temp = new int[image.length];
            for(int j=0;j<image.length;j++){
                temp[j] = 1- image[i][image.length-j-1];
            }
            image[i] = temp;

        }
        return image;

    }
}
