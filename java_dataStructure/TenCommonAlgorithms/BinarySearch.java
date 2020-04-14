package java_dataStructure.TenCommonAlgorithms;


/**
 * binary Search：Non-recursive implementation
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(binarySearchNoRecursionImplement(arr, 1));
    }

    /**
     * @param arr
     * @param sNumber :The data to look up
     * @return
     */
    public static int binarySearchNoRecursionImplement(int[] arr, int sNumber) {
        int mid ;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == sNumber) {
                return mid;
            } else if (arr[mid] < sNumber) {
                left = mid + 1;
            } else if (arr[mid] > sNumber) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
