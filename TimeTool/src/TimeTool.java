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
     * @param year int
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

    /**
     * countFirstDay : 計算該年該月（user輸入）第一天是星期幾
     * 基姆拉爾森計算公式：
     * W = (1+2*month+3*(month+1)/5+year+year/4-year/100+year/400+1)%7
     * @param year
     * @param month
     * @return firstDay 該年該月第一天是星期幾
     */
    public static int countFirstDay(int year,int month){
        //需要將1月和2月看作上一年的13月和14月
        if(month == 1 || month == 2){
            month += 12;
            year--;
        }
        int firstDay = (1 + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7;
        return firstDay;
    }

    /**
     * countEndDays : 計算該年該月（user輸入）有多少天
     * 1 3 5 7 8 10 12月有31天，4 6 9 11有30天,閏年2月29天,非閏年2月28天
     * @param year int
     * @param month int
     * @return endDay int 返回計算後的該月天數
     */
    public static int countEndDays(int year,int month){
        int endDay;
        if(isLeapYear(year) && month == 2)  //閏年且為2月
            endDay = 29;
        else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            endDay = 31;
        else if(month == 4 || month == 6 || month == 9 || month == 11)
            endDay = 30;
        else
            endDay = 28;
        return endDay;
    }

    /**
     * printCal : print出萬年曆
     * @param firstDay
     * @param endDay
     */
    public static void printCal(int firstDay, int endDay){
        int i, j;
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");  //日曆頭部
        for (i = 0; i < firstDay; i++){
            System.out.print("    ");
        }
        for (j = 1; j <= endDay; ++j){
            if(j > 0 & j < 10){
                System.out.print(" " + j + "  ");   //j為個位數時前面要多一個空格
            }
            else{
                System.out.print(j + "  ");
            }
            if((firstDay + j) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    /**
     * showCalendar : 顯示萬年曆
     * @param inputYear
     * @param inputMonth
     */
    public static void showCalendar(String inputYear, String inputMonth){
        try {
            int Year = Integer.parseInt(inputYear);
            int Month = Integer.parseInt(inputMonth);

            if(Year <= 0 || Month < 0 || Month > 12){
                System.out.println("請輸入正確的年份和月份");
            }else{
                int firstDay = countFirstDay(Year,Month);
                int endDay = countEndDays(Year,Month);
                printCal(firstDay,endDay);
            }
        }
        catch (Exception e) {
            System.out.println("請輸入數字！");
        }
    }
}
