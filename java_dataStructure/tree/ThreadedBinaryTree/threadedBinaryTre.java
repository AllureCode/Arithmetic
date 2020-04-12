package java_dataStructure.tree.ThreadedBinaryTree;

/**
 * 线索化二叉树
 */
public class threadedBinaryTre {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1, "a");
        HeroNode heroNode1 = new HeroNode(2, "b");
        heroNode.setLeft(heroNode1);
        ThreadedBinaryTree binaryTree= new ThreadedBinaryTree(heroNode);
        binaryTree.midOrder();
    }
}


//创建二叉树
class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre=null;//记录前驱节点
    public ThreadedBinaryTree(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if (root==null){
            System.out.println("空树");
        }
        root.preOrder();
    }
    //中序遍历
    public void midOrder(){
        if (root==null){
            System.out.println("空树");
        }
        root.midOrder();
    }
    //线索化二叉树中序遍历
    public void threadedBinaryTreeMidOrder(){
        //定义一个变量 存储当前节点 从root开始
        HeroNode node = root;
        while (node!=null){
            //循环找到leftType==1的节点
            //后面随着遍历而变化 因为当leftType==1时，说明改节点是按照线索化的
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针指向后继节点，就一直输出
            while (node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            //替换当前节点
            node = node.getRight();
        }
    }
    //线索化二叉树（中序线索化）
    public void threadedBinaryTree(HeroNode root){
        if (root==null){
           return;
        }
        //线索化左子树
        threadedBinaryTree(root.getLeft());
        //处理当前节点
        if (root.getLeft()==null){
            //让当前节点的左指针指向前驱节点
            root.setLeft(pre);
            root.setLeftType(1);
        }
        if (pre!=null && pre.getRight()==null){
            pre.setRight(root);
            pre.setRightType(1);
        }
        //每处理完一个节点，让当前节点是下一个节点的前驱节点
        pre = root;
        //线索化右子树
        threadedBinaryTree(root.getRight());
    }
}

//创建节点
class HeroNode{
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //如果leftType==0表示指向左子树，如果是1表示指向前驱节点
    //rightType==0表示指向右子树，如果是1表示指向后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
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

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void midOrder(){
        if (this.left!=null){
            this.left.preOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.preOrder();
        }
    }
}
