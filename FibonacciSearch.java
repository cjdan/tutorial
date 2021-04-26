package tutorial;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,100,1000,1234};
        System.out.println(fibSeach(arr,100));



    }
    //非递归的斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] =0;
        f[1] =1;
        for (int i=2;i<maxSize;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }
    //斐波那契查找算法
    public static int fibSeach(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;
        int k = 0;//表示斐波那契分割数值的下表
        int mid;//存放mid值
        int[] f = fib();//获得斐波那契数列

        System.out.println("ffffff");
        System.out.println(Arrays.toString(f));
        while(high > f[k] - 1){
            k++;
        }
        int[] temp = Arrays.copyOf(arr,f[k]);

        for(int i=high+1;i< temp.length;i++){
            temp[i] = arr[high];
        }
        while (low<=high){
            mid = low +f[k-1]-1;
            if(key<temp[mid]){
                high = mid -1;
                k--;
            }else if(key>temp[mid]) {
                low = mid + 1;
                k-=2;
            }else {
                return Math.min(mid, high);
            }
        }

//        System.out.println(Arrays.toString(temp));
        //
        return -1;

    }
}
