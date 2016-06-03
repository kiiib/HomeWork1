import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jianbin Liu on 6/3/2016.
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(){

    }

    private void setHour(int hour){
        this.hour = hour;
    }
    private void setMinute(int minute){
        this.minute = minute;
    }
    private void setSecond(int second){
        this.second = second;
    }

    public void createAlarm(String input) throws TimeFormatException {
        if(!input.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")){
            throw new TimeFormatException("�п�J���T�榡�I XX:YY:ZZ\n");
        }else if(!input.matches("[0-1]{1}[0-9]{1}:[0-9]{2}:[0-9]{2}") && !input.matches("[2]{1}[0-3]{1}:[0-9]{2}:[0-9]{2}")){
            throw new TimeFormatException("TimeFormatException: Hour�榡���~\n");
        }else if(!input.matches("[0-9]{2}:[0-5]{1}[0-9]{1}:[0-9]{2}")){
            throw new TimeFormatException("TimeFormatException: Minute�榡���~\n");
        }else if(!input.matches("[0-9]{2}:[0-9]{2}:[0-5]{1}[0-9]{1}")){
            throw new TimeFormatException("TimeFormatException: Second�榡���~\n");
        }
        setTime(input);
        printStartTime();
    }

    /**
     * set the input to correct format
     * @param input int
     */
    public void setTime(String input){
        String time[] = input.split(":");
        setHour(Integer.parseInt(time[0]));
        setMinute(Integer.parseInt(time[1]));
        setSecond(Integer.parseInt(time[2]));
    }

    public void printStartTime(){
        int afterHour = 0;
        int afterMinute = 0;
        Date now = new Date();
        SimpleDateFormat hourDateFormat = new SimpleDateFormat("HH");
        SimpleDateFormat minuteDateFormat = new SimpleDateFormat("mm");

        int currentHour = Integer.parseInt(hourDateFormat.format(now)); // the hour of current time
        int currentMinute = Integer.parseInt(minuteDateFormat.format(now)); // the minute of current time

            if(currentMinute < this.minute){
                afterHour = 0;
                afterMinute = this.minute - currentMinute;
            }else if(currentMinute > this.minute){
                afterHour = 23;
                afterMinute = 60 - currentMinute;
            }else{
                afterHour = 0;
                afterMinute = 0;
            }
            if(currentMinute < this.minute){
                afterHour = this.hour - currentHour;
                afterMinute = this.minute - currentMinute;
            }else if(currentMinute > this.minute){
                afterHour = 0;
                afterMinute = 60 - currentMinute + this.minute;
            }else{
                afterHour = this.hour - currentHour;
                afterMinute = 0;
            }
            if(currentMinute < this.minute){
                afterHour = (24 - currentHour) + this.hour;
                afterMinute = this.minute - currentMinute;
            }else if(currentMinute > this.minute){
                afterHour = (24 - currentHour) + this.hour - 1;
                afterMinute = 60 - currentMinute + this.minute;
            }else{
                afterHour = (24 - currentHour) + this.hour;
                afterMinute = 0;
            }
        }

       System.out.printf("�w�N�x���]�w�b%d�p�ɤS%d������Ұ�\n", afterHour, afterMinute);
    }
}
