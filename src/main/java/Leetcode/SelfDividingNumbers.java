package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        int left = 20;
        int right = 22;
        selfDividingNumbers1 p = new selfDividingNumbers1();
        System.out.println(p.selfDividingNumbers(left, right));

    }

}
class selfDividingNumbers1 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList();
        for (int i = left; i <= right; i++) {
            String redium_num = Integer.toString(i);//int转str
            boolean flag = true;
            for (int j = 0; j < redium_num.length(); j++) {
                if (Integer.parseInt(redium_num.substring(j)) == 0 || i % Integer.parseInt(redium_num.substring(j,j+1)) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }
}