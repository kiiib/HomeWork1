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
            System.out.println("����!�A�q��F!");
            isWin = true;
            playerUseTimes = playTimes;
            return false;
        }else if (playerNumber < guestNumber){
            System.out.println("�q���F,�A�q���Ʀr�񵪮פp!");
            minValue = playerNumber;
            if(playTimes != guestTimes){
                output = "�Ʀr�d��: %d ~ %d\n";
                System.out.printf(output, minValue, maxValue);
            }
            playerUseTimes = playTimes;
            return true;
        }else if(playerNumber > guestNumber){
            System.out.println("�q���F,�A�q���Ʀr�񵪮פj!");
            maxValue = playerNumber;
            if(playTimes != guestTimes) {
                output = "�Ʀr�d��: %d ~ %d\n";
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
            System.out.println("******** �q�Ʀr�C�� ********");
            System.out.print("�q�Ʀr�d��̤p��:");
            setMinValue(scanner.next());// set the minValue

            System.out.print("�q�Ʀr�d��̤j��:");
            setMaxValue(scanner.next());    // set the maxValue

            System.out.print("�q�Ʀr���ƭ���:");
            setGuestTimes(scanner.next());    // set the guest time

            System.out.println("******** �C���}�l ********");
            output = "�Ʀr�d��: %d ~ %d\n";
            System.out.printf(output, minValue, maxValue);
            createGuestNumber();

            for (int i = 0; i < guestTimes; i++){
                System.out.print("�z�q���Ʀr:");
                setPlayRecord(i,scanner.next());
                if(!guest(i, playRecord[i])){
                    break;
                }
            }
            if(!isWin)
                System.out.println("******** �藍�_,�A�S�q��! ********");

            for(int i = 0; i <= playerUseTimes; i++){
                System.out.print("��" + (i + 1) + "�q: ");
                System.out.print(playRecord[i] + "\n");
            }

            System.out.println("---");
            System.out.printf("�q�Ʀr���� %d ��\n", guestTimes);
            System.out.printf("�z�`�@�q�F %d ��\n", playerUseTimes + 1);
            System.out.printf("���T�Ʀr: %d\n", guestNumber);

            System.out.println("******** �C������ ********");

            System.out.println("******** �A���@��<Y/N>? ********");
            String inputValue = scanner.next().toUpperCase();

            while (!inputValue.equals("Y") && !inputValue.equals("N")){
                System.out.println("�u���JY/N!!!");
                System.out.println("******** �A���@��<Y/N>? ********");
                inputValue = scanner.next().toUpperCase();
            }
                input = inputValue;
        }while(input.equals("Y"));


    }

}
