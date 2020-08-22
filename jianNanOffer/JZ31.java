package jianNanOffer;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-21 10:53
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,
 * 并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 **/
public class JZ31 {
    public static void main(String[] args) {
        int i = NumberOf1Between1AndN_Solution(10);
        System.out.println(i);
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        int temp = 0;
        for (int i = 1; i <=n ; i++) {
            int m = i;
            while (m>=1){
                temp = m %10;
                m = m/10;
                if (temp==1){
                    count++;
                }
            }
        }
       return count;
    }
}
