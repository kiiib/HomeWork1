import java.util.Scanner;

/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public class OperationTest {
    public static void main(String[] args){
        double numA = 0;
        double numB = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number A: ");
        numA = scanner.nextDouble();
        System.out.print("Enter the number B: ");
        numB = scanner.nextDouble();

        Operation operation;
        operation = OperationFactory.createOperation("+");
        operation.setNumA(numA);
        operation.setNumB(numB);
        operation.getResult();
        operation = OperationFactory.createOperation("-");
        operation.setNumA(numA);
        operation.setNumB(numB);
        operation.getResult();
        operation = OperationFactory.createOperation("*");
        operation.setNumA(numA);
        operation.setNumB(numB);
        operation.getResult();
        operation = OperationFactory.createOperation("/");
        operation.setNumA(numA);
        operation.setNumB(numB);
        operation.getResult();

    }



}
