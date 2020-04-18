package java_dataStructure.TenCommonAlgorithms;

/**
 * 字符串匹配算法
 */
public class KMP {
    public static void main(String[] args) {
        int sss = violenceMatch("1231assdss1sss", "sss");
        System.out.println(sss);
        int i = kmpSearch("1231assdss1sss", "sss", kmpNext("sss"));
        System.out.println(i);

    }
    /**
     *
     * @param s1 原始字符串
     * @param s2 待匹配字符串
     * @return
     */
    public static int violenceMatch(String s1,String s2){
        char[] s1Length = s1.toCharArray();
        char[] s2Length = s2.toCharArray();
        int i=0,j=0;
        while (i<s1Length.length && j<s2Length.length){
            if (s1Length[i]==s2Length[j]){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if (j==s2Length.length){
            return i-j;
        }
        return -1;
    }
    /**
     * KMP算法求匹配字符串
     */

    public static int kmpSearch(String str,String str2,int[]next){
        //遍历原始串
        for (int i = 0,j=0; i <str.length() ; i++) {
            while (j>0 &&str.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String dest){
        //创建一个和目标串大小一致的数组
        int[] next = new int[dest.length()];
        //如果字符串长度为1 则next[0]=0
        next[0]=0;
        for (int i = 1,j=0; i < dest.length() ; i++) {
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
