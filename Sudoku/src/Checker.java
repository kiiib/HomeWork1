/**
 * Created by Jianbin Liu on 4/26/2016.
 */
import java.io.*;

public class Checker {
    final int sudokuRowNumber = 9;
    final int sudokuColNumber = 9;
    final int correctSum = 45;  // from 1 to 9, sum is 45
    private Sudoku[] sudokus;

    /**
     * read the file
     * @param fileName file name
     */
    public void readFile(String fileName){
        try{
            File file = new File(fileName); // fileName is the path
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = null; // read the data in a line
            StringBuilder data = new StringBuilder();   // the read data
            data.append("@");
            while ((line = br.readLine()) != null){
                //System.out.println(line);
                if(line.equals("")) data.append("#");   //split each Sudoku *

                data.append(line + "@");    // split each line @
            }
            //System.out.println(data);
            br.close();
            fr.close();

            setSudoku(data.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * set the Sudoku info
     * @param str String
     */
    public void setSudoku(String str){
        String sudokuData[] = str.split("#"); //split each Sudoku
//        for(int i = 0; i < sudokuData.length; i++){
//            System.out.println(sudokuData[i]);
//        }
        sudokus = new Sudoku[sudokuData.length];
        for(int i = 0; i < sudokuData.length; i++){
            sudokus[i] = new Sudoku(sudokuRowNumber, sudokuColNumber);  //initial the sudokus
            String rowData[] = sudokuData[i].split("@");   // split each line
            int sudokulength = rowData.length;
            //System.out.println("sudokulength" + sudokulength);
            for(int j = 1; j < rowData.length ; j++){
                String colData[] = rowData[j].split(" ");
                for(int h = 0; h < colData.length; h++){
                    sudokus[i].setSudokuContent(j - 1, h, colData[h]);
                }
            }
        }

    }

    /**
     * print the Sudoku and the result on the monitor
     */
    public void printSudoku(){
        System.out.println();
        for(Sudoku sudoku : sudokus){
            for(int i = 0; i < sudokuRowNumber; i++){
                for(int j = 0; j < sudokuColNumber; j++){
                    System.out.printf("%d ", sudoku.getSudokuContent(i, j));
                }
                System.out.println();
            }
            if(JudgeSudoku(sudoku))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println();
        }
    }

    /**
     * Judge the Sudoku correct or not
     */
    public boolean JudgeSudoku(Sudoku sudoku) {
        // Row
        for (int i = 0; i < sudokuRowNumber; i++) {
            int sum = 0;
            for (int j = 0; j < sudokuColNumber; j++) {
                sum += sudoku.getSudokuContent(i, j);
            }
            if (sum != correctSum)
                return false;
        }

        // Column
        for (int j = 0; j < sudokuColNumber; j++) {
            int sum = 0;
            for (int i = 0; i < sudokuRowNumber; i++) {
                sum += sudoku.getSudokuContent(i, j);
            }
            if (sum != correctSum)
                return false;
        }

        //each 3*3 area
        for (int area = 0; area <= 6; area += 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = area; j < area + 3; j++) {
                    sum += sudoku.getSudokuContent(i, j);
                }
            }
            if (sum != correctSum)
                return false;

            sum = 0;
            for (int i = 3; i < 6; i++) {
                for (int j = area; j < area + 3; j++) {
                    sum += sudoku.getSudokuContent(i, j);
                }
            }
            if (sum != correctSum)
                return false;

            sum = 0;
            for (int i = 6; i < 9; i++) {
                for (int j = area; j < area + 3; j++) {
                    sum += sudoku.getSudokuContent(i, j);
                }
            }
            if (sum != correctSum)
                return false;
        }
        return true;
    }

    /**
     * write the into to the file
     * @param fileName file name
     */
    public void writeFile(String fileName){
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Sudoku sudoku : sudokus){
                for(int i = 0; i < sudokuRowNumber; i++){
                    for(int j = 0; j < sudokuColNumber; j++){
                        String value = String.format("%d ", sudoku.getSudokuContent(i, j));
                        bw.write(value);
                    }
                    bw.newLine();
                }
                if(JudgeSudoku(sudoku)){
                    bw.write("true");
                    bw.newLine();
                }else{
                    bw.write("false");
                    bw.newLine();
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
