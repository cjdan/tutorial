package tutorial.BinaryTree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        //创建一个ArrayBinaryTree对象
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.infixOrder(0);
    }
}
//编写一个ArrayBinaryTree，顺序存储二叉树的遍历
class ArrayBinaryTree {
    private int[] arr;
    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
        //存储数据节点
    }
    /*
    1) 顺序二叉树通常只考虑完全二叉树
    2) 第 n 个元素的左子节点为 2 * n + 1
    3) 第 n 个元素的右子节点为 2 * n + 2
    4) 第 n 个元素的父节点为 (n-1) / 2
    5) n : 表示二叉树中的第几个元素(按 0 开始编号如图所示)
     */
    //重载preOrder
    public void preOrder(){
        this.preOrder(0) ;
    }
    //完成前序遍历,index数组下表
    public void preOrder(int index){
        //如果数组为空，或者arr.length=0
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }else {
            //输出当前这个元素
            System.out.println(arr[index]);
            //向左遍历
            if(2*index+1<arr.length){
                preOrder(2*index+1);
            }
            //向右遍历
            if(2*index+2<arr.length){
                preOrder(2*index+2);
            }
        }
    }

    //完成后序遍历,index数组下表
    public void postOrder(int index){
        //如果数组为空，或者arr.length=0
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }else {

            //向左遍历
            if(2*index+1<arr.length){
                postOrder(2*index+1);
            }
            //向右遍历
            if(2*index+2<arr.length){
                postOrder(2*index+2);
            }
            //输出当前这个元素
            System.out.println(arr[index]);
        }
    }

    //完成中序遍历,index数组下表
    public void infixOrder(int index){
        //如果数组为空，或者arr.length=0
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }else {

            //向左遍历
            if(2*index+1<arr.length){
                infixOrder(2*index+1);
            }
            //输出当前这个元素
            System.out.println(arr[index]);
            //向右遍历
            if(2*index+2<arr.length){
                infixOrder(2*index+2);
            }

        }
    }
}
