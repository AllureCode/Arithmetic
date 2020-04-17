package java_dataStructure.TenCommonAlgorithms;
/**
 * 动态规划：
 * 背包问题
 */
public class dynamic_KnapsackProblem {
    public static void main(String[] args) {
        int w[] = { 1, 4, 3}; //物品重量
        int val[] = {1500, 3000, 2000}; //物品价值
        int m = 4;//背包容量
        int n = val.length;//商品的个数
        int[][] v = new int[n+1][m + 1];
        int[][] path = new int[n+1][m + 1];
        for (int i = 1; i <v.length ; i++) {
            for (int j = 1; j <v[0].length ; j++) {
                if (w[i-1]>j){
                    v[i][j] = v[i-1][j];
                }else {
                    int value1=v[i-1][j];
                    int value2 = val[i-1]+v[i-1][j-w[i-1]];
                    if (value1>value2){
                        v[i][j]=value1;
                    }else {
                        v[i][j]=value2;
                        path[i][j]=1;
                    }
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print("\t" + v[i][j]);
            }
            System.out.println();
        }
        //打印出背包中放入的商品
        int i=path.length-1;int j=path[0].length-1;
        while(j>0 && i>0){
            if (path[i][j]==1){
                System.out.println("第"+i+"商品放入背包");
                j-=w[i-1];
            }
            i--;
        }
    }
}
