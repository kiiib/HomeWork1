/**
 * Created by Jianbin Liu on 4/27/2016.
 */
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Game {
    Scanner scanner = new Scanner(System.in);
    Player newPlayer;
    String[] card;
    String[] trading = new String[52];

    public void initCard(){
        card = new String[52];
        for(int i = 0; i < 13; i++){
            card[i] = "梅花" + (i + 2);
            if(i == 9) card[i] = "梅花" + "J";
            if(i == 10) card[i] = "梅花" + "Q";
            if(i == 11) card[i] = "梅花" + "K";
            if(i == 12) card[i] = "梅花" + "A";
        }
        for(int i = 13; i < 26; i++){
            card[i] = "方塊" + (i + 2 - 13);
            if(i == 22) card[i] = "方塊" + "J";
            if(i == 23) card[i] = "方塊" + "Q";
            if(i == 24) card[i] = "方塊" + "K";
            if(i == 25) card[i] = "方塊" + "A";
        }
        for(int i = 26; i < 39; i++){
            card[i] = "紅心" + (i + 2 - 26);
            if(i == 35) card[i] = "紅心" + "J";
            if(i == 36) card[i] = "紅心" + "Q";
            if(i == 37) card[i] = "紅心" + "K";
            if(i == 38) card[i] = "紅心" + "A";
        }
        for(int i = 39; i < 52; i++){
            card[i] = "黑桃" + (i + 2 - 39);
            if(i == 48) card[i] = "黑桃" + "J";
            if(i == 49) card[i] = "黑桃" + "Q";
            if(i == 50) card[i] = "黑桃" + "K";
            if(i == 51) card[i] = "黑桃" + "A";
        }
//        for(int i =0; i < 52; i++){
//            System.out.println(card[i]);
//        }
    }

    /**
     * Constructor
     * @param scanner Scanner
     */
    public Game(Scanner scanner){

    }

    /**
     * init the player info
     */
    public void initPlayer(){
        String playerName;
        String playerMoney = new String();
        boolean goNext = false;
        do{
            System.out.print("請輸入玩家名稱: ");
            playerName = scanner.next();
            if (!playerName.matches("[a-z0-9A-Z]+")){
                System.out.println("輸入名稱錯誤，請重新輸入！");
                continue;
            }
            System.out.print("請輸入持有金額(必須大於等於 10000): ");
            playerMoney = scanner.next();
            if(!playerMoney.matches("^-?\\d+$")){
                System.out.println("請輸入整數");
                continue;
            }
            if(Integer.parseInt(playerMoney) < 10000){
                System.out.println("輸入金額必須大於等於10000元，請重新輸入");
                continue;
            }
            goNext = true;
        }while(!goNext);
        newPlayer = new Player(playerName, Integer.parseInt(playerMoney));
        savePlayer();
    }

    public void showPlayerInfo(){
        System.out.println("玩家名稱: " + newPlayer.getName());
        System.out.println("持有金額: " + newPlayer.getMoney());
        System.out.println("總回合數: " + newPlayer.getTotalCount());
        System.out.println("贏的回合數: " + newPlayer.getWinCount());
        System.out.println("輸的回合數: " + newPlayer.getLoseCount());
        System.out.println("勝率 : " + newPlayer.getWinningRate() + "%");
    }

    /**
     * read the player information from player.txt
     * @return boolean
     */
    public boolean loadPlayer(){
        return true;
    }

    /**
     * save the player information to the player.txt
     * @return boolean
     */
    public boolean savePlayer(){
        try {
            File file = new File("player.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("玩家名稱:");
            bw.newLine();
            bw.write(newPlayer.getName());
            bw.newLine();
            bw.write("玩家持有金額:");
            bw.newLine();
            bw.write(Integer.toString(newPlayer.getMoney()));
            bw.newLine();
            bw.write("玩家遊戲記錄-總回合數:");
            bw.newLine();
            bw.write(Integer.toString(newPlayer.getTotalCount()));
            bw.newLine();
            bw.write("玩家遊戲記錄-贏的回合數:");
            bw.newLine();
            bw.write(Integer.toString(newPlayer.getWinCount()));
            bw.newLine();
            bw.write("玩家遊戲記錄-輸的回合數:");
            bw.newLine();
            bw.write(Integer.toString(newPlayer.getLoseCount()));
            bw.newLine();

            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * play the game
     */
    public void play(){
        initCard();
        Random pRandomNumber = new Random();
        int playerCardNumber = pRandomNumber.nextInt(52) + 1;  // card number between 1-52. Player's card
        Random cRandomNumber = new Random();
        int computerCardNumber = cRandomNumber.nextInt(52) + 1; //computer's card
        String inputMoney;
        boolean goNext = false;

        do{
            System.out.print("您的牌是: " + card[playerCardNumber] + "\n");
            System.out.print("請輸入要下注的金額(必須大於等於100，輸入0為放棄將直接輸80): ");
            inputMoney = scanner.next();
            if(!inputMoney.matches("^-?\\d+$")){
                System.out.println("請輸入大於等於100或0的下注金額, 要為數字！");
                continue;
            }
            if(Integer.parseInt(inputMoney) < 100 && Integer.parseInt(inputMoney) !=0){
                System.out.println("請輸入大於等於100或0的下注金額");
                continue;
            }
            if(Integer.parseInt(inputMoney) == 0){
                newPlayer.setMoney(newPlayer.getMoney() - 80);
                System.out.println("放棄此局，輸了80元");
                newPlayer.setTotalCount(newPlayer.getTotalCount() + 1);
                newPlayer.setLoseCount(newPlayer.getLoseCount() + 1);
                break;
            }
            if(Integer.parseInt(inputMoney) >= 100){
                newPlayer.setTotalCount(newPlayer.getTotalCount() + 1);
                System.out.print("電腦的牌是: " + card[computerCardNumber] + "\n");
                if(playerCardNumber > computerCardNumber){
                    System.out.println("您的牌比較大，恭喜你贏得一局！");
                    newPlayer.setMoney(newPlayer.getMoney() + Integer.parseInt(inputMoney));
                    newPlayer.setWinCount(newPlayer.getWinCount() + 1);
                }
                if(playerCardNumber < computerCardNumber){
                    System.out.println("電腦的牌比較大，很可惜輸了！");
                    newPlayer.setMoney(newPlayer.getMoney() - Integer.parseInt(inputMoney));
                    newPlayer.setLoseCount(newPlayer.getLoseCount() + 1);
                }
                if(playerCardNumber == computerCardNumber){
                    System.out.println("平局！");
                }
            }
            goNext = true;
        }while(!goNext);
        savePlayer();   //save the player info real time
    }

    /**
     * program trading
     */
    public void programTrading(){
        String inputNumber;
        boolean goNext = false;

        System.out.println("讀取交易策略:");
        readFile("strategy.txt");
        do{
            System.out.print("請輸入要執行的回合數:");
            inputNumber = scanner.next();
            if(!inputNumber.matches("^-?\\d+$")){
                System.out.println("請輸入整數");
                continue;
            }
            if(Integer.parseInt(inputNumber) <= 0){
                System.out.println("回合數必須大於0，請重新輸入");
                continue;
            }
            goNext = true;
        }while (!goNext);

        initCard();
        for(int i = 1; i <= Integer.parseInt(inputNumber); i++){
            Random pRandomNumber = new Random();
            int playerCardNumber = pRandomNumber.nextInt(52) + 1;  // card number between 1-52. Player's card
            Random cRandomNumber = new Random();
            int computerCardNumber = cRandomNumber.nextInt(52) + 1; //computer's card
            System.out.println("回合 " + i);
            System.out.print("您的牌是: " + card[playerCardNumber] + "\n");
            //if(playerCardNumber >= 40 && playerCardNumber <= 52)
            System.out.print("交易策略: " + trading[52-(playerCardNumber - 1)] + "\n");
            System.out.println("本局結局 ");
            System.out.println("目前金額 " + newPlayer.getMoney());

        }

    }

    public void readFile(String fileName){
        try{
            File file = new File(fileName); // fileName is the path
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = null; // read the data in a line
            StringBuilder data = new StringBuilder();   // the read data
            while ((line = br.readLine()) != null){
                data.append(line + " ");    // split each line @
            }
            System.out.println(data);
            br.close();
            fr.close();

            setTrading(data.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setTrading(String str){
        String tradingData[] = str.split(" ");
        for(int i = 0; i < tradingData.length; i++){
            //System.out.println(tradingData[i]);
            trading[i] = tradingData[i];
            //System.out.println(trading[i]);
        }
    }

}
