package java_dataStructure.sort;

import java.util.Arrays;


/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2,8,2};
        int tempArr[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1, tempArr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr     原始数组
     * @param left    最左边索引
     * @param right   最右边索引
     * @param tempArr 临时数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        //中间值 用来区分左右两边的值(左边的小于中间值 右边的大于中间值)
        if (left < right) {
            int mid = (left + right) / 2;
            //左递归分解
            mergeSort(arr,left,mid,tempArr);
            //右递归分解
            mergeSort(arr,mid+1,right, tempArr);
            //合并
            merge(arr, left,mid, right, tempArr);
        }
    }
    //合并方法
    public static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        int t = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j<=right) {
            if (arr[i] <= arr[j]) {
                tempArr[t] = arr[i];
                t++;
                i++;
            } else {
                tempArr[t] = arr[j];
                j++;
                t++;
            }
        }
        //将左边剩余的值填充到临时数组
        while (i <= mid) {
            tempArr[t] = arr[i];
            i++;
            t++;
        }
        //将右边剩余的值填充到临时数组
        while (j <= right) {
            tempArr[t] = arr[j];
            j++;
            t++;
        }
        t = 0;
        int tempIndex=left;
        while (tempIndex <= right) {
            arr[tempIndex] = tempArr[t];
            t++;
            tempIndex++;
        }
    }
}
