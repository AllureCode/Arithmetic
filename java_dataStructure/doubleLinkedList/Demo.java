package java_dataStructure.doubleLinkedList;


/**
 * 双链表
 */
public class Demo {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        DoubleLinkedNode node = new DoubleLinkedNode(1, "aa");
        DoubleLinkedNode node1 = new DoubleLinkedNode(2, "bb");
        DoubleLinkedNode node2 = new DoubleLinkedNode(3, "bb");
        linkedList.addOrderBy(node1);
        linkedList.addOrderBy(node2);
        linkedList.addOrderBy(node);
//        linkedList.addNode(node1);
//        linkedList.showList();
//        linkedList.update(new DoubleLinkedNode(1, "aaa"));
//        linkedList.showList();
//        linkedList.deleteNode(1);
        linkedList.showList();
    }
}


//定义一个链表
class DoubleLinkedList {
    DoubleLinkedNode headNode = new DoubleLinkedNode();


    //添加节点
    public void addNode(DoubleLinkedNode doubleLinkedNode) {
        DoubleLinkedNode temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //形成双链表
        temp.next = doubleLinkedNode;
        doubleLinkedNode.pre = temp;
    }
    //按顺序添加节点
    public void addOrderBy(DoubleLinkedNode newNode){

        DoubleLinkedNode temp = headNode;
        boolean flag=false;
        while (true){
            if (temp.next == null) {
                break;
            }
            if (temp.next.val>newNode.val){
                break;
            }else if (temp.next.val==newNode.val){
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("该值["+newNode.val+"]已存在无法加入");
        }else {
            newNode.next = temp.next;
            temp.next = newNode;
            temp.pre = newNode.pre;
        }
    }
    //更新节点
    public void update(DoubleLinkedNode newNode) {
        if (headNode.next == null) {
            System.out.println("空链表");
            return;
        }
        boolean flag = false;
        DoubleLinkedNode temp = headNode;
        while (true) {
            if (temp.val == newNode.val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newNode.name;
        } else {
            System.out.println("当前输入的值在该链表中不存在");
        }
    }

    //删除节点
    public void deleteNode(int val) {
        if (headNode.next == null) {
            System.out.println("空链表");
            return;
        }
        boolean flag = false;
        DoubleLinkedNode temp = headNode;
        while (true) {
            if (temp.val == val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //如果没有此判断 当删除最后一个节点会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }

    //显示节点
    public void showList() {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleLinkedNode temp = headNode.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


//定义一个节点
class DoubleLinkedNode {
    public int val;
    public String name;
    public DoubleLinkedNode next; //指向链表下一个
    public DoubleLinkedNode pre;  //指向链表上一个

    public DoubleLinkedNode() {
    }

    public DoubleLinkedNode(int val, String name) {
        this.val = val;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "val=" + val +
                ", name='" + name + '\'' +
                '}';
    }
}