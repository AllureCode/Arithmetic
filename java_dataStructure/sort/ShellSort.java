package java_dataStructure.sort;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {

        int arr[] = {1, 8, 2, 6, 7, 5, 4};
        //   shellSort1(arr);
        shellSort2(arr);
    }
    //采用交换法
    public static void shellSort1(int[] arr) {
        int temp = 0;
        for (int group = arr.length / 2; group > 0; group /= 2) {
            for (int i = group; i < arr.length; i++) {
                for (int j = i - group; j >= 0; j -= group) {
                    if (arr[j] > arr[j + group]) {
                        temp = arr[j];
                        arr[j] = arr[j + group];
                        arr[j + group] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //移位法
    public static void shellSort2(int[] arr) {
        for (int group = arr.length / 2; group > 0; group /= 2) {
            for (int i = group; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - group]) {
                    while (j - group >= 0 && temp < arr[j - group]) {
                        arr[j] = arr[j - group];
                        j -= group;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
