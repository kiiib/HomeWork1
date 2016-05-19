/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public class OperationAdd extends Operation{
    private double numA = 0;
    private double numB = 0;

//    public OperationAdd(double numA, double numB){
//        super(numA, numB);
//    }

    public void setNumA(double numA){
        this.numA = numA;
    }

    public void setNumB(double numB){
        this.numB = numB;
    }

    public void getResult(){
        System.out.println(numA + " + " + numB + " = " + (numA + numB));
    }


}
