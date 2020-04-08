package java_dataStructure.Knapsack01;

/**
 * 01背包问题 涉及动态规划
 * 重    价值        背包空间20
 * 2     3
 * 3     4
 * 4     5
 * 5     8
 * 9     10
 */
public class Knapsack {
    private final static int N = 6;
    private final static int W = 21;
    private final static int[][] B = new int[N][W];
    public static void main(String[] args) {
        knapsack();
        System.out.println(B[5][20]);
    }
    public static void knapsack() {
        int[] w = {0, 2, 3, 4, 5, 9};
        int[] v = {0, 3, 4, 5, 8, 10};
        int k, c;
        for (k = 1; k < N; k++) {
            for (c = 1; c < W; c++) {
                if (w[k] > c) {
                    B[k][c] = B[k - 1][c];
                } else {
                    int value1 = B[k - 1][c - w[k]] + v[k];
                    int value2 = B[k - 1][c];
                    if (value1 > value2) {
                        B[k][c] = value1;
                    } else {
                        B[k][c] = value2;
                    }
                }
            }
        }
    }
}
