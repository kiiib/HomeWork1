public class Quadrilateral {
    private Point point1; // first endpoint
    private Point point2; // second endpoint
    private Point point3; // third endpoint
    private Point point4; // fourth endpoint

    // 建構子 (x1, y1, x2, y2, x3, y3, x4, y4)
    public Quadrilateral(double x1, double y1, double x2, double y2, 
            double x3, double y3, double x4, double y4) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
        point4 = new Point(x4, y4);
    }

    // 取得 point1
    public Point getPoint1() {
        return point1;
    }

    // 取得 point2
    public Point getPoint2() {
        return point2;
    }

    // 取得 point3
    public Point getPoint3() {
        return point3;
    }

    // 取得 point4
    public Point getPoint4() {
        return point4;
    }

    // 取得 Quadrilateral 物件的 string 格式，表示四邊形的四點座標
    public String toString() {
        return String.format("Coordinates of Quadrilateral are:\n%s", getCoordinatesAsString());
    }

    // 取得四邊形的四點座標
    public String getCoordinatesAsString() {
        return String.format("%s, %s, %s, %s", point1, point2, point3, point4);
    }

}
