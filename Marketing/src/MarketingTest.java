/**
 * Created by Jianbin Liu on 4/16/2016.
 */
public class MarketingTest {
    public static void main(String[] args){
        Marketing mk = new Marketing();
        mk.readFile("input.txt");
        mk.printTransaction();
        mk.writeFile("output.txt");

    }
}
