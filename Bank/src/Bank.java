/**
 * Created by Jianbin Liu on 2016/3/10.
 */
public class Bank {

    private static boolean isOpenAccount = false;  //是否開戶狀態
    private static double deposit = 0; //存款金額

    /**
     * getIsOpenAccount: get the status of whether opened account
     * @return isOpenAccount 返回是否開戶狀態
     */
    public static boolean getIsOpenAccount(){
        return isOpenAccount;
    }

    /**
     *  openAccount: method of open account(開戶)
     *  @param m money
     */
    public static void openAccount(String m){
        //判斷是否為數字
        try{
            double money = Double.parseDouble(m);
            if(money >= 1000 && !isOpenAccount){
                deposit = money;
                isOpenAccount = true;
                System.out.println("開戶成功!存入$" + deposit + "元!");
            }else{
                System.out.println("開戶金額不足!");
            }
        }
        catch(Exception e){
            System.out.println("開戶失敗!請輸入金額!");
        }
    }

    /**
     *  SaveDeposit: method of save deposit (存款)
     * @param m money
     */
    public static void saveDeposit(String m){
        try{
            double money = Double.parseDouble(m);
            if(money >= 0 && isOpenAccount) {   //要為數字且是開戶狀態
                deposit += money;
                isOpenAccount = true;
                System.out.println("開戶成功!存入$" + money + "元!");
            }else if(!isOpenAccount){   //判斷是否開戶，若為否則提示未開戶
                System.out.println("未開戶!");
            }else{
                System.out.println("存款失敗! 請輸入非負數值!");
            }
        }
        catch(Exception e){
            System.out.println("存款失敗!請輸入金額!");
        }
    }

    /**
     *  getDeposit: method of get the deposit (提款)
     * @param m money
     */
    public static void getDeposit(String m){
        try{
            double money = Double.parseDouble(m);
            if(money >= 0 && money <= deposit && isOpenAccount) {   //要為數字且不能超過存款且是開戶狀態
                deposit -= money;
                isOpenAccount = true;
                System.out.println("提款成功!成功領出 $" + money + "元!");
            }else if(money > deposit && isOpenAccount){
                System.out.println("提款失敗! 提款金額大於目前餘額!");
            }else if(!isOpenAccount){   //判斷是否開戶，若為否則提示未開戶
                System.out.println("未開戶!");
            }else{
                System.out.println("提款失敗! 請輸入非負數值!");
            }
        }
        catch(Exception e){
            System.out.println("提款失敗!請輸入金額!");
        }
    }

    /**
     * showDeposit: show the current deposit (顯示餘額)
     */
    public static void showDeposit(){
        if(isOpenAccount){
            System.out.println("目前餘額: $" + deposit + "元!");
        }else{
            System.out.println("未開戶!");
        }
    }
}
