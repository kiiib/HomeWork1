/**
 * Created by Jianbin Liu on 5/19/2016.
 */
public class Staff extends Person implements Work{
    private String department;
    private double salary;

    public Staff(String name, String department, double salary){
        super(name);
        this.department = department;
        this.salary = salary;
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
                "Staff %s,\n" +
                "who works in %s,\n" +
                "whose salary is %.0f.\n", super.toString(), getDepartment(), getSalary());
    }
}
