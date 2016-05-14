/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class Square extends Rectangle {

    public Square(double x1, double y1, double x2, double y2,
                     double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public double getSideLength() {
        if (getPoint1().getY() == getPoint2().getY())
            return Math.abs(getPoint1().getX() - getPoint2().getX());
        else
            return Math.abs(getPoint2().getX() - getPoint3().getX());
    }

    public double getArea() {
        return getSideLength() * getSideLength();
    }

    public String toString() {
        return String.format("Square\n" +
                        "%s\n" +
                        "side length is: %.2f Area is: %.2f",
                getCoordinatesAsString(), getSideLength(), getArea());
    }
}
