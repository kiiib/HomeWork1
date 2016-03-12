/**
 * Created by Jianbin Liu on 2016/3/10.
 */
import java.util.Date;

public class TimeTool {
    /**
     *  showCurrentTime: 顯示目前的時間
     */
    public static void showCurrentTime(){
        Date now = new Date();  //建立Date物件會記錄目前的時間（初始化）
        System.out.println(now);    //直接引出Date物件所記錄的時間資訊
    }

    /**
     * isLeapYear: 判斷指定年份是否為閏年
     *
     * @param int year
     * @return boolean
     */
    public static boolean isLeapYear(int year){
        boolean isLeapYear = false;

        /**
         * 判斷是否為閏年的規則如下，滿足其中一個即為閏年：
         * 1.西元年是 4 的倍數， 但不是 100的倍數， 例如1996年
         * 2.西元年是 400 的倍數， 例如： 2000年
         */
        if ((year % 4) == 0 && (year % 100) !=0 || (year % 400) == 0)
            isLeapYear = true;

        return isLeapYear;
    }
}
