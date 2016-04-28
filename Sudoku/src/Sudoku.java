/**
 * Created by Jianbin Liu on 4/26/2016.
 */


public class Sudoku {
    public String[][] Sudoku;
    private int row;
    private int column;

    public Sudoku(int inputRow, int inputColumn){
        Sudoku = new String[inputRow][inputColumn];
        this.row = inputRow;
        this.column = inputColumn;

    }

    public void setSudokuContent(int inputRow, int inputColumn, String value){
        Sudoku[inputRow][inputColumn] = value;
    }

    public int getSudokuContent(int inputRow, int inputColumn){
        return Integer.parseInt(Sudoku[inputRow][inputColumn]);
    }


}
