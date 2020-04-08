package java_dataStructure.recursion;


/**
 * 八皇后问题
 */
public class EightQueen {
    int max = 8; //定义皇后的最大个数
    int[] array = new int[max];
    static  int count=0; //统计解法
    public static void main(String[] args) {
        /*使用一个一维数模拟棋盘
          因为八皇后中放置皇后的顺序为：第一个先放第一行第一列 然后放第二个在第二行...
          而我们定义的形如array[8]={0，1，7，0，0，0，0，0}刚好满足行列对正
          array[0]=0代表第一个皇后放在第一行第一列 array[1]=1代表第二个皇后放在第二行第2个位置
          当然每一个array[]= 可以有0 1 2 3 4 5 6 7 取法
          就可以将二维数组简化为一个一维数组 int []array = new int[max]
         */
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
        System.out.println("一共"+count+"解法");

    }

    /**
     * 检查当前放置的皇后是否会出现冲突 如果出现则回溯
     *
     * @param n 放置第n个皇后
     */
    private void check(int n) {
        if (n == max) {//把第8个皇后放置完成没有出现冲突
            printQueen();//打印
            return;
        }
        //依次放入皇后检查是否冲突
        for (int i = 0; i < max; i++) {
            //当前皇后从第01234567开始放置
            array[n] = i;
            if (judge(n)){ //不冲突
                check(n+1);//开始检查后一个皇后
            }
            //如果冲突 则会执行array[n]=i即判断当前皇后是否可以放置本行的下一个位置
        }
        n--;  //不满足条件 n-- 产生回溯到上一个皇后位置
    }

    /**
     * 判断放置当前位置是否产生冲突
     *
     * @param n 第n个皇后(实际为n-1皇后因为数组是从0开始)
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            /*
              array[]={0,1,2,3,4,5,6,7}表示第一个皇后放第一行第一列 第二个皇后放第二行第2列...
              array[i]== array[n]表示判断第n个皇后和前面的n-1个皇后是否在同一行
              Math.abs(n-i)==Math.abs(array[n]-array[i])判断第n个皇后是否和第i个在同一斜线
              例如：n=1(实际为第二个皇后) 放置第二行第某列(具体看数组array[n]的值 可取01234567)
             */
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //打印解法
    private void printQueen() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

}
