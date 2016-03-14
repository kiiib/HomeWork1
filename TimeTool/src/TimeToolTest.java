/**
 * Created by Jianbin Liu on 2016/3/10.
 */
import java.util.Scanner;
public class TimeToolTest {

    public static void main(String[] args){
        String input;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("***Main Menu***");
            System.out.println("1) Show the Current Time");
            System.out.println("2) Leap Year");
            System.out.println("3) Show the Calendar");
            System.out.println("0) Exit");
            System.out.println("");
            System.out.println("Please enter a number in [1,2,3,0]: ");

            input = scanner.next(); //獲取用戶輸入(String)
            int num = Integer.parseInt(input);  //型別轉換（Integer)

            switch (num) {
                case 1:
                    TimeTool.showCurrentTime();
                    break;
                case 2:
                    System.out.print("Please enter the number of years: ");
                    int year = scanner.nextInt();   //獲取用戶輸入（Integer）
                    if (TimeTool.isLeapYear(year))  //判斷指定年份是否為閏年
                        System.out.println(year + " is a leap year.");
                    else
                        System.out.println(year + " is not a leap year.");
                    break;
                case 3:
                    System.out.print("Year: ");
                    String inputYear = scanner.next();   //獲取用戶輸入（String）
                    System.out.print("Month: ");
                    String inputMonth = scanner.next();   //獲取用戶輸入（String）
                    TimeTool.showCalendar(inputYear,inputMonth); //顯示萬年曆
                    break;
            }

        }while (!input.equals("0"));    //若input不為0則繼續執行迴圈
    }
}
