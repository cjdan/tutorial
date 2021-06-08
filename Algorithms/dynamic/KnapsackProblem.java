package tutorial.Algorithms.dynamic;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3,2};//物品的重量
        int[] value = {1500,3000,2000,1800};//物品价值
        int m = 3;//背包重量
        int n = value.length;//物品的个数

        //创建二维数组，v[i][j]表示前i个物品中能够装入容量为j的背包中的价值
        int[][] v = new int[n+1][m+1];
        int[][] path = new int[n+1][m+1];
        for(int i=0;i<v.length;i++){
            v[i][0] = 0;
        }
        Arrays.fill(v[0], 0);
        for (int i =1;i<v.length;i++){//不处理第一行
            for (int j=1;j<v[0].length;j++){//不处理第一列
                //
                if (w[i-1] > j){//因为下标从1开始，因此从i-1开始。
                    v[i][j] =  v[i-1][j];
                }else {
                    if (v[i-1][j]<value[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = value[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(v));
        System.out.println("=================");
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1; //列的最大下标
        while(i > 0 && j > 0 ) { //从 path 的最后开始找
             if(path[i][j] == 1) {
                 System.out.printf("第%d 个商品放入到背包\n", i);
                 j -= w[i-1]; //w[i-1]
            }
             i--;
        }
    }
}
