package jianNanOffer;
/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-19 14:22
 * <p>
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,
 * 哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 **/
public class JZ46 {
    public static void main(String[] args) {
        System.out.println(luckPeople(12, 3));

        SingleLoopList singleLoopList = new SingleLoopList();
        singleLoopList.add(12);
        singleLoopList.exitLoop(1, 3);
    }

    /**
     * 数组法
     * @param n  参与游戏的小孩
     * @param m  数几下
     * @return
     */
    public static int luckPeople(int n, int m) {
        if (m < 1 || n < 0) {
            return -1;
        }
        int people = n;
        int count = 0;
        int[] arr = new int[n];
        int i = -1;
        while (people > 0) {
            i++;
            if (i >= n) {
                i = 0;
            }
            if (arr[i] == -1) {
                continue;
            }
            count++;
            if (count == m) {
                arr[i] = -1;
                count = 0;
                people = people - 1;
            }
        }
        return i;
    }
}

/**
 * 循环链表法
 */
class SingleLoopList {
    private Boy first = null;
    private Boy curBoy = null;

    public void add(int num) {

        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            //第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     *
     * @param startNo  开始报数的小孩
     * @param k      数几下
     *
     */
    public void exitLoop(int startNo,int k){
        if (startNo<1){
            System.out.println("....");
        }
        Boy helpPoint = first;
        while (true){
            if (helpPoint.getNext()==first){
                break;
            }
            helpPoint = helpPoint.getNext();
        }
        for (int i = 0; i < startNo-1 ; i++) {
            first = first.getNext();
            helpPoint = helpPoint.getNext();
        }
        while (true){
            if (helpPoint==first){
                break;
            }
            for (int i = 0; i < k-1; i++) {
                first = first.getNext();
                helpPoint = helpPoint.getNext();
            }
            first = first.getNext();
            helpPoint.setNext(first);
        }
        System.out.println("留下的"+first.getId());
    }

}

class Boy {
    private int id;
    private Boy next = null;

    public Boy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}