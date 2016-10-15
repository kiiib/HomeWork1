/**
 * Created by Jianbin Liu on 10/15/2016.
 */
import java.util.Comparator;
class Insertion{
    public static <T extends Comparable> void sort(T x[]){
        for(int j = 1; j < x.length; ++j){
            T key = x[j];
            // Insert x[j] into the sorted sequence x[1..j-1]
            int i = j - 1;
            while(i >= 0 && (x[i].compareTo(key) > 0)){
                x[i + 1] = x[i];
                i--;
            }
            x[i + 1] = key;
        }
    }

    public static <T> void sort(T x[], Comparator<T> comparator){
        for(int j = 1; j < x.length; ++j){
            T key = x[j];
            // Insert x[j] into the sorted sequence x[1..j-1]
            int i = j - 1;
            while(i >= 0 && comparator.compare(x[i], key) > 0){
                x[i + 1] = x[i];
                i--;
            }
            x[i + 1] = key;
        }
    }
}
class Member{
    String firstName;
    String lastName;
    int age;
    public Member(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public String toString(){
        return firstName + " " + lastName + " , age = " + age;
    }
}

public class SortTool {
    public static void main(String args[]){
        Double a[] = { 1.1, 2.5, 0.2, -1.4, -80.1};
        Insertion.sort(a);
        System.out.println("--------------");
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        Integer b[] = { 2, 20, 9, 16, 8};
        Insertion.sort(b);
        System.out.println("--------------");
        for(int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        String fruits[] = { "grape", "melon", "apple", "peach", "banana", "orange"};
        Insertion.sort(fruits);
        System.out.println("--------------");
        for(String fruit : fruits) {
            System.out.println(fruit);
        }

        Member members[] = {
                new Member("Paul", "Lee", 23),
                new Member("Alice", "Wang", 39),
                new Member("Sophia", "Chen", 34),
                new Member("Steph", "Lee", 28),
                new Member("Joyce", "Chang", 21) };
        Insertion.sort(members, new Comparator<Member>() {
            public int compare(Member a, Member b) {
                int diff = a.lastName.compareTo(b.lastName);
                System.out.println(diff);
                if(diff != 0) return diff;
                return a.firstName.compareTo(b.firstName);
            }
        });
        System.out.println("------ sort by name --------");
        for(Member member : members) {
            System.out.println(member);
        }
        Insertion.sort(members, new Comparator<Member>() {
            public int compare(Member a, Member b) {
                return a.age - b.age;
            }
        });
        System.out.println("----- sort by age ---------");
        for(Member member : members) {
            System.out.println(member);
        }
    }
}
