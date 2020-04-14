package java_dataStructure.TenCommonAlgorithms;

/**
 * The divide-and-conquer algorithm solves the hannotta
 */
public class DivideandConquer_Hanoi {
    public static void main(String[] args) {
        HanoiTower(5, 'A', 'B', 'C');
    }

    /**
     * @param num:传入的层数
     * @param a
     * @param b
     * @param c
     */
    public static void HanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("从" + a + "->" + c);
        } else {
            //把上面n-1看出一个整体 将最底层看为一个整体
            HanoiTower(num - 1, a, c, b);
            System.out.println("从" + a + "->" + c);
            HanoiTower(num - 1, b, a, c);
        }
    }
}
