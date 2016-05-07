/**
 * Created by Jianbin Liu on 5/7/2016.
 */
package ntust.mis.oo;
public class Goods {
    private String name;
    private double weight;
    private Type type;

    public Goods(String name, double weight, Type type){
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    private void setWeight(double weight){
        if(weight <= 30 && weight > 0){
            this.weight = weight;
        }else{
            this.weight = -1;
        }
    }

    public double getWeight(){
        return weight;
    }

    public String toString(){
        String output = String.format("%s-%s-%s", name, weight, type);
        return output;
    }


}
