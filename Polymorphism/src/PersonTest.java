/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public class PersonTest {
    public static void main(String args[]){
        Person persons[] = new Person[3];
        persons[0] = new Staff("Alice", "BA", 22000);
        persons[1] = new Student("Bob", "CS", "Master");
        persons[2] = new TeachingAssistant("Alex", "MI", "PhD", "MI", 3000);

        for(Person currentPerson : persons){
            System.out.println(currentPerson.toString());
        }
    }


}
