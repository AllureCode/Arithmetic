package jianNanOffer;
import java.util.Arrays;
/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-20 17:56
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * * 解题思路：
 * * 先将整型数组转换成String数组，然后将String数组排序，最
 * 后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * * 排序规则如下：
 * * 若ab > ba 则 a > b，
 * * 若ab < ba 则 a < b，
 * * 若ab = ba 则 a = b；
 * * 解释说明：
 * * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
 **/
public class JZ32 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 32, 321};
        String s = PrintMinNumber(arr);
        System.out.println(s);
    }

    public static String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0) {
            return "";
        }
        String[] str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        //给str数组进行排序
        Arrays.sort(str,( o1, o2)-> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        });
//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String s1 = o1 + o2;
//                String s2 = o2 + o1;
//                return s1.compareTo(s2);
//            }
//        });
        for (int i = 0; i < str.length ; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
