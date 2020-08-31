package jianNanOffer;
import java.util.ArrayList;
/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-30 09:17
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 **/
public class JZ41 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(200);
        System.out.println(arrayLists);
        ArrayList<ArrayList<Integer>> arrayLists1 = FindContinuousSequence2(200);
        System.out.println(arrayLists1);
    }

    /**
     * 利用双指针法
     * 效率较高
     * 两个方法所设计思想都一样  可以将此方法看为方法一的优化
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        //left right 类似于一段区间 再此区间内寻找序列
        int left = 1;
        int right = 2;
        while (left<right){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int tempSum = (left + right) * (right - left + 1) / 2;
            if (tempSum==sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=left;i<=right;i++){
                    list.add(i);
                }
                arrayList.add(list);
                left++;
            }
            //如果当前区间内的值之和小于sum，那么right右移一下
            else if(tempSum<sum){
                right++;
            }else{
                //如果当前区间内的值之和大于sum，那么left右移一下
                left++;
            }
        }
        return arrayList;
    }

    /**
     * 此方法效率不高
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int i = 1;
        int j = 1;
        while (true) {
            j += 1;
            int temp = 0;
            /**
             * 此处for循环是为了找寻从i---->j 看是否又满足的序列
             */
            for (int l = i; l <= j; l++) {
                temp += l;
                /**
                 * 此处if判断：当我们找寻到i的值已经大于等于sum
                 * 可以知道没有满足的序列 直接退出循环将前面找到的序列返回即可
                 */
                if (i >= sum) {
                    return arrayList;
                }
                /**
                 * 如果temp==sum 可知有满足的序列
                 * 存储下i和l的值
                 * 因为从i--->l即是我们要找寻的序列之一
                 */
                if (temp == sum) {
                    int n = i;
                    int m = l;
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int k = n; k <= m; k++) {
                        list.add(k);
                    }
                    arrayList.add(list);
                    /**
                     *  System.out.println("i="+i+"<--->+"+"n="+n);
                     *  System.out.println("l="+l+"<--->+"+"m="+m);
                     * 找到其中满足的序列 重新给 i j赋值
                     * 继续寻找其余序列
                     */
                    i++;
                    j = i;
                    break;
                }
                /**
                 * 如果i---->j内没有满足的序列
                 * 重新给i j赋值
                 * 在新的i j范围内寻找
                 */
                if (temp > sum) {
                    i++;
                    j = i;
                    break;
                }
            }
        }

    }
}
