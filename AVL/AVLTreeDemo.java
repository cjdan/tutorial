package tutorial.AVL;

public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
//        int[] arr = {10,12,8,9,7,6};
        int[] arr = {10,11,2,3,4,5,6,7,8,9,1};
        //创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加节点
        for (int value : arr) {
            avlTree.add(new Node(value));
        }
        System.out.println("中序遍历");
        avlTree.infixOrder();

        //没有做平衡处理之前
        System.out.println("树的高度为:"+avlTree.getRoot().height());

        System.out.println("左子树树的高度为:"+avlTree.getRoot().leftHeight());

        System.out.println("右子树树的高度为:"+avlTree.getRoot().rightHeight());

        System.out.println("根节点为:"+avlTree.getRoot());
        System.out.println("根节点的左边为"+avlTree.getRoot().left);
        System.out.println("根节点的右边为"+avlTree.getRoot().right);
    }
}

//创建AVLTree
class AVLTree{
    private Node root;
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    public void  add(Node node){
        if (root==null){
            root = node;//直接让node=root
        }else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder() {
        if(root==null){
            System.out.println("当前二叉排序树为空");
        }else {

            root.infixOrder();
        }
    }
    //查找要删除的节点
    public Node search(int value){
        if(root==null){
            return null;
        }else {
            return root.search(value);
        }
    }
    //查找要删除的父节点
    public Node searchParent(int value){
        if(root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }
    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //查到要删除的节点
            Node targerNode = search(value);

            //如果targerNode没有父节点，targerNode为root
            if (targerNode == null) {
                System.out.println("没有要删除的节点");
                return;
            }

            //如果二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //找到targerNode的父节点
            Node parent = searchParent(value);

            if (targerNode.left == null && targerNode.right == null) { //删除的节点为叶子节点
                //判断targerNode是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;//左子节点
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;//右子节点
                }
            } else if (targerNode.left != null && targerNode.right != null) {//删除的节点有两个节点
                Node temp =targerNode.left;//左子树最大的值
                while (temp.right!=null){
                    temp = temp.right;
                }
//                Node temp = targerNode.right;//右子树最小的值
//                while (temp.left!=null){
//                    temp = temp.left;
//                }
                delNode(temp.value);
                targerNode.value = temp.value;

//                temp.left = targerNode.left;
//                temp

            } else {//删除的节点有只有一个节点
                //如果要删除的节点有左子节点
                if (targerNode.left != null) {
                    //如果targetNode是parent的左子节点
                    if(parent!=null){//targerNode为root时，需考虑其父节点为空！！！！！！！！
                        if (value == parent.left.value) {
                            parent.left = targerNode.left;
                        } else { //如果targetNode是parent的右子节点
                            parent.right = targerNode.left;
                        }
                    }else {
                        root = targerNode.left;
                    }
                } else {//如果要删除的节点有右子节点
                    if(parent!=null){//targerNode为root时，需考虑其父节点为空！！！！！！！！
                        if (value == parent.left.value) { //如果targetNode是parent的左子节点
                            parent.left = targerNode.right;
                        } else { //如果targetNode是parent的右子节点
                            parent.right = targerNode.right;
                        }
                    }else {
                        root = targerNode.right;
                    }
                }
            }
        }
    }
}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        super();
        this.value = value;
    }
    //返回左子树的高度
    public int leftHeight(){
        if(left==null){
            return 0;
        }else {
            return left.height();
        }
    }
    //返回右子树的高度
    public int rightHeight(){
        if(right==null){
            return 0;
        }else {
            return right.height();
        }
    }

    //返回当前节点的高度，以该节点为根节点树的高度
    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左旋转方法
    public void leftRotate(){
        //1.创建新的节点，以当前节点
        Node newNode = new Node(value);
        //2.把新的结点的左子树设置成当前结点的左子树
        newNode.left = left;
        //3.把新的结点的右子树设置为当前结点的右子树的左子树
        newNode.right = right.left;
        //4.把当前结点的值替换成右子结点的值
        value = right.value;
        //5.把当前节点的右子树设置成右子树的右子树
        right = right.right;
        //6.把当前结点的左子结点设置成新的结点
        left = newNode;
    }



    //右旋转方法
    public void rightRotate(){
        //1.创建新的节点，以当前节点
        Node newNode = new Node(value);
        //2.把新的结点的右子树设置成当前结点的右子树
        newNode.right = right;
        //3.把新的结点的左子树设置为当前结点的右子树的左子树
        newNode.left = left.right;
        //4.把当前结点的值替换成左子结点的值
        value = left.value;
        //5.把当前节点的右子树设置成左子树的左子树
        left = left.left;
        //6.把当前结点的左子结点设置成新的结点
        right  = newNode;
    }

    //添加节点
    public void add( Node node){
        //1.递归形式添加节点
        if (node == null){
            return;
        }else {
            //判断传入节点的值与当前节点值得大小
            if(node.value < this.value){
                //如果当前节点左子节点为空
                if(this.left==null){
                    this.left = node;
                }else {
                    //递归向左添加
                    this.left.add(node);
                }
            }else{//添加的节点值大于当前节点
                if(this.right == null){
                    this.right = node;
                }else {
                    //递归向右添加
                    this.right.add(node);
                }
            }
        }

        //当添加完一个节点，如果：(右子树的高度-左子树的高度)>1,左旋转
        if (rightHeight() - leftHeight()>1){
            //如果当前节点的右子树的右左树对的高度大于当前节点右子树高度
            if(right != null && right.rightHeight() < right.leftHeight()){
                //先对右子树进行右旋转
                right.rightRotate();
            }
            leftRotate();//左旋转

        }
        //当添加完一个节点，如果：(左子树的高度-右子树的高度)>1,右旋转
        else if(leftHeight() - rightHeight() > 1){
            //如果当前节点的左子树的右子树对的高度大于当前节点左子树高度
            if (left != null && left.rightHeight() > left.leftHeight()){
                //先对当前结点的左子树进行左旋转
                left.leftRotate();
            }
            rightRotate();//右旋转
        }
    }

    //
    /*
    //value:要删除节点的值
     */
    public Node search (int value){
        if(this.value == value){
            return this;
        }else if(value < this.value){
            //小于当前节点，向左子树递归查找
            //如果左子节点为空
            if(this.left != null){
                return this.left.search(value);
            }
            return null;
        }else {
            if(this.right != null){
                return this.right.search(value);
            }
            return null;
        }
    }
    //查找要删除节点的父节点
    //返回的是要删除节点的父节点
    public Node searchParent(int value){
        //当前节点就是要删除的节点的父节点，就返回
        if((this.left != null &&this.left.value == value)||(this.right != null && this.right.value == value)){
            return this;
        }else {
            //如果查找的节点小于当前节点的值，并且当前节点坐子节点不为空
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if(value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else {
                return null;//没有找到父节点
            }
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}