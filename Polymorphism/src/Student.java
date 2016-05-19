/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public class Student extends Person implements Study {
    private String major;
    private String degree;

    public Student(String name, String major, String degree){
        super(name);
        this.major = major;
        this.degree = degree;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public String getMajor(){
        return this.major;
    }

    public void setDegree(String degree){
        this.degree = degree;
    }

    public String getDegree(){
        return this.degree;
    }

    public String toString(){
        return String.format("" +
                "Student %s,\n" +
                "who studies in %s,\n" +
                "whose degree is %s.\n", super.toString(), getMajor(), getDegree());
    }
}
