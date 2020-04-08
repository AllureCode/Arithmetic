package jianNanOffer;

/**
 * 请实现一个函数，
 * 将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *运行时间20ms
 *占内存9697k
 */
public class demo_02 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We Are Happy");
        System.out.println( new demo_02().replaceSpace(stringBuffer));
    }
    public String replaceSpace(StringBuffer str) {
        String s="";
        char[] chars = str.toString().toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]==' '){
                s+="%20";
            }else {
                s+=chars[i];
            }
        }
        return s;
    }
}
