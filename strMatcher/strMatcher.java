package strMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 查找字符串在另外另字符串中出现的次数
 */
public class strMatcher {
    public static void main(String[] args) {

        System.out.println(strString("hello","o"));
    }
    /**
     * 利用正则
     * @param haystack
     * @param needle
     * @return
     */
    public static int strString(String haystack,String needle) {
        int count = 0;
        Pattern pattern = Pattern.compile(needle);
        Matcher matcher = pattern.matcher(haystack);
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
