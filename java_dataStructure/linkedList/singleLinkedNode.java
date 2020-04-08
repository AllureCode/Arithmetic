package java_dataStructure.linkedList;

/**
 * 单链表
 */
public class singleLinkedNode {
    public static void main(String[] args) {
        HeadNode headNode = new HeadNode();
        HeroNode heroNode = new HeroNode(1, "a", "a");
        HeroNode heroNode1 = new HeroNode(2, "b", "b");
//        headNode.add(heroNode);
//        headNode.add(heroNode1);
//        headNode.showList();
        headNode.addByOrder(heroNode1);
        headNode.addByOrder(heroNode);
//        headNode.update(new HeroNode(1, "aa", "aa"));
        headNode.showList();
//        headNode.delete(10);
//        headNode.showList();
    }
}

//创建一个链表 管理HeroNode节点
class HeadNode {
    //创建一个头节点，头节点不能动 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单链表
     * 思路：当不考虑排序
     * 1.找到当前链表的最后一个节点
     * 2.将最后一个节点的next指向新的节点
     */
    public void add(HeroNode heroNode) {
        //因为头节点不能动 所以定义一个辅助变量 temp
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next; //temp后移
        }
        temp.next = heroNode;
    }

    /**
     * 带排序的添加
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                //找到插入的位置
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("插入的值[" + heroNode.no + "]已经存在请勿重复插入");
        } else {
            //插入数据
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    /**
     * 修改节点
     */
    public void update(HeroNode newHeroNode) {
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("链表为空");
                return;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("链表中没有要修改的节点请重新输入");
        }
    }

    /**
     * 删除节点
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //System.out.println("链表为空");
                //return;
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("该链表不存在当前要删除的值");
        }
    }

    /**
     * 显示
     */
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


}
//创建一个HeroNode节点 用于存储数据
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}