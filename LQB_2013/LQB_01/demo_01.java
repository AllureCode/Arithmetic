package LQB_2013.LQB_01;

import java.util.Calendar;

/**
 * 世纪末问题
 * 曾有邪教称1999年12月31日是世界末日。当然该谣言已经不攻自破。
 *
 * 还有人称今后的某个世纪末的12月31日，如果是星期一则会....
 *
 * 有趣的是，任何一个世纪末的年份的12月31日都不可能是星期一!!
 *
 * 于是，“谣言制造商”又修改为星期日......
 *
 * 1999年的12月31日是星期五，请问：未来哪一个离我们最近的一个世纪末年（即xx99年）的12月31日正好是星期天（即星期日）？
 *
 * 请回答该年份（只写这个4位整数，不要写12月31等多余信息）
 * 测试代码
 */
public class demo_01 {
    public static void main(String[] args) {
        int year=0;
        Calendar calendar = Calendar.getInstance();
        for ( year=1999;;year+=100) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, 11);
            calendar.set(Calendar.DATE, 31);
            if(calendar.get(Calendar.DAY_OF_WEEK)==1){
                break;
            }
        }
        System.out.println(year);
    }
}
