/**
 * Created by Jianbin Liu on 5/7/2016.
 */
package ntust.mis.test;
import ntust.mis.oo.*;

public class DeliveryTest {
    public static void main(String[] args){
        Person sPerson1 = new Person("haha", "1235678", City.TAIPEI);
        Person sPerson2 = new Person("michal", "888777", City.TAIPEI);
        Person sPerson3 = new Person("sun", "09887643", City.TAIPEI);

        Person rPerson1 = new Person("yeye", "5678912", City.KAOHSIUNG);
        Person rPerson2 = new Person("jinny", "555666", City.KAOHSIUNG);
        Person rPerson3 = new Person("chang", "09123456", City.KAOHSIUNG);

        Goods goods1 = new Goods("A", 22.3, Type.BUSSINESS);
        Goods goods2 = new Goods("B", 25.3, Type.BUSSINESS);
        Goods goods3 = new Goods("C", 30, Type.BUSSINESS);
        Goods goods4 = new Goods("D", 27, Type.BUSSINESS);

        Delivery d1 = new Delivery(sPerson1, rPerson1, goods1);
        Delivery d2 = new Delivery(sPerson2, rPerson2, goods2);
        Delivery d3 = new Delivery(sPerson3, rPerson3, goods3);
        Delivery d4 = new Delivery(sPerson2, rPerson1, goods4);

        d1.send();
        System.out.println(d1.toString());
        System.out.println("Sender: " + sPerson1.toString());
        System.out.println("Receiver: " + rPerson1.toString());
        System.out.println("Goods: " + goods1.toString());
        System.out.println();
        d2.send();
        System.out.println(d2.toString());
        System.out.println("Sender: " + sPerson2.toString());
        System.out.println("Receiver: " + rPerson2.toString());
        System.out.println("Goods: " + goods2.toString());
        System.out.println();
        d3.send();
        System.out.println(d3.toString());
        System.out.println("Sender: " + sPerson3.toString());
        System.out.println("Receiver: " + rPerson3.toString());
        System.out.println("Goods: " + goods3.toString());
        System.out.println();
        d4.send();
        System.out.println(d4.toString());
        System.out.println("Sender: " + sPerson2.toString());
        System.out.println("Receiver: " + rPerson1.toString());
        System.out.println("Goods: " + goods4.toString());


        System.out.println();
        System.out.println("A10409007 ¼B°·±l");
    }
}

