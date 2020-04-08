package java_dataStructure.recursion;

/**
 * 利用递归算法解决迷宫问题
 */
public class Maze {
    public static void main(String[] args) {
        //先定义一个二位数组 用1表示墙 0表示没有走过的路 2表示当前路可通 3表示不可通
        int[][] maze = new int[8][7];
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
        System.out.println("原始迷宫:");
        for (int[] ma : maze) {
            for (int m : ma) {
                System.out.print("\t" + m);
            }
            System.out.println();
        }
        boolean way = getWay(maze, 1, 1);
        int k=0;
        if (way) {
            System.out.println("找到出路");
            for (int[] ma : maze) {
                for (int m : ma) {
                    if(m==2){
                        k++;
                    }
                    System.out.print("\t" + m);
                }
                System.out.println();
            }
            System.out.println("所走的步数："+k);
        } else {
            System.out.println("未找到出路");
        }
    }
    //找寻路径的方法(下右上左)
    public static boolean getWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) { //找到出路
            return true;
        } else {
            //当前路径是是否没走过
            if (maze[i][j] == 0) {
                maze[i][j] = 2; //假设可以走通

               if (getWay(maze, i + 1, j)) {
                    return true;
                } else if (getWay(maze, i, j + 1)) {
                    return true;
                } else if (getWay(maze, i - 1, j)) {
                    return true;
                } else if (getWay(maze, i, j - 1)) {
                    return true;
                } else {
                    maze[i][j] = 3;
                    return false;
                }
            } else { //maze[i][j]!=0 可取 1 2 3
                if (maze[i][j]==2) //如果为2 返回true
                    return true;
                else {
                    return false;  //其他返回false
                }
            }
        }
    }
}
