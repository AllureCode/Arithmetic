package Demo;

public class Demo_1 {
    /**
     * 5281. 使结果不超过阈值的最小除数
     * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，
     * 并对除法结果求和。
     * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个
     输入：nums = [1,2,5,9], threshold = 6
     输出：5
     解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
     如果除数为 2 ，我们可以得到和为 7 (1+1+2+3) 。
     如果除数为 5 ，和为 5 (1+1+1+2)。
     */
        public  static void main(String[] args){
            int nums[]={91,41,78,86,8};
            System.out.println(smallestDivisor(nums,114));
        }
        public  static int smallestDivisor(int[] nums, int threshold) {
            int result=0;int n=0;int i =0;int sum=0;
            if(nums.length==1){
                return (int)Math.ceil((double)nums[0]/(double)threshold);
            }else{
                for (int j = 0; j < nums.length; j++) {
                    n = nums[i];
                    result = result + (int) Math.ceil((double) nums[j] / (double) nums[i]);
                }
                while (result > threshold && i < nums.length - 1) {
                    sum = 0;
                    i++;
                    n = nums[i];
                    for (int j = 0; j < nums.length; j++) {
                        sum = sum + (int) Math.ceil((double) nums[j] / (double) nums[i]);
                    }
                    result = sum;
                }
            }
            return n;
        }
}
