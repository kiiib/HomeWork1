/**
 * Created by Jianbin Liu on 4/19/2016.
 */
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ranking {
    final int RATEAMOUNT = 20;
    private Language[] langs;

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
                data.append(line);
            }
            br.close();
            fr.close();

            setRankLanguage(data.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * print the ranking
     */
    public void printRanking(){
        System.out.println("Rank\tProgramming Language\t\tRatings");
        for(int i = 0; i < RATEAMOUNT; i++){
            System.out.printf("%s\t%-16s\t\t%-10s", langs[i].getRank(), langs[i].getName(), langs[i].getRating());
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
            bw.write("Rank\tProgramming Language\tRatings");
            bw.newLine();
            for(int i = 0; i < RATEAMOUNT; i++){
                String proRating = String.format("%-8s%-25s%-15s", langs[i].getRank(), langs[i].getName(), langs[i].getRating());
                bw.write(proRating);

                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set the rating info
     * @param str string from the file
     */
    public void setRankLanguage(String str){
        String check = "<table class=\"table table-striped table-top20\">[\\s\\S]*?</table>";
        Pattern pattern = Pattern.compile(check);
        Matcher matcher = pattern.matcher(str);
        String newStr = "";
        while (matcher.find()) {
            newStr += matcher.group();
        }
        check = "<tbody>[\\s\\S]*?</tbody>";
        pattern = Pattern.compile(check);
        matcher = pattern.matcher(newStr);
        newStr = "";
        while (matcher.find()) {
            newStr += matcher.group();
        }
        newStr = newStr.replace("<tbody>","");
        newStr = newStr.replace("</tbody>","");

        String line[] = newStr.split("<tr>");   // get the language rate info
        langs = new Language[line.length];

        for(int i = 1; i < line.length ; i++){
            String data[] = line[i].split("</td>");
            String rank = data[0];
            rank = rank.replace("<td>","");
            String name = data[3];
            name = name.replace("<td>","");
            String rating = data[4];
            rating = rating.replace("<td>","");
            //System.out.println(rank + "\t" + name + "\t" + rating);

            langs[i-1] = new Language(rank, name, rating);
        }
    }

}
