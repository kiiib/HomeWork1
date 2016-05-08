/**
 * Created by Jianbin Liu on 5/7/2016.
 */
package ntust.mis.oo;

import java.util.Random;

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
     * @return double
     */
    private static double getAvaliableWeight(){
        return MAX_WEIGHT - currentWeight;  // the weight of can be received
    }

    /**
     * check the good weight whether exceed the (MAX_WEIGHT - current weight)
     * @return int
     */
    public int send(){
        if(goods.getWeight() == -1)
            return this.no = -1;
        if(goods.getWeight() > getAvaliableWeight()){
            return this.no = -1;
        }else{
            this.currentWeight += goods.getWeight();
            Random RandomNumber = new Random();
            int noNumber = RandomNumber.nextInt(10000) + 1; // 1-10000
            return this.no = noNumber;
        }
    }

    public String toString(){
        double beforeWeight = 0;
        if(this.no == -1){
            beforeWeight = getAvaliableWeight();
        }else{
            beforeWeight = getAvaliableWeight() + this.goods.getWeight();
        }
        String output = String.format(
                "減掉前，目前可用重量= %.1f\n" +
                "減掉後，目前可用重量= %.1f\n" +
                "No: %d",
                beforeWeight,
                getAvaliableWeight(),
                this.no
        );
        return output;
    }
}
