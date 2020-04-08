package java_dataStructure.search;

import java.awt.event.AdjustmentEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 5, 6, 7, 8,9,9,9,10};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 9));
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 9);
        System.out.println(list.toString());
    }

    //无法查询相同元素的下标
    public static int binarySearch(int[] arr, int left, int right, int searchNumber) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        //递归推出条件 当left>right 说明没有找到
        if (left > right) {
            return -1;
        }
        if (midValue > searchNumber) {
            return binarySearch(arr, left, mid - 1, searchNumber);
        } else if (midValue < searchNumber) {
            return binarySearch(arr, mid + 1, right, searchNumber);
        } else {
            return mid;
        }
    }

    //返回所有相同元素的下标
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int searchNumber) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        //递归推出条件 当left>right 说明没有找到
        if (left > right) {
            return new ArrayList<>();
        }
        if (midValue > searchNumber) {
            return binarySearch2(arr, left, mid - 1, searchNumber);
        } else if (midValue < searchNumber) {
            return binarySearch2(arr, mid + 1, right, searchNumber);
        } else {
            /*
            当查询到mid时 不立刻返回
            在mid左右两边进行扫描 看是否有相同的元素
             */
            int temp = mid - 1;//左扫描
            List<Integer> list = new ArrayList<>();
            while (true) {
                if (temp < 0 || arr[temp] != searchNumber) {
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            list.add(mid); //加入中间值
            temp = mid + 1;  //右扫描
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != searchNumber) {
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            return list;
        }
    }
}
