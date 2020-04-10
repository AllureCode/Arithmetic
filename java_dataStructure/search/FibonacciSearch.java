package java_dataStructure.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {
    private final static int maxSize = 20;
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        System.out.println(feibonacciSearch(arr, 7));
    }

    //先获取到一个斐波那契数列作为查询基准
    public static int[] feibonacci() {
        int[] feibo = new int[maxSize];
        feibo[0] = 1;
        feibo[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            feibo[i] = feibo[i - 1] + feibo[i - 2];
        }
        return feibo;
    }

    //进行斐波那契查询
    public static int feibonacciSearch(int[] arr, int findValue) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int k = 0; //记录斐波那契分割点下标
        int F[] = feibonacci();
        /**
         * 例如我们数组长度为6 但是在斐波那契数列中只有F[5]=8-1=7才满足
         * 因此我们需要将k的值加到5 也就是斐波那契中F[5]的位置
         */
        while (high > F[k] - 1) {
            k++;
        }
        //拷贝元素数组到以斐波那契分割点为长度的数组中
        int temp[] = Arrays.copyOf(arr, F[k]);
        /*找到的长度并不一定大小刚好等于原始数组
         因此空出来的位置利用原始数组最后一个数填充
         例如：temp={1,2,3,4,5,0,0} =>temp={1,2,3,4,5,5,5}
         */
        for (int i = high + 1; i < temp.length; i++) {
           temp[i] = arr[high];
        }
        while (low<=high){
            mid = low+(F[k-1]-1);
            if (findValue<temp[mid]){
                //向左查询
                high = mid-1;
                /*
                 k--的原因：
                 全部元素 = 前半部分 + 后半部分
                 F[k]   =  F[K-1] + F[K-2]
                 即在F[k-1]还可以继续拆分 F[k-1]=F[K-2]+F[K-3]
                  与前面相差k--  下次循环mid=F[k-1-1]-1
                 */
                k--;
            }else if (findValue>temp[mid]){
                low=mid+1;
                /*
                 k-2的原因：
                 全部元素 = 前半部分 + 后半部分
                 F[k]   =  F[K-1] + F[K-2]
                 即在F[k-2]还可以继续拆分 F[k-2]=F[K-3]+F[K-4]
                  与前面相差k-2  下次循环mid=F[k-1-2]-1
                 */
                k-=2;
            }else {
                //找到
                if (mid<=high){
                    return mid;
                }else
                    return high;
            }
        }
        return -1;
    }
}
