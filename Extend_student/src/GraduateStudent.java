/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class GraduateStudent extends Student{
    private String lab;
    private String professor;

    public GraduateStudent(String name, String studentID, String majorDepartment, String lab, String professor){
        super(name, studentID, majorDepartment);
        this.lab = lab;
        this.professor = professor;
    }

    public String getLab(){
        return this.lab;
    }

    public String getProfessor(){
        return this.professor;
    }
}
