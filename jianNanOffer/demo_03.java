package jianNanOffer;

import sun.nio.ch.WindowsSelectorProvider;
import sun.security.krb5.internal.tools.Klist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class demo_03 {
    class ListNode {    //内部类定义链表节点
        int val;
        ListNode next = null;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }


    //按链表值从尾到头的顺序返回一个ArrayList。
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> list = new ArrayList<>();

        ListNode tmp = listNode.next;  //链表头节点并没有存值
        while(tmp!=null){
            list.add(0,tmp.val);   //按链表值从尾到头添加到集合list中
            tmp=tmp.next;    //下一个节点
        }
        System.out.println(list);
        return (ArrayList<Integer>) list;

    }

    private ListNode inputLinkVal() {   //输入一个链表
        ListNode headNode = new ListNode();  //头节点
        ListNode tail;      //表尾节点
        tail = headNode;
        while (true) {
            Scanner sc = new Scanner(System.in);
            int val = sc.nextInt();
            if (0 == val) {     //输入0退出输入循环
                break;
            }

            ListNode listNode = new ListNode(val);      //新节点
            tail.next = listNode;       //尾插法添加节点
            tail = listNode;        //重置尾节点
            tail.next = null;       //尾节点的下一个置空

        }
        return headNode;        //返回头节点
    }



    public static void main(String[] args) {
        demo_03 solution = new demo_03();
        //输入链表值
        ListNode headNode =  solution.inputLinkVal();
        //按链表值从尾到头的顺序返回一个ArrayList
        solution.printListFromTailToHead(headNode);

    }
}