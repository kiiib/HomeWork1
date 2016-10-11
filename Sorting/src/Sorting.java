
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

class Travel {
    String countryName;
    int[] visitor = new int[20];

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }
    public void setVisitor(int year, int number){
        visitor[year] = number;
    }
    public String getCountryName(){
        return countryName;
    }
    public int getVisitor(int year){
        return visitor[year];
    }
    public String toString(){
        return countryName + ":" + visitor[1];
    }
}


public class Sorting {
    private Travel[] travelers;

    public void readFile(String fileName){
        try{
            File file = new File(fileName); // fileName is the path
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = null; // read the data in a line
            StringBuilder data = new StringBuilder();

            while((line = br.readLine()) != null){
                //System.out.println(line);
                data.append(line + "@");    // split each line by "@"
            }
            //System.out.println(data);
            br.close();
            fr.close();

            setTraveler(data.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setTraveler(String str){
        String travelerData[] = str.split("@"); // split each traveler data
//        for(int i = 0; i < Traveler.length; i++){
//            System.out.println(Traveler[i]);
//        }

        travelers = new Travel[travelerData.length - 1];  // exclude the first row
        for(int i = 1; i < travelerData.length; i++){
            //System.out.println(travelerData[i]);
            String rowData[] = travelerData[i].split(",");  // split each row
            travelers[i - 1] = new Travel();    // initial the travelers
            travelers[i - 1].setCountryName(rowData[0]);
            //System.out.println(travelers[i - 1].getCountryName());
            for(int j = 1; j < rowData.length; j++){
                travelers[i - 1].setVisitor(j - 1, Integer.parseInt(rowData[j]));
                //System.out.println(travelers[i - 1].getVisitor(j - 1));
            }
            //System.out.println("----");

        }

        //sorting by year
        int year = 2002;
        String sortingDesp = "----- sort by year %d ---------\n";
        for(int i = 0; i < 12; i++){
            int sortYear = i;
            Bubble.sort(travelers, new Comparator<Travel>() {
                @Override
                public int compare(Travel a, Travel b) {
                    return a.getVisitor(sortYear) - b.getVisitor(sortYear);
                }
            });

            System.out.printf(sortingDesp, year);
            year++;
            for(int j = travelers.length; j > travelers.length - 5; j--) {
                System.out.println(travelers[j - 1].getCountryName() + " --- " + travelers[j - 1].getVisitor(i));
            }
        }

        //sorting by sum of 2009-2013

        Bubble.sort(travelers, new Comparator<Travel>() {
            @Override
            public int compare(Travel a, Travel b) {
                return (a.getVisitor(7) + a.getVisitor(8) + a.getVisitor(9) + a.getVisitor(10) + a.getVisitor(11)) - (b.getVisitor(7) + b.getVisitor(8) + b.getVisitor(9) + b.getVisitor(10) + b.getVisitor(11));
            }
        });
        System.out.println("sorting by sum of year 2009 - year 2013");
        for(int j = travelers.length; j > travelers.length - 5; j--) {
            System.out.println(travelers[j - 1].getCountryName() + " --- " + (travelers[j - 1].getVisitor(7) + travelers[j - 1].getVisitor(8) + travelers[j - 1].getVisitor(9) + travelers[j - 1].getVisitor(10) + travelers[j - 1].getVisitor(11)));
        }
    }
    public static void main(String args[]){
        Sorting st = new Sorting();
        st.readFile("travel.csv");
    }
}
