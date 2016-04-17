/**
 * Created by Jianbin Liu on 4/9/2016.
 */
import java.util.Scanner;

public class TimeLengthTest {
    static TimeLength userTime = new TimeLength();
    static Scanner scanner = new Scanner(System.in);
    static String input = new String();
    static String time = new String();

    public static void main(String args[]){
        do{
            showMenu();
            input = scanner.next();
            if(input.matches("[0-3]")){
                int num = Integer.parseInt(input);
                switch (num){
                    case 1:
                        setLengthTime();
                        break;
                    case 2:
                        AdjustLengthTime();
                        break;
                    case 3:
                        showLengthOfDiffUnit();
                        break;
                }
                System.out.println();
            }
            else{
                System.out.println("Please enter a valid number.\n");
            }
        }while (!input.equals("0"));

    }

    /**
     * showMenu
     */
    public static void showMenu(){
        System.out.println("***Convert Length of Time***");
        System.out.println("1) Set a length of time.");
        System.out.println("2) Adjust the Length of time.");
        System.out.println("3) Show length of time in different units.");
        System.out.println("0) Exit");
        System.out.println();
        System.out.print("Please enter a number in [1,2,3,0]:");
    }

    /**
     * set the time in second or hh:mm:ss
     */
    public static void setLengthTime(){
        System.out.print("Please enter a time <seconds or hh:mm:ss>: ");
        time = scanner.next();
        if(time.matches("([01]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)")){
            System.out.println("Time:" + time);
            String[] units = time.split(":");
            int hours = Integer.parseInt(units[0]);
            int minute = Integer.parseInt(units[1]);
            int second = Integer.parseInt(units[2]);
            userTime.setTime(hours, minute, second);
        }else if(time.matches("[0-9]+")){
            System.out.println("Time:" + time);
            userTime.setTime(Integer.parseInt(time));
        }
    }

    /**
     * adjust the time
     */
    public static void AdjustLengthTime(){
        int hours;
        int minute;
        int second;
        System.out.print("Please enter a time <seconds or hh:mm:ss>: ");
        time = scanner.next();
        if(time.matches("([-]?[01]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)")){
            System.out.println("Time:" + time);
            String[] units = time.split(":");
            if(time.matches("([01]?\\d|2[0-3]):([0-5]?\\d):([0-5]?\\d)")){
                hours = Integer.parseInt(units[0]);
                minute = Integer.parseInt(units[1]);
                second = Integer.parseInt(units[2]);
            }else{  // if have "-"
                hours = Integer.parseInt(units[0]);
                minute = - + Integer.parseInt(units[1]);
                second = - + Integer.parseInt(units[2]);
            }
            userTime.adjustTime(hours, minute, second);
        }else if(time.matches("[-]?[0-9]+")){
            System.out.println("Time:" + time);
            userTime.adjustTime(Integer.parseInt(time));
        }
    }

    /**
     * show the length
     */
    public static void showLengthOfDiffUnit(){
        System.out.println("The current length of time <seconds>: " + userTime.getTime());
        System.out.println("The current length of time <hh:mm:ss>: " + userTime.getTimeInHMS());
    }

}
