/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class PartTimeStudent extends UndergraduateStudent {
    private String company; // company
    private String post;    // position

    public PartTimeStudent(String name, String studentID, String majorDepartment, String grade, String classU, String company, String post){
        super(name, studentID, majorDepartment, grade, classU);
        this.company = company;
        this.post = post;
    }

    public String getCompany(){
        return this.company;
    }

    public String getPost(){
        return this.post;
    }

    public String toString(){
        return String.format("***** FullTimeStudent *****\n" +
                        "Name: %s\n" +
                        "Student ID: %s\n" +
                        "Major: %s\n" +
                        "Grade: %s\n" +
                        "Class: %s\n" +
                        "Company: %s\n" +
                        "Position: %s\n",
                this.getName(), this.getStudentID(), this.getMajorDepartment(), this.getGrade(), getClassU(), getCompany(), getPost());
    }
}
