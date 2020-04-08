package ByteDance;

import java.util.Arrays;
import java.util.Scanner;

public class P_ArrayMax {
    /**
     * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），
     * 则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
     * 如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
     * 输入描述:
     * 第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
     * 对于 50%的数据, 1 <= N <= 10000;
     * 对于 100%的数据, 1 <= N <= 500000;
     * 输出描述:
     * 输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。
     * 输入例子1:
     * 5
     * 1 2
     * 5 3
     * 4 6
     * 7 5
     * 9 0
     * 输出例子1:
     * 4 6
     * 7 5
     * 9 0
     * 解题思路：只要满足Y从大到小排序同时当前Y对应的X的值小于下一个Y对应的X值即满足条件
     */
    static class Node implements Comparable<Node>{
            int x;
            int y;
            @Override
            public int compareTo(Node o) {
//                return this.y > o.y ? -1 : (this.y == o.y ? 0 : 1);
                return o.y-this.y;  //对Y从大到小排序
            }
        }
    public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                int num = scan.nextInt();
                Node[] nodes = new Node[num];
                for (int i = 0; i < num; i++) {
                    Node node = new Node();
                    node.x = scan.nextInt();
                    node.y = scan.nextInt();
                    nodes[i] = node;
                }
                Arrays.sort(nodes);
                int minX = Integer.MIN_VALUE;
                for (Node node : nodes) {
                    if (node.x > minX) {
                        minX = node.x;
                        System.out.println(node.x + " " + node.y);
                    }
                }
            }
}
/**
运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
case通过率为60.00%*/