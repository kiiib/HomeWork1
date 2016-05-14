/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class Trapezoid extends Quadrilateral{

     //Constructor
    public Trapezoid(double x1, double y1, double x2, double y2,
                     double x3, double y3, double x4, double y4){
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    // get the trapezoid's top line
    public double getTopLine(){
        if(getPoint1().getY() == getPoint2().getY()){
            if(Math.abs(getPoint2().getX() - getPoint1().getX()) < Math.abs(getPoint3().getX() - getPoint4().getX()))
                return Math.abs(getPoint2().getX() - getPoint1().getX());
            else
                return Math.abs(getPoint3().getX() - getPoint4().getX());
        }
        else
        {
            if(Math.abs(getPoint4().getX() - getPoint1().getX()) < Math.abs(getPoint3().getX() - getPoint2().getX()))
                return Math.abs(getPoint4().getX() - getPoint1().getX());
            else
                return Math.abs(getPoint3().getX() - getPoint2().getX());
        }
    }

    // get the trapezoid's base line
    public double getBaseLine(){
        if(getPoint1().getY() == getPoint2().getY()){
            if(Math.abs(getPoint2().getX() - getPoint1().getX()) > Math.abs(getPoint3().getX() - getPoint4().getX()))
                return Math.abs(getPoint2().getX() - getPoint1().getX());
            else
                return Math.abs(getPoint3().getX() - getPoint4().getX());
        }
        else
        {
            if(Math.abs(getPoint4().getX() - getPoint1().getX()) > Math.abs(getPoint3().getX() - getPoint2().getX()))
                return Math.abs(getPoint4().getX() - getPoint1().getX());
            else
                return Math.abs(getPoint3().getX() - getPoint2().getX());
        }
    }

    // get the trapezoid's height
    public double getHeight(){
        if(getPoint1().getY() == getPoint2().getY())
            return Math.abs(getPoint1().getY() - getPoint4().getY());
        else
            return Math.abs(getPoint1().getY() - getPoint2().getY());
    }

    public double getArea(){
        return (getTopLine() + getBaseLine()) * getHeight() * 0.5;
    }

    public String toString() {
        return String.format("Trapezoid\n" +
                "%s\n" +
                "Top Line is: %.2f Base Line is: %.2f Height is : %.2f Area is: %.2f",
                getCoordinatesAsString(), getTopLine(), getBaseLine(), getHeight(), getArea());
    }





}
