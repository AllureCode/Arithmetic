package jianNanOffer;
import java.util.ArrayList;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-31 15:03
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *  2*x  3*y  5*z
 **/
public class JZ33 {
    public static void main(String[] args) {
        int i = GetUglyNumber_Solution(10);
        System.out.println(i);
    }
    public static int GetUglyNumber_Solution(int index) {
        //可知123456都是丑数 7不是
        if (index<7){
            return index;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int t2=0,t3=0,t5=0;
        while (list.size()<index){
            //找到初始的2 3 5
            int newT2 = list.get(t2)*2;
            int newT3 = list.get(t3)*3;
            int newT5 = list.get(t5)*5;
            //找出newT2 newT3 newT5中的最小值进入list
            int minT = findMin(newT2,newT3,newT5);
            list.add(minT);
            if (minT==newT2) {
                t2++;
            }
            if (minT==newT3) {
                t3++;
            }
            if (minT==newT5) {
                t5++;
            }
        }
        return list.get(list.size()-1);
    }

    /**
     * 找出三个数中的最小数
     * @param newT2
     * @param newT3
     * @param newT5
     * @return
     */
    private static Integer findMin(Integer newT2, Integer newT3, Integer newT5) {

        return newT2<(newT3<newT5?newT3:newT5)?newT2:(newT3<newT5?newT3:newT5);
    }

}

