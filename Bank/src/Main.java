/**
 * Created by Jianbin Liu on 2016/3/10.
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String input;   //用戶輸入的值
        int num;
        String money;   //輸入的金錢
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("***Main Menu***");
            System.out.println("1) 開戶");
            System.out.println("2) 存款");
            System.out.println("3) 提款");
            System.out.println("4) 目前餘額");
            System.out.println("0) Exit");
            System.out.println("");
            System.out.println("Please enter a number in [1,2,3,4,0]: ");

            input = scanner.next(); //獲取用戶輸入(String)
            try{
                num = Integer.parseInt(input);  //型別轉換（Integer)
                switch (num) {
                    case 1:
                        if(!Bank.getIsOpenAccount()) {  //先判斷是否已開戶
                            System.out.print("請輸入開戶金額: ");
                            money = scanner.next();  //獲取用戶輸入(String)
                            Bank.openAccount(money);    //開戶
                        }else{
                            System.out.println("已開戶!");
                        }
                        break;
                    case 2:
                        System.out.print("請輸入存款金額: ");
                        money = scanner.next();  //獲取用戶輸入(String)
                        Bank.saveDeposit(money);    //存款
                        break;
                    case 3:
                        System.out.print("請輸入提款金額: ");
                        money = scanner.next();  //獲取用戶輸入(String)
                        Bank.getDeposit(money);    //提款
                        break;
                    case 4:
                        Bank.showDeposit(); //顯示餘額
                        break;
                }
            }
            catch (Exception e){
                System.out.println("只能輸入1,2,3,4,0");
            }

        }while (!input.equals("0"));    //若input不為0則繼續執行迴圈
    }
}
