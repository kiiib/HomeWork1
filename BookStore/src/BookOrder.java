/**
 * Created by Jianbin Liu on 4/5/2016.
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BookOrder {
    long orderID; //訂單編號
    ArrayList<String> bookList = new ArrayList<String>();   //訂購書籍list
    ArrayList<String> bookAmountList = new ArrayList<String>(); //訂購書籍數量list

    String name; //訂購人姓名
    String phone; //訂購人電話
    Date dateTime; //訂單建立時間
    String dateString;  //訂單建立時間轉換格式

    /**
     * 建構子
     * @param bookList 書籍list
     * @param bookAmountList 書籍數量list
     * @param buyerName 訂購人姓名
     * @param buyerPhone 訂購人電話
     */
    public BookOrder(ArrayList<String> bookList, ArrayList<String> bookAmountList, String buyerName, String buyerPhone){
//        book[] = buyBook[]
        this.bookList = bookList;
        this.bookAmountList = bookAmountList;
        name = buyerName;
        phone = buyerPhone;
        dateTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateString = formatter.format(dateTime);
        orderID = (long) dateTime.getTime() / 1000;
    }

    /**
     * //印出訂單明細
     */
    public void printOrder(){
        double money;
        double AllMoney = 0;
        System.out.println("********** 訂購明細 **********");
        System.out.printf("訂單編號: " + orderID);
        System.out.printf("\t買家姓名: " + name);
        System.out.printf("\t聯絡電話: " + phone + "\n");
        System.out.println("--------------------------------------------------");
        System.out.println("書籍名稱\t單價\t數量\t小計");
        for (int i = 0; i < bookList.size(); i++){
            int BookNumber = Integer.parseInt(bookList.get(i).toString()) - 1;
            System.out.printf(Book.values()[BookNumber].getBookTitle() + "\t");
            System.out.printf(Book.values()[BookNumber].getBookPrice() + "\t");
            System.out.printf(bookAmountList.get(i).toString() + "\t");
            money = Book.values()[i].getBookPrice() * Integer.parseInt(bookAmountList.get(i).toString());
            AllMoney += money;
            System.out.printf(money + "\n");
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("應付金額: %.2f 元\n", AllMoney);
        System.out.println("訂單成立時間: " + dateString);
    }

}
