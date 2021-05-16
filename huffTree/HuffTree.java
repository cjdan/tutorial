package tutorial.huffTree;

import shapeless.PolyDefns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};

        Node root = createHuffTree(arr);
        root.preOrder();


    }


    //编写一个前序遍历的方法
    public static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else {
            System.out.println("空树，无法遍历");
        }

    }

    //创建HuffTree
    public static Node createHuffTree(int[] arr){
        //1.为了操作方便，遍历arr数据
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for(int value:arr){
            nodes.add(new Node(value));
        }

        //排序 从小到大
        Collections.sort(nodes);
        System.out.println("未处理");
        System.out.println("nodes = "+nodes);
        int i =0;
        while (nodes.size()>1){
            Node leftNode = nodes.get(0);
            //2.取出权值次小的节点
            Node rightNode = nodes.get(1);
            //3.构建一个新的二叉树
            Node parent = new Node(leftNode.value+ rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //4.从ArrayList中删除使用过的nodes
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5.将parent加入nodes
            nodes.add(parent);
            Collections.sort(nodes);
            System.out.println("第"+(i+1)+"次处理后");
            System.out.println("nodes = "+nodes);
            i++;
        }
        return nodes.get(0);
        //取出权值最小的两颗二叉树
        //1.取出权值最小的节点（二叉树）

        //排序 从小到大


    }
}

//创建节点类
//为了让Node对象持续排序Collections集合排序
//让Node实现Comparable借口
class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;//左子节点
    Node right;//右子节点

    public void preOrder(){
        System.out.println("前序遍历"+this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }





    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int value){

        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value-o.value;
        /*
        从大到小排序
         return o.value-this.value;
         */
    }
}
