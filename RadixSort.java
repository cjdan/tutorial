package tutorial;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);

    }

    //基数排序方法
    public static void radixSort(int[] arr){
        //找到最大值
        int max = arr[0];
        for (int i=1;i<arr.length;i++){
            if (max<arr[i]){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();


        //第一轮排序,针对每个元素的个位数进行排序
        //定义二维数组表示10个桶
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放的数据的个数
        int[] bucketElementsCounts = new int[10];
        for(int i = 0 , n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                int digitOfElement = value / n % 10;
                //放到对应的桶中
                bucket[digitOfElement][bucketElementsCounts[digitOfElement]] = value;
                bucketElementsCounts[digitOfElement]++;
            }
            //按照桶的顺序，依次取出数据，放入原来数组
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入元素
            for (int k = 0; k < bucketElementsCounts.length; k++) {
                //如果桶中有数据，才放入原数组
                if (bucketElementsCounts[k] != 0) {
                    //循环该桶
                    for (int l = 0; l < bucketElementsCounts[k]; l++) {
                        arr[index++] = bucket[k][l];//先复制，后+1
                    }
                }
                bucketElementsCounts[k] = 0;//桶清除，非常重要！！！
            }
            System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }

//        System.out.println("第一轮");
//        System.out.println(Arrays.toString(arr));

    }
}
