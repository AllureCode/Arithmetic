package jianNanOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author wang_sir
 */
public class Demo_08 {
    public static void main(String[] args) {
        System.out.println(JumpFloor2(5));
    }

    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        /***
         *   1     1
         *   2     11 2
         *   3     111 12 21
         *   4     1111 112 121 211 22
         */
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /***
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public static int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        /**
         *   1     1               1  2  4  8  16
         *   2     11 2            1  2  3  4   5
         *   3     111 12 21 3
         *   4     1111 112 121 211 22 4 13 31
         */
        return 2*JumpFloor2(target - 1);
    }
}
