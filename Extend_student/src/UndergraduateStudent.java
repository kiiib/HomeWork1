/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class UndergraduateStudent extends Student{
    private String grade;
    private String classU;  // class

    public UndergraduateStudent(String name, String studentID, String majorDepartment, String grade, String classU){
        super(name, studentID, majorDepartment);
        this.grade = grade;
        this.classU = classU;
    }

    public String getGrade(){
        return this.grade;
    }

    public String getClassU(){
        return this.classU;
    }
}
