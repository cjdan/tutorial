package tutorial;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561, 3232, 32467};
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        int[] result = quickSort(arr, 0, arr.length - 1);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("arr=" + Arrays.toString(result));
    }

    public static int[] quickSort(int[] arr, int left, int right){
        int l = left; //左下标
        int r = right; //右下标
        int pivot = arr[(left + right) / 2];
        int temp ; //临时变量，作为交换时使用
        while( l < r) {
            //在 pivot 的左边一直找,找到大于等于 pivot 值,才退出
            while( arr[l] < pivot) {
                l += 1;
            }
            while( arr[r] > pivot) {
                r -= 1;
            }
            //如果 l >= r 说明 pivot 的左右两的值，已经按照左边全部是
            //小于等于 pivot 值，右边全部是大于等于 pivot 值
            if( l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个 arr[l] == pivot 值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个 arr[r] == pivot 值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }
            if (l == r) {
                l += 1;
                r -= 1;
            }
            //向左递归
            if(left < r) {
                quickSort(arr, left, r);
            }
            //向右递归
             if(right > l) {
                 quickSort(arr, l, right);
             }
        }
        return arr;
    }
}
