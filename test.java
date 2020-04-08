public class test {
    public static void main(String[] args) {
        int d=0; int i=0,j=0;
        while(d<4) {
            switch (d) {
                case 0: i=i+1;j=j;break;
                case 1: i=i-1;j=j;break;
                case 2: i=i;j=j+1;break;
                case 3: i=i;j=j-1;break;
            }
            System.out.println(i+":"+j);
            d++;
        }

    }
}
