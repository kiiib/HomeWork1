/**
 * Created by Jianbin Liu on 4/23/2016.
 */
import java.util.Scanner;

public class TicTacToe {
    private String[][] ticTacToe;
    private int row;
    private int column;
    private String whoNow = "X";    // whoNow represent the one who enter data now

    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor, build the TicTacToe
     * @param inputColumn int
     * @param inputRow int
     */
    public TicTacToe(int inputColumn, int inputRow){
        ticTacToe = new String[inputColumn][inputRow];
        this.column = inputColumn;
        this.row = inputRow;
        resetTicTacToe();
        gameStartTicTacToe();    //print the TicTacToe
    }

    /**
     * reset the TicTacToe
     */
    public void resetTicTacToe(){
        for(int row = 0; row < ticTacToe.length; row++) {
            for (int col = 0; col < ticTacToe[row].length; col++) {
                ticTacToe[row][col] = " ";
            }
        }
    }

    /**
     * game start
     */
    public void gameStartTicTacToe(){

        boolean gameOver = false;
        String playAgain;
        do{
            System.out.println("********** Game Start **********");
            do{
                if(game())
                    gameOver = isGameOver();
            }while (!gameOver);

            System.out.println("********** Game Over **********");
            do{
                System.out.printf("Play again(Y/N)?");
                playAgain = scanner.next().toUpperCase();
                if(!playAgain.equals("Y") && !playAgain.equals("N"))
                    System.out.println("Only can input Y or N");
            }while (!playAgain.equals("Y") && !playAgain.equals("N"));
            gameOver = false;
            resetTicTacToe();
        }while (playAgain.equals("Y"));


    }

    /**
     * game start
     * @return boolean
     */
    public boolean game(){
        System.out.printf("Player-%S, enter your move (row[1-%d],column[1-%d]):", whoNow, row, column);
        String input = scanner.next();
        if(input.matches("[1-3]{1},[1-3]{1}")){
            String data[] = input.split(",");   //data[0] is row, data[1] is column
            int inputRow = Integer.parseInt(data[0]) - 1;
            int inputColumn = Integer.parseInt(data[1]) - 1;

            if(ticTacToe[inputRow][inputColumn].equals(" ")){
                ticTacToe[inputRow][inputColumn] = whoNow;
                showTicTacToe();
            }else{
                System.out.println("The value you entered is invalid! Please try again.");
                return false;
            }
        }else{
            System.out.println("The value you entered is invalid! Please try again.");
            return false;
        }
        return true;
    }

    /**
     * judge if game over
     * @return boolean
     */
    public boolean isGameOver(){
        boolean isFullDraw = false;
        String winner = whoNow;

        //exchange next player
        if(whoNow.equals("X"))
            whoNow = "O";
        else
            whoNow = "X";

        //row
        for(int row = 0; row < ticTacToe.length; row++) {
            if(ticTacToe[row][0].equals(ticTacToe[row][1]) && ticTacToe[row][0].equals(ticTacToe[row][2]) && !ticTacToe[row][0].equals(" ")){
                System.out.printf("Player-%S is the winner!\n", winner);
                return true;
            }
        }
        //column
        for (int col = 0; col < column; col++) {
            if(ticTacToe[0][col].equals(ticTacToe[1][col]) && ticTacToe[0][col].equals(ticTacToe[2][col]) && !ticTacToe[0][col].equals(" ")){
                System.out.printf("Player-%S is the winner!\n", winner);
                return true;
            }
        }
        //slash
        if(ticTacToe[0][0].equals(ticTacToe[1][1]) && ticTacToe[0][0].equals(ticTacToe[2][2]) && !ticTacToe[0][0].equals(" ")){
            System.out.printf("Player-%S is the winner!\n", winner);
            return true;
        }
        if(ticTacToe[0][2].equals(ticTacToe[1][1]) && ticTacToe[0][2].equals(ticTacToe[2][0]) && !ticTacToe[0][2].equals(" ")){
            System.out.printf("Player-%S is the winner!\n", winner);
            return true;
        }

        //if full of the TicTacToe
        isFullLoop:
        for(int row = 0; row < ticTacToe.length; row++) {
            for (int col = 0; col < ticTacToe[row].length; col++) {
                if(ticTacToe[row][col] == " "){
                    isFullDraw = false;
                    break isFullLoop;
                }

            }
            isFullDraw = true;
        }
        if(isFullDraw){
            System.out.printf("It's a Draw!\n");
            return true;
        }



        return false;
    }

    /**
     * print the TicTacToe
     */
    public void showTicTacToe(){
        for(int row = 0; row < ticTacToe.length; row++){
            for(int col = 0; col < ticTacToe[row].length; col++){

                System.out.printf(" %S ",ticTacToe[row][col]);
                System.out.print("|");
            }
            System.out.println();
            if(row!= ticTacToe.length -1)
                System.out.println("------------");
        }
    }
}
