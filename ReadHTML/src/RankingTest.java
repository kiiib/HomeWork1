/**
 * Created by Jianbin Liu on 4/19/2016.
 */
public class RankingTest {
    public static void main(String[] args){
        Ranking rk = new Ranking();
        rk.readFile("index.html");
        rk.printRanking();
        rk.writeFile("output.txt");
    }
}
