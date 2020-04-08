package jianNanOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class demo_01 {
    public static void main(String[] args) {

    }

    /*采用暴力法
     * @param target
     * @param array
     * @return
     * 运行时间164ms
     * 占内存17420k
     */
    public static boolean Find(int target, int[][] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                if (array[i][j] == target)
//                    return true;
//            }
//        }
//        return false;
        for(int[] a:array){
            for(int j:a){
                if(j==target)
                    return true;
            }
        }
        return false;
    }

}
