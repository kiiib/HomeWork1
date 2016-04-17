/**
 * Created by Jianbin Liu on 4/5/2016.
 */
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;
import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookStore {
    private static Book books;
    public static void main(String[] args){
        printBooks();
        orderBook();
    }

    /**
     * 印出書籍清單
     */
    private static void printBooks(){
        System.out.println("********** Welcome to Book Store **********");
        for(Book book: Book.values()){
            System.out.printf("%-1s)%-1s\t%.2f元\n",book.getBookID(),book.getBookTitle(),book.getBookPrice());
        }
    }

    /**
     * 訂購書籍
     */
    private static void orderBook(){
        Console cons = System.console();
        ArrayList<String> bookList = new ArrayList<String>();   //訂購書籍list
        ArrayList<String> bookAmountList = new ArrayList<String>(); //訂購書籍數量list
        String buyerName;
        String buyerTel;
        String isContinue;  //是否繼續購買
        String bookNumber;  //書籍編號
        String bookAmount;  //書籍購買數量
        boolean isNext;

        do {
            bookNumber = cons.readLine("請輸入訂購書籍(1~6): ");
            if(isOrderBookNumberFormat(bookNumber)){
                bookList.add(bookNumber);
            }else {
                isContinue = cons.readLine("繼續選購嗎?(Y/N)");
                continue;
            }
            bookAmount = cons.readLine("數量: ");
            if(isOrderBookAmountFormat(bookAmount)){
                bookAmountList.add(bookAmount);
            }else{
                isContinue = cons.readLine("繼續選購嗎?(Y/N)");
                continue;
            }
            isContinue = cons.readLine("繼續選購嗎?(Y/N)");
        }while (isContinue.toUpperCase().equals("Y"));

        do{
            isNext = true;

            buyerName = cons.readLine("請輸入您的姓名: ");
            buyerTel = cons.readLine("請輸入聯絡電話: ");
            if(!isOrderFormat(buyerName, buyerTel)){
                isNext = false;
            }

        }while (!isNext);

        BookOrder newOrder = new BookOrder(bookList, bookAmountList, buyerName, buyerTel);
        newOrder.printOrder();

    }

    /**
     * isOrderBookNumberFormat
     * @param bookNumber 書籍代碼
     * @return boolean
     */
    private static boolean isOrderBookNumberFormat(String bookNumber){
        if(!bookNumber.matches("[1-6]")) {
            System.out.println("請輸入正確書籍代碼!");
            return false;
        }
        return true;
    }

    /**
     * isOrderBookAmountFormat
     * @param bookAmount 書籍購買數量
     * @return boolean
     */
    private static boolean isOrderBookAmountFormat(String bookAmount){
        if(!bookAmount.matches("\\d+")) {
            System.out.println("請輸入數量!");
            return false;
        }
        return true;
    }

    /**
     * 驗證訂購格式
     * @param name 購買人姓名
     * @param phone 購買人電話
     * @return boolean
     */
    private static boolean isOrderFormat(String name, String phone){
        if(name.matches("[a-zA-Z]+[0-9]*") && phone.matches("[0-9]{4}-[0-9]{6}"))
            return true;

        if(!name.matches("[a-zA-Z]+[0-9]*")) {
            System.out.println("請輸入正確姓名!");
        }
        if(!phone.matches("[0-9]{4}-[0-9]{6}")){
            System.out.println("電話格式有誤! (格式: 0000-000000)");
        }
        return false;
    }
}
