package tutorial.BinaryTree.threadebinatytree;

public class ThreadeBinaryTreeDemo {
    public static void main(String[] args) {
        //中序线索化二叉树的测试
        HereNode root = new HereNode(1, "tom");
        HereNode node2 = new HereNode(3, "jack");
        HereNode node3 = new HereNode(6, "smith");
        HereNode node4 = new HereNode(8, "mary");
        HereNode node5 = new HereNode(10, "king");
        HereNode node6 = new HereNode(14, "dim");
        //手动创建,参考s树图
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //线索化
        ThreadeBinaryTree threadeBinaryTree = new ThreadeBinaryTree();
        threadeBinaryTree.setRoot(root);
        threadeBinaryTree.threadeNodes();
        //测试，以10节点测试
        HereNode leftNode = node5.getLeft();
        HereNode rightNode = node5.getRight();
        System.out.println(leftNode.toString());
        System.out.println(rightNode.toString());

    }
}
//定义ThreadeBinaryTree
class ThreadeBinaryTree{
    private HereNode root;

    //为了实现线索化，需创建要给指向当前节点的前驱节点的指针
    //在进行递归线索化时，pre总是保留前一个节点
    private HereNode pre= null;

    public void setRoot(HereNode root){
        this.root = root;
    }

    //重载线索化方法
    public void threadeNodes(){
        this.threadeNodes(root);
    }


    public void threadeNodes(HereNode node){
        //先判断是否为空
        if(node==null){
//            System.out.println("节点为空");
            return;
        }else {
            //1.先线索化左子树
            threadeNodes(node.getLeft());
            //2.再线索化当前节点
            //2.1先处理当前节点的前驱节点
            if(node.getLeft()==null){
                //让当前节点的左子针指向前驱节点
                node.setLeft(pre);
                //修改当前节点的左子针类型
                node.setLeftType(1);
            }
            //处理后继节点
            if(pre!=null&&pre.getRight()==null){
                //让前驱节点的右指针指向当前节点
                pre.setRight(node);
                //修改前驱节点的右节点类型
                pre.setRightType(1);
            }
            //每处理一个节点后，让当前节点是下一个节点的前驱节点
            pre = node;

            //3.最后线索化右节点
            threadeNodes(node.getRight());
        }
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
class HereNode {
        private int no;
        private String name;
        private HereNode left;
        private HereNode right;

        //如果leftType=0，表示指向左子树，如果leftType=1,表示指向前驱节点
        private int leftType;
        //如果rightType=0，表示指向右子树，如果rightType=1,表示指向后驱节点
        private int rightType;

        public HereNode(int no, String name){
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

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
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


