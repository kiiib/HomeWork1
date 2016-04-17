/**
 * Created by Jianbin Liu on 4/9/2016.
 */
public class TimeLength {
    private int time;

    public TimeLength(){
        time = 0;
    }

    // set the time, parameter is the second
    public void setTime(int time){
        this.time = time;
    }

    // set the time, parameter is the hour, minute, second
    public void setTime(int hour, int minute, int second){
        int time = convertToSeconds(hour, minute, second);
        this.time = time;
    }

    /**
     * convertToSeconds
     * @param hour hour
     * @param minute minute
     * @param second second
     * @return double
     */
    public int convertToSeconds(int hour, int minute, int second){
        return (hour * 3600) + (minute * 60) + second;
    }

    //adjust the time, parameter is the second
    public void adjustTime(int time){
        this.time += time;
    }

    //adjust the time, parameter is the hour, minute, second
    public void adjustTime(int hour, int minute, int second){
        adjustTime(convertToSeconds(hour, minute, second));
    }

    /**
     * getTime
     * @return int(time)
     */
    public int getTime(){
        return time;
    }

    /**
     * getTimeInHMS
     * @return string(time)
     */
    public String getTimeInHMS(){
        String sHour, sMinute, sSecond;

        int hour =  this.time / 3600;
        sHour = Integer.toString(hour);

        if((sHour.contains("-"))){
            sHour = sHour.substring(1, sHour.length());
            if (sHour.length() == 1)
                sHour = "0" + sHour;
            sHour = "-" + sHour;
        }
        if (sHour.length() == 1){
            sHour = "0" + sHour;
        }

        int minute = (this.time - (hour * 3600)) / 60;
        sMinute = Integer.toString(minute);
        if((sMinute.contains("-"))){
            sMinute = sMinute.substring(1, sMinute.length());     //delete the "-" and put it in the hour
            if(!(sHour.contains("-"))){
                sHour = "-" + sHour;
            }
        }
        if (sMinute.length() == 1){
            sMinute = "0" + sMinute;
        }

        int second = this.time - (hour * 3600) - (minute * 60);
        sSecond = Integer.toString(second);
        if((sSecond.contains("-"))){
            sSecond = sSecond.substring(1, sSecond.length());   //delete the "-" and put it in the hour
            if(!(sHour.contains("-"))){
                sHour = "-" + sHour;
            }
        }
        if (sSecond.length() == 1){
            sSecond = "0" + sSecond;
        }

        return sHour + ":" + sMinute + ":" + sSecond;
    }

}
