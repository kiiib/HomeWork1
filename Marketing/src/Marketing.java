/**
 * Created by Jianbin Liu on 4/16/2016.
 */
import java.io.*;

public class Marketing {
    //private Sales[] sales;
    final int MONTH = 12;
    private Sales[] sales;
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
            while ((line = br.readLine()) != null){
                data.append(line + "@");
                //System.out.println(data);
            }
            br.close();
            fr.close();

            setSales(data.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * print the sales transaction
     */
    public void printTransaction(){
        for(Sales sale : sales){
            System.out.printf("%s\t", sale.getName());
            for(int i = 0; i < MONTH; i++){
                System.out.printf("%d\t", sale.getTransaction(i));
            }
            System.out.println();
        }
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
            for(Sales sale : sales){
                //System.out.println(sale.getMean());
                bw.write("業務員姓名: " + sale.getName());
                bw.newLine();
                bw.write("\t每月交易金額: ");
                bw.newLine();
                for(int i = 0; i < MONTH; i++){
                    bw.write("\t" + (i + 1) + " 月: " + sale.getTransaction(i));
                    bw.newLine();
                }
                bw.write("\t交易總金額: " + sale.getTotal());
                bw.newLine();
                bw.write("\t每月平均交易金額: " + sale.getMean());
                bw.newLine();
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set the sales info
     * @param str string from the file
     */
    private void setSales(String str){
        String line[] = str.split("@"); //split each line
        String name = null;
        sales = new Sales[line.length];
        
        for(int i = 0; i < line.length; i++){
            int transaction[] = new int[MONTH];
            String data[] = line[i].split("\t");    // get the sale's info
            name = data[0];
            //System.out.println(name);
            for(int j = 0; j < MONTH; j++){
                transaction[j] = Integer.parseInt(data[j + 1]);
                //System.out.println(transaction[j]);
            }

            sales[i] = new Sales(name, transaction);
        }
    }
}
