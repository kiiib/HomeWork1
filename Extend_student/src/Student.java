/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class Student {
    private String name;
    private String studentID;
    private String majorDepartment;

    public Student(String name, String studentID, String majorDepartment){
        this.name = name;
        this.studentID = studentID;
        this.majorDepartment = majorDepartment;
    }

    public String getName(){
        return this.name;
    }

    public String getStudentID(){
        return this.studentID;
    }

    public String getMajorDepartment(){
        return this.majorDepartment;
    }
}
