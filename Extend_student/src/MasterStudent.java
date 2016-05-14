/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class MasterStudent extends GraduateStudent{
    private String schoolSystem;
    private String isFinishThesis;

    public MasterStudent(String name, String studentID, String majorDepartment, String lab, String professor, String schoolSystem, String isFinishThesis){
        super(name, studentID, majorDepartment, lab, professor);
        this.schoolSystem = schoolSystem;
        this.isFinishThesis = isFinishThesis;
    }

    public String getSchoolSystem(){
        return this.schoolSystem;
    }

    public String getIsFinishThesis(){
        return this.isFinishThesis;
    }

    public String toString(){
        return String.format("***** MasterStudent *****\n" +
                "Name: %s\n" +
                "Student ID: %s\n" +
                "Major: %s\n" +
                "Lab: %s\n" +
                "Advisor: %s\n" +
                "System: %s\n" +
                "Thesis: %s\n",
                this.getName(), this.getStudentID(), this.getMajorDepartment(), this.getLab(), getProfessor(), getSchoolSystem(), getIsFinishThesis());
    }
}
