package jianNanOffer;

/**
 * @program: Arithmetic
 * @description:
 * @author: wang_sir
 * @create: 2020-08-20 10:46
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 保证base和exponent不同时为0
 **/
public class JZ12 {
    public static void main(String[] args) {
        double power = Power(2,3 );
        System.out.println(power);
    }
    public static double Power(double base, int exponent) {
        double result = 1.0D;
        if (base==0 && exponent==0){
            return -1;
        }if (exponent==0){
            return 1;
        }if (exponent < 0){
              exponent = (-1)*exponent;
            for (int i = 1; i <= exponent ; i++) {
                result = result*base;
            }
            return 1/result;
        }else {
            for (int i = 1; i <= exponent ; i++) {
                result = result*base;
            }
            return  result;
        }
    }
}
