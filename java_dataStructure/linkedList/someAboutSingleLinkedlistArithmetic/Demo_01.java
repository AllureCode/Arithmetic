package java_dataStructure.linkedList.someAboutSingleLinkedlistArithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Demo_01 {
    public static void main(String[] args) {
        linkedList listNode = new linkedList().inuPutLinkedlist();
        linkedList listNode2 = new linkedList().inuPutLinkedlist();
        //     System.out.println("有效的节点"+getCountNode(listNode));
        //       flashBackNode(listNode, 2);
        //       System.out.println(findNode(listNode, 2));
//        listNode.show(listNode);
//        reverseLinkNode(listNode);
//        listNode.show(listNode);
//        flashBack(listNode);
        System.out.println(combineNode(listNode,listNode2));
    }


    /**
     * 百度面试：合并两个有序链表
     *
     * @param node1
     * @param node2
     * @return
     */
    public static linkedList combineNode(linkedList node1, linkedList node2) {
        //思路：利用递归实现
        linkedList newNode = null;
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1.value <= node2.value) {
            newNode = node1;
            newNode.next = combineNode(node1.next, node2);
        } else {
            newNode = node2;
            newNode.next = combineNode(node2.next, node1);
        }
        return newNode;
    }

    /*
     新浪面试题：统计单链表中的有效节点数
     */
    public static int getCountNode(linkedList headNode) {
        if (headNode.next == null) {
            return 0;
        }
        int length = 0;
        while (headNode.next != null) {
            length++;
            headNode.next = headNode.next.next;
        }
        return length;
    }

    /**
     * 新浪面试题：打印单链表倒数第K个节点
     *
     * @param node 传入的链表
     * @param n    第几个节点
     */
    public static void flashBackNode(linkedList node, int n) {
        List list = new ArrayList();
        linkedList temp = node.next;
        while (temp != null) {
            list.add(0, temp.value);
            temp = temp.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == (n - 1)) {
                System.out.println("倒数第" + n + "个节点:" + list.get(i));
            }
        }
    }

    /**
     * 新浪面试题：打印单链表倒数第K个节点
     *
     * @param node  传入的链表
     * @param index 第几个节点
     */
    public static linkedList findNode(linkedList node, int index) {
        /*思路：
        先遍历原始链表 找到有效的节点数 然后从0开始遍历到（有效节点数-index)位置返回此节点
         */
        if (node.next == null || node.next.next == null) {
            return node;
        }
        linkedList temp = node.next;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        linkedList findNode = node.next;
        for (int i = 0; i < count - index; i++) {
            findNode = findNode.next;
        }
        return findNode;
    }

    /**
     * 百度面试题：将单链表倒叙输出
     */
    public static void flashBack(linkedList node) {
        //利用栈实现
        if (node.next == null) {
            return;
        }
        Stack<linkedList> stack = new Stack<linkedList>();
        linkedList temp = node.next;
        while (temp != null) {
            stack.push(temp);//将链表节点压入栈中
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


    /**
     * 腾讯面试题：反转单链表
     *
     * @param node
     */
    public static void reverseLinkNode(linkedList node) {
        /*
        思路：
        定义一个辅助节点遍历原始链表
        在定义一个空的新链表
        当辅助节点向后遍历一次 就将原始链表的值存入新链表的后面
        * */
        //如果链表长度为1或没有则不会要反转
        if (node.next == null || node.next.next == null) {
            return;
        }
        //辅助节点 用于遍历链表
        linkedList temp = node.next;
        linkedList next = null;//指向当前链表（temp）的下一个节点
        linkedList newNode = new linkedList(); //定义一个空链表
        while (temp != null) {
            next = temp.next;//暂存当前节点的下一个节点
            temp.next = newNode.next;//将temp的下一个节点指向新链表的最前面
            newNode.next = temp;
            temp = next; //temp后移
        }
        node.next = newNode.next;
    }
}

/**
 * 创建一个单链表
 */
class linkedList {
    public int value;
    public linkedList next = null;

    linkedList() {
    }

    linkedList(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "linkedList{" +
                "value=" + value +
                '}';
    }

    /**
     * 显示链表
     *
     * @return
     */
    public void show(linkedList node) {
        if (node.next == null) {
            System.out.println("链表为空");
            return;
        }
        linkedList temp = node.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public linkedList inuPutLinkedlist() {
        linkedList head = new linkedList();//创建头节点
        linkedList temp = head;
        while (true) {
            Scanner sc = new Scanner(System.in);
            int val = sc.nextInt();
            if (0 == val) {     //输入0退出输入循环
                break;
            }
            linkedList linkedList = new linkedList(val);
            temp.next = linkedList;
            temp = linkedList;
            temp.next = null;
        }
        return head;
    }
}
