package java_dataStructure.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        //遍历原始数组 找到最大的数 然后获取到其长度 进行遍历长度-1次
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int maxLength = (max+"").length();
        /*定义一个二位数组 代表10个桶
          因为无法知道具体每个桶中存放的元素个数
          因此定义长度为arr.length采用空间换时间
         */
        int[][] bucket = new int[10][arr.length];
        //标记每个桶中的元素个数
        int[] bucketElement = new int[10];
        for (int m = 0 ,n=1; m <maxLength ; m++,n*=10) {
            for (int i = 0; i < arr.length; i++) {
                //取出每一个元素的个位
                int digit = arr[i] /n % 10;
                bucket[digit][bucketElement[digit]] = arr[i];
                bucketElement[digit]++;
            }
            //按照这个桶的顺序 将数据再次放入原始数组
            int index = 0;
            for (int j = 0; j < bucket.length; j++) {
                if (bucketElement[j] != 0) {
                    for (int l = 0; l < bucketElement[j]; l++) {
                        arr[index] = bucket[j][l];
                        index++;
                    }
                }
                //重新置初值方便后面重新计算
                bucketElement[j] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
