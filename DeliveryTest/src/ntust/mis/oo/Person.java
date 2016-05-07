/**
 * Created by Jianbin Liu on 5/7/2016.
 */
package ntust.mis.oo;
public class Person {
    private String name;
    private String phoneNum;
    private City city;

    public Person(String name, String phoneNum, City city){
        this.name = name;
        this.phoneNum = phoneNum;
        this.city = city;
    }

    public String toString(){
        String output = String.format("%s-%s-%s", name, phoneNum, city);
        return output;
    }
}
