package Leetcode;

import java.util.*;

public class CanBeEqual {
    public static void main(String[] args) {
//        int[] target;
        Integer[] target = {1, 2, 3, 4};
        int[] arr = {2,4,1,3};
        CanBeEqual1 P= new CanBeEqual1();
        System.out.println(P.canBeEqual(target,arr));

    }
}
class CanBeEqual1 {
    public boolean canBeEqual(Integer[] target, int[] arr) {
        ArrayList<Integer> arrayList=new ArrayList(Arrays.asList(target));
        ArrayList<Integer> arrayList1=new ArrayList(Arrays.asList(arr));
        System.out.println(arrayList.toArray());
        for(int i=0;i<arrayList.size();i++){
            Object num = arrayList.get(i);
            System.out.println(num);
//            int index1 = arrayList1.indexOf(num);
//            if(index1==-1){
//                return false;
//            }else {
//                arrayList1.remove(index1);
//            }
        }
        return true;

    }
}