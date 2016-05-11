public class QuadrilateralTest {

    public static void main(String[] args) {
        
        Quadrilateral quadrilateral = new Quadrilateral(1.1, 1.2, 6.6, 2.8, 6.2, 9.9, 2.2, 7.4);
        
        // A rectangle is an equiangular parallelogram
        Rectangle rectangle = new Rectangle(17.0, 14.0, 30.0, 14.0, 30.0, 28.0,17.0, 28.0);
        
        System.out.println(quadrilateral);
        System.out.println();
        System.out.println(rectangle);
    }

}
