import java.util.Scanner;

/**
 * Created by Jianbin Liu on 3/18/2016.
 */
public class GuestNumber {
    private int minValue = 0;   // the minimal number of the range
    private int maxValue = 0;   // the maximum number of the range
    private int guestTimes = 0; // the times of guess number
    private int[] playRecord;   // declare the playRecord array
    private int playerUseTimes = -1; // the times of player total use times
    private int guestNumber; //declare the number that player need to guest
    private boolean isWin = false; // if win status

    /**
     * Constructor, set the playRecord array each item value to 0
     *
     */
    public GuestNumber(){
        minValue = 0;
        maxValue = 0;
        guestTimes = 0;

        playRecord = new int[1];
        for(int i = 0; i < playRecord.length; i++)
            playRecord[i] = 0;
    }

    /**
     * setMinValue : set the minimal number
     * @param value the minimal number(String)
     */
    public void setMinValue(String value){
        try{
            minValue = Integer.parseInt(value);
        }
        catch (Exception e){
            System.out.println("Please enter number!!!!");
        }
    }

    /**
     * getMinValue: return the minimal number
     * @return minValue(int)
     */
    public int getMinValue(){
        return minValue;
    }

    /**
     * setMaxValue : set the maximum number
     * @param value the maximum number(String)
     */
    public void setMaxValue(String value){
        try{
            maxValue = Integer.parseInt(value);
        }
        catch (Exception e){
            System.out.println("Please enter number!!");
        }
    }

    /**
     * getMaxValue: return the maximum number
     * @return maxValue(int)
     */
    public int getMaxValue(){
        return maxValue;
    }

    /**
     * setGuestTimes : set the player guest time
     * @param value the the player guest time(String)
     */
    public void setGuestTimes(String value){
        try{
            guestTimes = Integer.parseInt(value);
            playRecord = new int[guestTimes];
            for(int i = 0; i < playRecord.length; i++)
                playRecord[i] = 0;
        }
        catch (Exception e){
            System.out.println("Please enter number!!!");
        }
    }

    /**
     * getGuestTimes: return the minimal number
     * @return guestTimes(int)
     */
    public int getGuestTimes(){
        return guestTimes;
    }

    public void setPlayRecord(int i, String value){
        try{
            playRecord[i] = Integer.parseInt(value);
        }
        catch (Exception e){
            System.out.println("Please enter number!");
        }
    }

    /**
     * create the variable of the number that player need to guest
     */
    public void createGuestNumber(){
        // the number of the player need to guest
        guestNumber = (int)(Math.random() * (maxValue - minValue + 1) + minValue);
    }

    /**
     * the guest program
     * @param playTimes the player can play times
     * @param playerNumber the player choose the number to guest
     * @return boolean
     */
    public boolean guest(int playTimes, int playerNumber){
        String output;
        if(playerNumber == guestNumber){
            System.out.println("恭喜!你猜對了!");
            isWin = true;
            playerUseTimes = playTimes;
            return false;
        }else if (playerNumber < guestNumber){
            System.out.println("猜錯了,你猜的數字比答案小!");
            minValue = playerNumber;
            if(playTimes != guestTimes){
                output = "數字範圍: %d ~ %d\n";
                System.out.printf(output, minValue, maxValue);
            }
            playerUseTimes = playTimes;
            return true;
        }else if(playerNumber > guestNumber){
            System.out.println("猜錯了,你猜的數字比答案大!");
            maxValue = playerNumber;
            if(playTimes != guestTimes) {
                output = "數字範圍: %d ~ %d\n";
                System.out.printf(output, minValue, maxValue);
            }
            playerUseTimes = playTimes;
            return true;
        }
        playerUseTimes = playTimes;
        return true;
    }

    public void createGame(){
        String input;   // the value of player entering
        Scanner scanner = new Scanner(System.in);
        String output;

        do{
            System.out.println("******** 猜數字遊戲 ********");
            System.out.print("猜數字範圍最小值:");
            setMinValue(scanner.next());// set the minValue

            System.out.print("猜數字範圍最大值:");
            setMaxValue(scanner.next());    // set the maxValue

            System.out.print("猜數字次數限制:");
            setGuestTimes(scanner.next());    // set the guest time

            System.out.println("******** 遊戲開始 ********");
            output = "數字範圍: %d ~ %d\n";
            System.out.printf(output, minValue, maxValue);
            createGuestNumber();

            for (int i = 0; i < guestTimes; i++){
                System.out.print("您猜的數字:");
                setPlayRecord(i,scanner.next());
                if(!guest(i, playRecord[i])){
                    break;
                }
            }
            if(!isWin)
                System.out.println("******** 對不起,你沒猜到! ********");

            for(int i = 0; i <= playerUseTimes; i++){
                System.out.print("第" + (i + 1) + "猜: ");
                System.out.print(playRecord[i] + "\n");
            }

            System.out.println("---");
            System.out.printf("猜數字限制 %d 次\n", guestTimes);
            System.out.printf("您總共猜了 %d 次\n", playerUseTimes + 1);
            System.out.printf("正確數字: %d\n", guestNumber);

            System.out.println("******** 遊戲結束 ********");

            System.out.println("******** 再玩一次<Y/N>? ********");
            String inputValue = scanner.next().toUpperCase();

            while (!inputValue.equals("Y") && !inputValue.equals("N")){
                System.out.println("只能輸入Y/N!!!");
                System.out.println("******** 再玩一次<Y/N>? ********");
                inputValue = scanner.next().toUpperCase();
            }
                input = inputValue;
        }while(input.equals("Y"));


    }

}
