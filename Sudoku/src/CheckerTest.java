/**
 * Created by Jianbin Liu on 4/26/2016.
 */
public class CheckerTest {
    public static void main(String args[]){
        Checker ck = new Checker();
        ck.readFile("sudoku.txt");
        ck.printSudoku();
        ck.writeFile("output.txt");
    }
}
