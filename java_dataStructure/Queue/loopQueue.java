package java_dataStructure.Queue;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 * 思路分析：
 * 1.front变量的含义做调整：
 * front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素 front的初始值为0
 * 2.footer变量的含义做调整：
 * footer就指向队列的最后一个元素的后一位 因为需要空出一个空间作为约定 front的初始值为0
 * 3.当队列满的条件： front == (footer+1)%maxSize
 * 4.当队列为空的条件: front==footer
 * 5.队列中有效元素： (footer-front+maxSize)%maxSize
 */
public class loopQueue {
    public static void main(String[] args) {
        queue2 q = new queue2(3);
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(get):队列头数据");
            key=scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    q.showQueue();break;
                case 'a':
                    int data=scanner.nextInt();
                    q.addQueue(data);
                    break;
                case 'g':
                    int queue = q.getQueue();
                    System.out.println("取出数据"+queue);
                    break;
                case 'h':
                    int headQueue = q.headQueue();
                    System.out.println("队列头数据"+headQueue);
                    break;
                default:
                    break;
            }
        }
    }
}

class queue2 {
    private int front; //队首
    private int footer;//队尾
    private int maxSize;
    private int[] arr;

    public queue2(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        footer = 0;
        front = 0;
    }

    /**
     * 判断是否队空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == footer;
    }

    /**
     * 判断是否队满
     *
     * @return
     */
    public boolean isFull() {
        return front == (footer + 1) % maxSize;
    }

    /**
     * 队列插入数据
     */
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队满，无法插入数据");
            return;
        }
        arr[footer] = data;
        //footer指针后移  因为是环形队列 所以使用取模计算后移位置
        footer = (footer + 1) % maxSize;
    }
    /**
     * 数据出队列
     * @return
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    /**
     * 取队列头数据
     * @return
     */
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
    /**
     * 显示队列数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据可显示");
            return;
        }
        for (int i = front; i <(front+(footer-front+maxSize)%maxSize) ; i++) {
            System.out.println(arr[i]);
        }
    }

}