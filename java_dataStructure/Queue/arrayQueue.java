package java_dataStructure.Queue;
import java.util.Scanner;

/**
 * 利用数组实现队列
 */
public class arrayQueue {
    public static void main(String[] args) {
      queue q = new queue(3);
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
/**
 * 创建一个队列
 */
class queue {
    private int maxSize; //标记队列最大容量
    private int front; //队列的头
    private int footer; //队列的尾
    private int[] arr;  //存储队列的值

    public queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        footer = -1;
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
        return front == (maxSize - 1);
    }
    /**
     * 队列插入数据
     */
    public void addQueue(int data){
        if(isFull()){
            System.out.println("队满，无法插入数据");
            return;
        }
        footer++;
        arr[footer]=data;
    }
    /**
     * 数据出队列
     * @return
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    /**
     * 取队列头数据
     * @return
     */
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
    /**
     * 显示队列数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据可显示");
            return;
        }
        for (int ar:arr){
            System.out.println(ar);
        }
    }
}
