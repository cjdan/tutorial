package Leetcode;

import java.awt.image.BandedSampleModel;

class Solution19 {
    public int maxDepth(String s) {
        char[] array=s.toCharArray();
        int depth = 0;
        int MaxDepth = 0;
        for (char c : array) {
            if (c == '(') depth++;
            else if (c == ')') depth--;
            if(depth > MaxDepth) {
                MaxDepth = depth;
            }
        }
        return MaxDepth;

    }

}