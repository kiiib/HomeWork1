/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public class OperationFactory {
    // createOperation
    public static Operation createOperation(String oper){
        Operation operation = null;
        switch (oper){
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}
