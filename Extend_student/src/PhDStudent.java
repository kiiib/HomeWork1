/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class PhDStudent extends GraduateStudent{
    private String isQuaExam;
    private String isFinishThesis;

    public PhDStudent(String name, String studentID, String majorDepartment, String lab, String professor, String isQuaExam, String isFinishThesis){
        super(name, studentID, majorDepartment, lab, professor);
        this.isQuaExam = isQuaExam;
        this.isFinishThesis = isFinishThesis;
    }

    public String getIsQuaExam(){
        return this.isQuaExam;
    }

    public String getIsFinishThesis(){
        return this.isFinishThesis;
    }

    public String toString(){
        return String.format("***** PhDStudent *****\n" +
                        "Name: %s\n" +
                        "Student ID: %s\n" +
                        "Major: %s\n" +
                        "Lab: %s\n" +
                        "Advisor: %s\n" +
                        "Qualify: %s\n" +
                        "Dissertation: %s\n",
                this.getName(), this.getStudentID(), this.getMajorDepartment(), this.getLab(), getProfessor(), getIsQuaExam(), getIsFinishThesis());
    }
}
