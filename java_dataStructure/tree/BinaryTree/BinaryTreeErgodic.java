package java_dataStructure.tree.BinaryTree;

import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import sun.plugin2.message.HeartbeatMessage;

/**
 * 二叉树的前中后序遍历
 */
public class BinaryTreeErgodic {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "吴用");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");
        HeroNode node4 = new HeroNode(5, "关胜");
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);
        binaryTree.setRoot(root);
        System.out.println("前序");
        binaryTree.preOrder();
        System.out.println("中序");
        binaryTree.midOrder();
        System.out.println("后序");
        binaryTree.postOrder();
        HeroNode node = null;
        try {
            node = binaryTree.midOrderSearch(15);
            System.out.println(node.getId() + "" + node.getName());
        } catch (NullPointerException e) {
            System.out.println("无此信息");
        }
        binaryTree.preOrderDelete(1);
        binaryTree.preOrder();

    }
}


//创建一颗树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        this.root.preOrder();
    }

    //中序遍历
    public void midOrder() {
        this.root.midOrder();
    }

    //后序遍历
    public void postOrder() {
        this.root.postOrder();
    }

    //前序遍历查询
    public HeroNode preOrderSearch(int id) {
        HeroNode node = null;
        if (this.root != null) {
            node = this.root.preOrderSearch(id);
        }
        return node;
    }

    //中序遍历查询
    public HeroNode midOrderSearch(int id) {
        HeroNode node = null;
        if (this.root != null) {
            node = this.root.midOrderSearch(id);
        }
        return node;
    }

    //后序遍历查询
    public HeroNode postOrderSearch(int id) {
        HeroNode node = null;
        if (this.root != null) {
            node = this.root.postOrderSearch(id);
        }
        return node;
    }

    //前序删除
    public void preOrderDelete(int id) {
        //判断根节点是否为空
        if (root != null) {
            //当根节点不为空 判断根节点是否为删除的节点
            if (root.getId() == id) {
                root = null;
            } else {
                root.preOrderDelete(id);
            }
        } else {
            System.out.println("空树无法删除");
        }
    }

}

class HeroNode {
    private int id;
    private String name;
    private HeroNode left;//左子树 默认null
    private HeroNode right;//右子树

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查询
    public HeroNode preOrderSearch(int id) {
        //判断当前节点是否等于查询的值
        if (this.id == id) {
            return this;
        }
        HeroNode current = null;
        if (this.left != null) {
            current = this.left.preOrderSearch(id);
        }
        if (current != null) {
            return current;
        }
        if (this.right != null) {
            current = this.right.preOrderSearch(id);
        }
        return current;
    }

    //中序遍历查询
    public HeroNode midOrderSearch(int id) {
        HeroNode current = null;
        if (this.left != null) {
            current = this.left.midOrderSearch(id);
        }
        if (current != null) {
            return current;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            current = this.right.midOrderSearch(id);
        }
        return current;
    }

    //后序遍历查询
    public HeroNode postOrderSearch(int id) {
        HeroNode current = null;
        if (this.left != null) {
            current = this.left.postOrderSearch(id);
        }
        if (current != null) {
            return current;
        }
        if (this.right != null) {
            current = this.right.postOrderSearch(id);
        }
        if (current != null) {
            return current;
        }
        if (this.id == id) {
            return this;
        }
        return current;
    }

    //前序删除
    public void preOrderDelete(int id) {
        //如果当前节点的左子树不为空且就是要删除的节点
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        //如果当前节点的右子树不为空且就是要删除的节点
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        //如果左子树不为空 向左递归删除
        if (this.left != null) {
            this.left.preOrderDelete(id);
        }
        //如果右子树不为空 向右递归删除
        if (this.right != null) {
            this.right.preOrderDelete(id);
        }
    }
}