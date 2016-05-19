/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public abstract class Operation {
    public double numA = 0;
    public double numB = 0;

//    public Operation(double numA, double numB){
//        this.numA = numA;
//        this.numB = numB;
//    }

    public abstract void setNumA(double numA);
    public abstract void setNumB(double numB);

    public abstract void getResult();
}

