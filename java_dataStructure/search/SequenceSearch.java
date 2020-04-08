package java_dataStructure.search;

/**
 * 顺序查找
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        System.out.println(sequenceSearch(arr,4));
    }
    public static int sequenceSearch(int[]arr,int n){
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==n){
                return i;
            }
        }
        return -1;
    }
}
