package tutorial.BinaryTree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //要求升序排序
        int[] arr = {4,6,8,5,9,-1,20,438,29};
        heapSort(arr);

    }
    //编写一个堆排序方法

    public static void heapSort(int[] arr){
        int temp=0;
        System.out.println("堆排序");
//        //分布完成
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次");
//        System.out.println(Arrays.toString(arr));
//
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次");
//        System.out.println(Arrays.toString(arr));
        for(int i = arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        for(int j=arr.length-1;j>0;j--){
            //交换
            temp = arr[j];
            arr[j] = arr[0];//最大值
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }

        System.out.println(Arrays.toString(arr));


    }
    //讲一个数组，调整为大顶堆
    /*
    arr:待调整的数组
    i:表示非叶子节点在数组中的索引
    length：表示对多少个元素进行调整，length再逐渐减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //说明：1.k=i*2+1 k是i节点的左子针
        for (int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){//说明左子节点的值小于右子节点的值
                  k++;//k指向右子节点
            }
            if(arr[k]>temp){//如果子节点，大于父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i=k;//让i指向k,继续循环比较
            }else {
                break;//！
            }
        }
        //for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶上
        arr[i] = temp;//将temp放到调整后的位置


    }
}

