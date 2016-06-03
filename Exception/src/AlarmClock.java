/**
 * Created by Jianbin Liu on 6/3/2016.
 */

import java.util.Date;
import java.util.Scanner;
public class AlarmClock{

    public static void main(String[] args){
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.start();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();
        do{
            try {
                System.out.println(date.toString());    //show current time
                System.out.print("請設定鬧鐘時間(HH:mm:ss): ");
                String input = scanner.next();
                Time time = new Time();
                time.createAlarm(input);
            }catch (TimeFormatException e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }

}
