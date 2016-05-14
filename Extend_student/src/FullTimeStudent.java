/**
 * Created by Jianbin Liu on 5/14/2016.
 */
public class FullTimeStudent extends UndergraduateStudent {
    private String association; // Club
    private String associationCadre;    // Role

    public FullTimeStudent(String name, String studentID, String majorDepartment, String grade, String classU, String association, String associationCadre){
        super(name, studentID, majorDepartment, grade, classU);
        this.association = association;
        this.associationCadre = associationCadre;
    }

    public String getAssociation(){
        return this.association;
    }

    public String getAssociationCadre(){
        return this.associationCadre;
    }

    public String toString(){
        return String.format("***** FullTimeStudent *****\n" +
                        "Name: %s\n" +
                        "Student ID: %s\n" +
                        "Major: %s\n" +
                        "Grade: %s\n" +
                        "Class: %s\n" +
                        "Club: %s\n" +
                        "Role: %s\n",
                this.getName(), this.getStudentID(), this.getMajorDepartment(), this.getGrade(), getClassU(), getAssociation(), getAssociationCadre());
    }
}
