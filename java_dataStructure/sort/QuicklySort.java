package java_dataStructure.sort;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;

/**
 * 快速排序
 */
public class QuicklySort {
    public static void main(String[] args) {
        int arr[] = {-9, 11, 5, 0, -8, -9,0,11,5,99,-9, 0};
        quicklySort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicklySort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(r + l) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < mid) {
                l++;
            }
            while (arr[r] > mid) {
                r--;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //说明左边值全部小于等于中间值 右边值已经大于等于中间值
            if (l>=r){
                break;
            }
            if (arr[l] == mid) {
                r--;
            }
            if (arr[r] == mid) {
                l++;
            }
        }
        //如果l==r 必须r-- l++否则为栈溢出
        if (l == r) {
            r--;
            l++;
        }
        //左递归
        if (left < r) {
            quicklySort(arr, left, r);
        }
        //右递归
        if (right > l) {
            quicklySort(arr, l, right);
        }

    }
}
