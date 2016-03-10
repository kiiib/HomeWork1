/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jianbin Liu
 */
public class Student {
    private String studentName; //student name for this student
    private String studentID;   //student identity fot this student
    private String studentClass;    //class name for this student
    
    //method to set student name
    public void setStudentName(String name)
    {
        studentName = name; //store the student name
    }   //end method setStudentName
    
    //method to retrieve the student name
    public String getStudentName()
    {
        return studentName;
    }   //end method getStudentName
    
    //method to set student identity
    public void setStudentID(String id)
    {
        studentID = id; //store the student identity
    }   //end method setStudentID
    
    //method to retrieve the student identity
    public String getStudentID()
    {
        return studentID;
    }   //end method getStudentID
    
    //method to set student class
    public void setStudentClass(String className)
    {
        studentClass = className; //store the student class
    }   //end method setStudentClass
    
    //method to retrieve the student class
    public String getStudentClass()
    {
        return studentClass;
    }   //end method getStudentClass
    
    
    
}
