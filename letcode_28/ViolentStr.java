package letcode_28;

/**
 *暴力求解
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class ViolentStr {
    public static void main(String[] args) {
        System.out.println(VioleStr("hello","ll"));
    }
    public static int VioleStr(String haystack, String needle){
        int i=0,j=0;
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();
        while(i<haystack.length() && j<needle.length()){
            if(chars[i]==chars1[j]){
                i++;
                j++;
            }else{
                i=i-j+1;
                j=0;
            }
        }
        if(j==needle.length()){
            return i-j;
        }else
        return -1;
    }
}
