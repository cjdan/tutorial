package tutorial;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int left = 0;
        int right = arr.length -1;
        int[] temp = new int[arr.length];
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
        mergeSort(arr,left,right,temp);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            System.out.println("---+++");
            int mid = (left +right)/2;
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right, temp);
        }
    }
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左边有序序列的初始索引
        int j = mid+1;//右边初始序列的初始索引
        int t = 0;
        while (i<=mid && j<=right){//继续
            if (arr[i]<=arr[j]){
                temp[t] = arr[i];
                i++;
            }else{
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        System.out.println("temp");
        System.out.println(Arrays.toString(temp));
        while (i<=mid){//左边有序序列还有剩余的元素，全部填充至temp
            temp[t] =  arr[i];
            t++;
            i++;
        }
        while (j<=right){//右边有序序列还有剩余的元素，全部填充至temp
            temp[t] =  arr[j];
            t++;
            j++;
        }
        System.out.println("temp1");
        System.out.println(Arrays.toString(temp));
        t = 0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
