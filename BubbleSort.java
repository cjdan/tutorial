package tutorial;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        int temp;
//        //第一次排序
//        for (int i=0;i< arr .length-1;i++){
//            if(arr[i]>arr[i+1]){
//                temp = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = temp;
//            }
//        }
//        System.out.println("第一次排序");
//        System.out.println(Arrays.toString(arr));
//
//        //第二次排序
//        for (int i=0;i< arr .length-1-1;i++){
//            if(arr[i]>arr[i+1]){
//                temp = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = temp;
//            }
//        }
//        System.out.println("第二次排序");
//
//        System.out.println(Arrays.toString(arr));
//
//        //第三次排序
//        for (int i=0;i< arr .length-1-2;i++){
//            if(arr[i]>arr[i+1]){
//                temp = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = temp;
//            }
//        }
//        System.out.println("第三次排序");
//        System.out.println(Arrays.toString(arr));
//
//        //第四次排序
//        for (int i=0;i< arr .length-1-3;i++){
//            if(arr[i]>arr[i+1]){
//                temp = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = temp;
//            }
//        }
//        System.out.println("第四次排序");
//        System.out.println(Arrays.toString(arr));

//        整体写法
        //第四次排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1-i; j++)
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
            }
            System.out.println("第"+(i+1)+"次排序后");
            System.out.println(Arrays.toString(arr));
        }
    }
}
