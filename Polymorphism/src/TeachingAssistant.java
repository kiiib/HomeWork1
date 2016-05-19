/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public class TeachingAssistant extends Student implements Work{
    private String department;
    private double salary;
    private String course;

    public TeachingAssistant(String name, String major, String degree, String department, double salay){
        super(name, major, degree);
        this.department = department;
        this.salary = salay;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary(){
        return this.salary;
    }

    public String toString(){
        return String.format("" +
                "TA name = %s,\n" +
                "who studies in %s,\n" +
                "whose degree is %s,\n" +
                "who works in %s,\n" +
                "whose salary is %.0f.\n", getName(), getMajor(), getDegree(), getDepartment(), getSalary());
    }
}
