package java_dataStructure.SparseArray;
/**
 * 稀疏数组
 */
public class sparseArray {
    public static void main(String[] args) throws Exception {
            /*
            创建一个11*11的二维数组
            0代表没有棋子 1代表黑子 2代表白子
           */
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        //输出原始的二位数组
        System.out.println("原始的二位数组:");
        for (int[] arr : chessArray) {
            for (int data : arr) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }
        /*
          遍历原始数组 得到稀疏数组大小
        */
        int sum = 0; //标记数组不为0的个数
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray.length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("转换为稀疏数组:");
        int count=0; //标记
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        for (int i = 0; i <chessArray.length ; i++) {
            for (int j = 0; j <chessArray.length ; j++) {
                if(chessArray[i][j] != 0 ){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArray[i][j];
                }
            }
        }
        for (int[] arr:sparseArr){
            for (int data:arr){
                System.out.print("\t"+data);
            }
            System.out.println();
        }
        System.out.println("将稀疏数组进行还原:");
        int newChessArray[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <sparseArr.length;i++) {
            newChessArray[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int[] arr:newChessArray){
            for (int data:arr){
                System.out.print("\t"+data);
            }
            System.out.println();
        }
    }
}
