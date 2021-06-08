package tutorial;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int value = 2;
        System.out.println("index = "+binarySearch1(arr,0,arr.length-1,value));

    }
    public static int binarySearch(int[] arr,int left,int right,int value){
//        int length = arr.length;
        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
//        while (length)/
        if (arr[mid]==value){
            return mid;
        }else if(arr[mid]>value){
            return binarySearch(arr,left,mid-1,value);
        }else {
            return binarySearch(arr,mid+1,right,value);
        }
    }
    public static ArrayList<Integer> binarySearch1(int[] arr, int left, int right, int value){



        if (left>right){
//            resIndexList.add(-1);
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        if (arr[mid]==value){
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            resIndexList.add(mid);
            int temp = mid-1;
            while (true){
                if(arr[temp] != value||temp<0){
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            temp = mid+1;
            while (true){
                if(arr[temp] != value||temp>arr.length-1){
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }else if(arr[mid]>value){
            return binarySearch1(arr,left,mid-1,value);
        }else {
            return binarySearch1(arr,mid+1,right,value);
        }

    }
}
