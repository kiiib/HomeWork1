/**
 * Created by Jianbin Liu on 4/27/2016.
 */
import java.util.Scanner;
public class GameLauncher {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input;
        Game newGame = new Game(scanner);
        boolean isCreatePlayer = false;
        do {
            if(isCreatePlayer)
                System.out.println("玩家 " + newGame.newPlayer.getName() + " 你好！");
            printMenu();
            input = scanner.next();
            if(input.matches("[0-4]")){
                int num = Integer.parseInt(input);
                switch (num){
                    case 1:
                        newGame.initPlayer();
                        isCreatePlayer = true;
                        break;
                    case 2:
                        if(isCreatePlayer){
                            newGame.showPlayerInfo();
                        }else{
                            System.out.println("尚未設定玩家資料");
                        }
                        break;
                    case 3:
                        if(isCreatePlayer){
                            newGame.play();
                        }else{
                            System.out.println("尚未設定玩家資料");
                        }
                        break;
                    case 4:
                        if(isCreatePlayer){
                            newGame.programTrading();
                        }else{
                            System.out.println("尚未設定玩家資料");
                        }
                        break;
                }
                System.out.println();
            }
            else{
                System.out.println("Please enter a valid number, only can enter 0, 1, 2, 3, 4.\n");
            }

        }while (!input.equals("0"));
    }

    /**
     * print the main menu
     */
    public static void printMenu(){

        System.out.println("*****撲克牌比大小*****");
        System.out.println("1) 設定玩家資料");
        System.out.println("2) 顯示玩家資料");
        System.out.println("3) 進行遊戲");
        System.out.println("4) 程式交易");
        System.out.println("0) 離開");
        System.out.println();
        System.out.print("請輸入選項 [1, 2, 3, 4, 0]: ");
    }
}
