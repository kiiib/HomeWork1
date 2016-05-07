/**
 * Created by Jianbin Liu on 5/7/2016.
 */
package ntust.mis.oo;
public class Delivery {
    private Person sender;
    private Person receiver;
    private Goods goods;
    private static final double MAX_WEIGHT = 100;   //max load weight
    private static double currentWeight = 0;    //current weight
    private int no = -1;

    public Delivery(Person sender, Person receiver, Goods goods){
        this.sender = sender;
        this.receiver = receiver;
        this.goods = goods;
    }

    /**
     * return the weight of can be received
     * @return
     */
    private static double getAvaliableWeight(){
        return MAX_WEIGHT - currentWeight;  // the weight of can be received
    }

    /**
     * check the good weight whether exceed the (MAX_WEIGHT - current weight)
     * @return int
     */
    public int send(){
        if()
    }
}
