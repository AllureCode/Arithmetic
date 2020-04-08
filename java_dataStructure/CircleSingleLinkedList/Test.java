package java_dataStructure.CircleSingleLinkedList;

/**
 * 环形链表解决约瑟夫问题
 */
public class Test {
    public static void main(String[] args) {
        LoopLinkedList loopLinkedList = new LoopLinkedList();
        loopLinkedList.createNode(5);
//        loopLinkedList.showBoy();
        loopLinkedList.OutBoy(1, 2, 5);
    }
}

//创建环形链表
class LoopLinkedList {
    private Boy first = new Boy(); //创建第一个孩子节点

    //添加节点
    public void createNode(int num) {
        if (num < 1) {
            System.out.println("请输入大于1的值");
            return;

        }
        //创建一个辅助节点
        Boy temp = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            //第一个节点
            if (i == 1) {
                first = boy;
                // first.next = first; //构成环形链表
                first.setNext(first);
                temp = first; //让temp指向第一个小孩
            } else {
//                temp.next=boy;
                temp.setNext(boy);
//                boy.next = first;
                boy.setNext(first);
                temp = boy;
            }

        }
    }

    /**
     * 根据用户的输入 计算出小孩出圈得顺序
     *
     * @param startNo 表示从第几个小孩开始
     * @param countNo 表示数几下
     * @param num     表示最初有多少个小孩在圈中
     */
    public void OutBoy(int startNo, int countNo, int num) {
        if (startNo < 1 || startNo > num || first == null) {
            return;
        }
        //定义一个辅助节点
        Boy auxiliaryNode = first;
        //将辅助节点指向环形链表最后
        while (true) {
            if (auxiliaryNode.getNext() == first) {
                break;
            }
            auxiliaryNode = auxiliaryNode.getNext();
        }
        //同时移动first 和 auxiliaryNode 使其指向开始的孩子
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            auxiliaryNode = auxiliaryNode.getNext();
        }
        //当环形链表中的孩子不为1时 一直循环并且将出圈的孩子打印
        while (true) {
            //判断圈中是否剩余一个孩子
            if (auxiliaryNode == first) {
                break;
            }
            //同时移动first 和 auxiliaryNode 使其指向要出圈的孩子
            for (int j = 0; j < countNo - 1; j++) {
                first = first.getNext();
                auxiliaryNode = auxiliaryNode.getNext();
            }
            System.out.println("出圈孩子" + first);
            first = first.getNext();
            auxiliaryNode.setNext(first);
        }
        System.out.println("最后留在圈子中的孩子"+first);
    }

    //遍历
    public void showBoy() {
        if (first.getNext() == null) {
            System.out.println("空链表");
            return;
        }
        Boy temp = first;
        while (true) {
            System.out.println("小孩的编号" + temp.getNo());
//            if (temp.next==first){
            if (temp.getNext() == first) {
                break;
            }
//            temp = temp.next;
            temp = temp.getNext();
        }
    }
}

//创建孩子节点
class Boy {
    private int no;
    private Boy next; //指向下一个节点

    public Boy() {
    }

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
