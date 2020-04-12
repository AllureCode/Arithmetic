package java_dataStructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序
    public static void heapSort(int[] arr) {
        int temp=0;
        //完成将一个数组转为一个大顶堆
        for (int i = arr.length/2-1; i >=0 ; i--) {
            arrToHeap(arr,i,arr.length);
        }
        //将堆顶元素与尾元素调换，将最大元素沉底
        for (int j =arr.length-1 ; j>0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行
           arrToHeap(arr,0, j);
        }

    }
    //将数组转换为一个大顶堆

    /**
     * @param arr
     * @param i      表示非叶子节点在数组中的索引
     * @param length
     */
    public static void arrToHeap(int[] arr, int i, int length) {
        int temp = arr[i]; //记录当前节点堆顶值
        //满足条件一直向左子节点找
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            //j+1<length用来判断是否越界
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++; //指向右子节点
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
