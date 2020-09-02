package jianNanOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-09-01 10:33
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c
 * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 **/
public class JZ27 {
    public static void main(String[] args) {
        ArrayList<String> list = Permutation("abc");
        System.out.println(list);
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        char[] chars = str.toCharArray();
        HashSet perum = perum(chars, 0, chars.length - 1, hashSet);
        for (Object set : perum) {
            arrayList.add((String) set);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /**
     * 利用全排列思想 递归实现
     * @param chars
     * @param m
     * @param n
     * @param hashSet
     * @return
     */
    public static HashSet perum(char[] chars, int m, int n, HashSet<String> hashSet) {
        if (m == n) {
            StringBuilder s = new StringBuilder();
            for (int k = 0; k < chars.length; k++) {
                s.append(chars[k]);
            }
            hashSet.add(s.toString());
        }
        for (int i = m; i <= n; i++) {
            swap(chars, i, m);
            // 把剩下的元素都做全排列。
            perum(chars, m + 1, n, hashSet);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。
            swap(chars, i, m);
        }
        return hashSet;
    }

    /**
     * 交换函数
     */
    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
