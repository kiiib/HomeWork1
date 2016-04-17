/**
 * Created by Jianbin Liu on 4/16/2016.
 */
public class Sales {
    private String name;
    final int MONTH = 12;
    private int transaction[] = new int[MONTH];

    /**
     * Constructor
     * @param name sales name
     * @param transaction sales 12 months transaction array
     */
    public Sales(String name, int[] transaction){
        this.name = name;
        this.transaction = transaction;
    }

    /**
     * get the sales name
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * get the transaction of i month
     * @param i transaction i
     * @return int
     */
    public int getTransaction(int i){
        return transaction[i];
    }

    public void getTransArray(){
        for(int i = 0; i < MONTH; i++){
            System.out.println(transaction[i]);
        }
    }

    /**
     * get the total transaction
     * @return int
     */
    public int getTotal(){
        int total = 0;
        for (int i = 0; i < MONTH; i++){
            total += transaction[i];
        }
        return total;
    }

    /**
     * get the average value of the total transaction
     * @return
     */
    public double getMean(){
        return getTotal() / MONTH;
    }

}
