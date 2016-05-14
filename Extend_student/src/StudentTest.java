/**
 * Created by Jianbin Liu on 5/15/2016.
 */
public class StudentTest {
    public static void main(String[] args){
        MasterStudent masterStudent = new MasterStudent("David Tsai", "M10009001", "Information Management", "Integrated Digital Services Lab", "Professor Lo", "EMBA", "Unfinished");
        System.out.println(masterStudent);
        PhDStudent phDStudent = new PhDStudent("Peter Yang", "D10015001", "Computer Science", "Software Engineering Lab", "Professor Lee", "Passed", "Unfinished");
        System.out.println(phDStudent);
        FullTimeStudent fullTimeStudent = new FullTimeStudent("Jack Chen", "B10005001", "Contruction Engineering", "Sophomore", "Class A", "Baseball Club", "Leader");
        System.out.println(fullTimeStudent);
        PartTimeStudent partTimeStudent = new PartTimeStudent("Michelle Lin", "B10008001", "Business Administration", "Freshman", "Class B", "7-ELEVEN", "Clerk");
        System.out.println(partTimeStudent);
    }
}
