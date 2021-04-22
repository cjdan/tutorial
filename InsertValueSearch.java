package tutorial;

import java.util.ArrayList;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5};
        int value = 8;
        System.out.println("index = "+insertValueSearch(arr,0,arr.length-1,value));

    }

    public static ArrayList<Integer> insertValueSearch(int[] arr, int left, int right, int value){


        if (left>right){
//            resIndexList.add(-1);
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        if (arr[mid]==value){
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            resIndexList.add(mid);
            int temp = mid-1;
            while (arr[temp] == value && temp >= 0) {
                resIndexList.add(temp);
                temp--;
            }
            temp = mid+1;
            while (arr[temp] == value && temp <= arr.length - 1) {
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }else if(arr[mid]>value){
            return insertValueSearch(arr,left,mid-1,value);
        }else {
            return insertValueSearch(arr,mid+1,right,value);
        }

    }
}
