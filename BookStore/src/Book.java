/**
 * Created by Jianbin Liu on 4/5/2016.
 */
public enum Book {
    ACCOUNTING(1, "會計學  ", 360),
    SATISITICS(2, "統計學  ", 245),
    PL(3, "程式語言", 600),
    ECONOMIC(4,"經濟學  ", 445),
    HISTORY(5, "本國史  ", 180),
    ENGLISH(6, "英文    ", 350);

    private final int bookID; //書籍編號
    private final String bookTitle; //書籍名稱
    private final double bookPrice; //書籍價格

    /**
     * 建構子
     * @param book_ID 書籍編號
     * @param book_Title 書籍名稱
     * @param book_Price 書籍價格
     */
    private Book(int book_ID, String book_Title, double book_Price){
        bookID = book_ID;
        bookTitle = book_Title;
        bookPrice = book_Price;

    }

    /**
     * 取得書籍編號
     * @return int
     */
    public int getBookID(){
        return bookID;
    }

    /**
     * 取得書籍名稱
     * @return String
     */
    public String getBookTitle(){
        return bookTitle;
    }

    /**
     * 取得書籍價格
     * @return double
     */
    public double getBookPrice(){
        return bookPrice;
    }

}
