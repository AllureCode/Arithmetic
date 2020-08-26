package jianNanOffer;
/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-26 16:06
 * 输入一个链表，反转链表后，输出新链表的表头。
 **/
public class JZ15 {
    public static void main(String[] args) {
    }

    /**
     * 反转链表
     * 创建一个新的链表 将原始链表遍历
     * 将后来的元素插入到新链表的最前面
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newNode = null;
        ListNode tempNode = head;
        ListNode nextNode = null;
        while(tempNode!=null){
            nextNode = tempNode.next;
            tempNode.next = newNode;
            newNode = tempNode;
            tempNode = nextNode;
        }
        return newNode;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
