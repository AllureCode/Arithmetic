package java_dataStructure.TenCommonAlgorithms;


import java.util.Arrays;

/**
 * 普里姆算法解决修路问题【最小生成树】
 *
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
     char[]data = new char[]{'A','B','C','D','E','F','G'};
     int[][]weight = new int[][]{
             {10000,5,7,10000,10000,10000,2},
             {5,10000,10000,9,10000,10000,3},
             {7,10000,10000,10000,8,10000,10000},
             {10000,9,10000,10000,10000,4,10000},
             {10000,10000,8,10000,10000,5,4},
             {10000,10000,10000,4,5,10000,6},
             {2,3,10000,10000,4,6,10000}
     };
     Graph graph = new Graph(data.length);
     MinTree minTree = new MinTree();
     minTree.createGraph(graph, data.length, data, weight);
     minTree.showGraph(graph);
     //测试
        minTree.primAlgorithm(graph, 0);
    }
}

//创建图
class MinTree{
    public void createGraph(Graph graph,int verxs,char[]data,int[][]weight){
            int i,j;
            for (i=0;i<verxs;i++){
                graph.data[i] = data[i];
                for (j=0;j<verxs;j++){
                    graph.weight[i][j] = weight[i][j];
                }
            }
    }
    //prim算法
    public  void primAlgorithm(Graph graph,int v){
        //存储访问过的节点
        int visited[] = new int[graph.verxs];
        visited[v] = 1;
        //h1 h2记录两个顶点下标
        int h1=-1,h2=-1;
        int minWeight = 10000;
        //因为有 graph.verxs个顶点 prim结束后有 graph.verxs-1条边
        for (int i = 1; i < graph.verxs; i++) {
            //此循环是确定每一次生成的子图和那个节点的距离最近
            for (int j = 0; j <graph.verxs ; j++) { //j表示访问过的节点
                for (int k = 0; k <graph.verxs ; k++) { //k表示未访问过的节点
                    if (visited[j]==1 && visited[k]==0 && graph.weight[j][k]<minWeight){
                        minWeight = graph.weight[j][k];
                        h1=j;
                        h2=k;
                    }
                }
            }
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值："+minWeight);
            //将当前的节点标记为已经访问过
            visited[h2] = 1;
            //重新为minWeight赋值,进行下一次遍历
            minWeight=10000;
        }
    }

    public void showGraph(Graph graph){
        for (int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
}

class Graph{
    int verxs;//表示图的节点个数
    char[] data;//存放节点的数据
    int[][] weight;//存放邻接矩阵

    public Graph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight=new int[verxs][verxs];
    }
}
