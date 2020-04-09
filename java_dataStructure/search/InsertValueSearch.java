package java_dataStructure.search;

/**
 * 插值查找
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 80));
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        if (left > right || arr[0] > findValue || arr[arr.length - 1] < findValue) {
            return -1;
        }
        //插值查找的索引计算公式(自适应)
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] == findValue) {
            return mid;
        } else if (arr[mid] < findValue) {
            //向右递归
            return insertValueSearch(arr, mid + 1, right, findValue);
        } else if (arr[mid] > findValue) {
            //左递归
            return insertValueSearch(arr, left, mid - 1, findValue);
        } else {
            return -1;
        }
    }
}
