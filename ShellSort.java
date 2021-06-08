package tutorial;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        //希尔排序，交换式
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
    }
    public static void shellSort(int[] arr) {
        int k = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            int temp;
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j--) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第" + (k + 1) + "轮后~~");
            k++;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void shellSort2(int[] arr) {
        // 增量 gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第 gap 个元素，逐个对其所在的iiii组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出 while 后，就给 temp 找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

//        //第一轮
//        //1.第一轮排序，是将10个数据分成5组
//        for(int i=5;i<arr.length;i++){
//            //遍历各组中所有的元素
//            for(int j = i - 5;j >= 0;j-=5){
//                //如果当前元素大于加上步长后的元素，需要交换
//                if(arr[j]>arr[j+5]){
//                    int temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j+5] = temp;
//                }
//            }
//
//        }
//        System.out.println("希尔排序第一轮~~");
//        System.out.println(Arrays.toString(arr));
//        //第二轮
//        //2.第二轮排序，是将10个数据分成2组
//        for(int i=2;i<arr.length;i++){
//            //遍历各组中所有的元素
//            for(int j = i - 2;j >= 0;j-=2){
//                //如果当前元素大于加上步长后的元素，需要交换
//                if(arr[j]>arr[j+2]){
//                    int temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j+2] = temp;
//                }
//            }
//
//        }
//        System.out.println("希尔排序第二轮~~");
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮
//        //3.第二轮排序，是将10个数据分成2组
//        for(int i=1;i<arr.length;i++){
//            //遍历各组中所有的元素
//            for(int j = i - 1;j >= 0;j-=1){
//                //如果当前元素大于加上步长后的元素，需要交换
//                if(arr[j]>arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j+1] = temp;
//                }
//            }

//        }
//        System.out.println("希尔排序第三轮~~");
//        System.out.println(Arrays.toString(arr));


}
