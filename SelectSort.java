package tutorial;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        //选择排序算法
        int[] arr = {104,34,119,1};
        selectSort(arr);

    }
    public static void selectSort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for(int j = i+1;j< arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));

        }
//        int minIndex = 0;
//        int min = arr[0];
//        for(int j = 1;j< arr.length;j++){
//            if(min>arr[j]){
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//        arr[minIndex] = arr[0];
//        arr[0] = min;
//        System.out.println("第一轮后~~");
//        System.out.println(Arrays.toString(arr));
//
//        minIndex = 1;
//        min = arr[1];
//        for(int j = 2;j< arr.length;j++){
//            if(min>arr[j]){
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//        arr[minIndex] = arr[1];
//        arr[1] = min;
//        System.out.println("第二轮后~~");
//        System.out.println(Arrays.toString(arr));
//
//        minIndex = 2;
//        min = arr[2];
//        for(int j = 3;j< arr.length;j++){
//            if(min>arr[j]){
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//        arr[minIndex] = arr[2];
//        arr[2] = min;
//        System.out.println("第三轮后~~");
//        System.out.println(Arrays.toString(arr));
    }
}
