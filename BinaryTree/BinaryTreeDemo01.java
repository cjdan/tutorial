package tutorial.BinaryTree;

public class BinaryTreeDemo01 {
    public static void main(String[] args) {
        //测试
        //1.创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        HereNode root = new HereNode(1, "宋江");
        HereNode node2 = new HereNode(2, "吴用");
        HereNode node3 = new HereNode(3, "卢俊义");
        HereNode node4 = new HereNode(4, "林冲");
        HereNode node5 = new HereNode(5, "关胜");
        //先手动创建二叉树，后面递归创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //测试
//        //1.前序遍历
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        //2.中序遍历
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        //3.后序遍历
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

        //4.前序查找
//        int no=2;
//        HereNode resNode = binaryTree.postOrderSearch(no);
//        if(resNode!=null){
//            System.out.println(resNode.toString());
//        }else {
//            System.out.println("未找到");
//        }
//        System.out.println(binaryTree.preOrderSearch(no).toString());
//        //中序查找
//        System.out.println(binaryTree.infixOrderSearch(no).toString());
//        //后序查找
//        System.out.println(binaryTree.postOrderSearch(no).toString());

        //4.删除节点
        int no=1;
        System.out.println("删除前,前序遍历");
        binaryTree.preOrder();
        System.out.println("删除后,前序遍历");
        binaryTree.delNode(no);
        binaryTree.preOrder();
    }
}

//定义BinaryTree
class BinaryTree{
    private HereNode root;
    public void setRoot(HereNode root){
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
//        System.out.println("当前节点为");
        System.out.println(this);//父节点
        //递归向左子树前序遍历
        if(this.root!=null){
            this.root.preOrder();//想左递归
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void infixOrder(){
//        System.out.println("当前节点为");
        System.out.println(this);//父节点
        //递归向左子树前序遍历
        if(this.root!=null){
            this.root.infixOrder();//想左递归
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void postOrder(){
//        System.out.println("当前节点为");
        System.out.println(this);//父节点
        //递归向左子树前序遍历
        if(this.root!=null){
            this.root.postOrder();//想左递归
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //前序查找
    public HereNode preOrderSearch(int no){
        if(root!=null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序查找
    public HereNode infixOrderSearch(int no){
        if(root!=null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序查找
    public HereNode postOrderSearch(int no){
        if(root!=null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
    public void   delNode(int no){
        if(root!=null){
            if(root.getNo()==no){
                root=null;
            }else {
                //递归删除
                root.delNode(no);
            }
        }else {
            System.out.println("空树");
        }
    }


}
//先创建节点，herenode
class HereNode{
    private int no;
    private String name;
    private HereNode left;
    private HereNode right;
    public HereNode(int no,String name){
        super();
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HereNode getLeft() {
        return left;
    }

    public HereNode getRight() {
        return right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HereNode left) {
        this.left = left;
    }

    public void setRight(HereNode right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "HereNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void preOrder(){
//        System.out.println("当前节点为");
        System.out.println(this);//父节点
        //递归向左子树前序遍历
        if(this.left!=null){
            this.left.preOrder();//想左递归
        }
        //递归向右子树前序遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
//        System.out.println("当前节点为");

        //递归向左子树中序遍历
        if(this.left!=null){
            this.left.infixOrder();//想左递归
        }
        System.out.println(this);//父节点
        //递归向右子树中序遍历
        if(this.right!=null){
            this.right.infixOrder();
        }

    }

    //后序遍历
    public void postOrder(){

        //递归向左子树中序遍历
        if(this.left!=null){
            this.left.postOrder();//想左递归
        }

        //递归向右子树中序遍历
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);//父节点
    }

    //前序遍历查找，查到返回节点，没有返回null
    public HereNode preOrderSearch(int no){
        System.out.println("进入前序遍历");
        //1.比较当前节点是不是所需要的的值
        if(this.no==no){
//            System.out.println("找到了");
            return this;

        }
        //1.判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果找到了需要的节点，返回
        HereNode resNode = null;
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        //如果未找到，则继续判断
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    //中序遍历查找，查到返回节点，没有返回null
    public HereNode infixOrderSearch(int no){

        //1.判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果找到了需要的节点，返回
        HereNode resNode = null;
        if(this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        //如果未找到，则继续判断
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入中序遍历");
        //如果找到了
        if(this.no==no){
//            System.out.println("找到了");
            return this;

        }
        if(this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //中序遍历查找，查到返回节点，没有返回null
    public HereNode postOrderSearch(int no){


        //1.判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果找到了需要的节点，返回
        HereNode resNode = null;
        if(this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }
        //如果未找到，则继续判断
        if(resNode!=null){
            return resNode;
        }

        if(this.right!=null){
            resNode = this.right.postOrderSearch(no);
        }

        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入后序遍历");
        //如果找到了
        if(this.no==no){
//            System.out.println("找到了");
            return this;

        }

        return null;
    }
    public void delNode(int no){
    /*
    //递归删除结点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    首先，如果根节点为空，直接返回根节点
    1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断 当前这个结点是不是需要删除结点.
    2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将 this.left = null; 并且就返回 (结束递归删除)
    3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将 this.right= null ;并且就返回 (结束递归删除)
    4. 如果第 2 和第 3 步没有删除结点，那么我们就需要向左子树进行递归删除
    5. 如果第 4 步也没有删除结点，则应当向右子树进行递归删除.
     */
        //2.如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将 this.left = null; 并且就返回 (结束递归删除)
        if(this.left!=null&&this.left.no==no){
            this.left = null;
            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将 this.right= null ;并且就返回 (结束递归删除)
        if(this.right!=null&&this.right.no==no){
            this.right = null;
            return;
        }
        //4.如果第 2 和第 3 步没有删除结点，那么我们就需要向左子树进行递归删除
        if(this.left!=null){
            this.left.delNode(no);
        }
        //5.如果第 4 步也没有删除结点，则应当向右子树进行递归删除.
        if(this.right!=null){
            this.right.delNode(no);
        }


    }
}
