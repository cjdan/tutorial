package tutorial.BinarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arrs={7,3,10,12,5,1,9};
        BinareSortTree binareSortTree = new BinareSortTree();
        //循环添加节点到二叉排序树
        for (int arr : arrs) {
            binareSortTree.add(new Node(arr));
        }
        //中序遍历
        System.out.println("中序排列二叉树");
        binareSortTree.infixOrder();
        binareSortTree.add(new Node(2));
        System.out.println("添加节点后");
        binareSortTree.infixOrder();

        //测试一下删除叶子节点
        binareSortTree.delNode(2);
        binareSortTree.delNode(7);
        binareSortTree.delNode(5);
        binareSortTree.delNode(9);
        binareSortTree.delNode(12);
        System.out.println("root = "+binareSortTree.getRoot());
        binareSortTree.delNode(10);
        System.out.println("root = "+binareSortTree.getRoot());
        binareSortTree.delNode(3);
        System.out.println("root = "+binareSortTree.getRoot());
        binareSortTree.delNode(1);
        System.out.println("删除节点后");
        binareSortTree.infixOrder();

    }
}

//创建二叉排序树
class BinareSortTree{

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

//创建节点
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        super();
        this.value = value;
    }
    //添加节点
    public void add(Node node){
        //1.递归形式添加节点
        if (node==null){
            return;
        }else {
            //判断传入节点的值与当前节点值得大小
            if(node.value<this.value){
                //如果当前节点左子节点为空
                if(this.left==null){
                    this.left = node;

                }else {
                    //递归向左添加
                    this.left.add(node);
                }

            }else{//添加的节点值大于当前节点
                if(this.right==null){
                    this.right = node;
                }else {
                    //递归向右添加
                    this.right.add(node);
                }

            }
        }
    }

    //
    /*
    //value:要删除节点的值
     */
    public Node search (int value){
        if(this.value==value){
            return this;
        }else if(value<this.value){
            //小于当前节点，向左子树递归查找
            //如果左子节点为空
            if(this.left!=null){
                return this.left.search(value);
            }
            return null;


        }else {
            if(this.right!=null){
                return this.right.search(value);
            }
            return null;
        }
    }
    //查找要删除节点的父节点
    //返回的是要删除节点的父节点
    public Node searchParent(int value){
        //当前节点就是要删除的节点的父节点，就返回
        if((this.left!=null &&this.left.value==value)||(this.right!=null &&this.right.value==value)){
            return this;
        }else {
            //如果查找的节点小于当前节点的值，并且当前节点坐子节点不为空
            if(value<this.value && this.left!=null){
                return this.left.searchParent(value);
            }else if(value>=this.value && this.right!=null){
                return this.right.searchParent(value);
            }else {
                return null;//没有找到父节点
            }

        }
    }

    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
