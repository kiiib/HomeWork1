/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jianbin Liu
 */
import java.util.Scanner;

public class studentTest {
    public static void main(String[] args)
    {
        Student student1 = new Student();   //create student object
        Student student2 = new Student();   //create student object
        
        student1.setStudentName(args[0]);  // set student1's name
        student1.setStudentID(args[1]); // set student1's ID
        student1.setStudentClass(args[2]);   // set student1's class
        
        //create Scanner to obtain student2's name from command window 
        System.out.print("Name: ");
        Scanner inputStudentName = new Scanner(System.in);
        //set student2's name
        student2.setStudentName(inputStudentName.next());
        
        //create Scanner to obtain student2's ID from command window 
        System.out.print("StudentID: ");
        Scanner inputStudentID = new Scanner(System.in);
        //set student2's ID
        student2.setStudentID(inputStudentID.next());
        
        //create Scanner to obtain student2's class from command window 
        System.out.print("StudentClass: ");
        Scanner inputStudentClass = new Scanner(System.in);
        //set student2's class
        student2.setStudentClass(inputStudentClass.next());
        
        //combine the statements
        String studentName = "Name: %s\n";
        String studentID = "StudentID: %s\n";
        String studentClass = "Class: %s\n";
        //print the statement
        System.out.println("---------Student 1---------");
        System.out.printf(studentName, student1.getStudentName());  //print student1's Name
        System.out.printf(studentID, student1.getStudentID());  //print student1's ID
        System.out.printf(studentClass, student1.getStudentClass());  //print student1's Class
        System.out.println("---------Student 2---------");
        System.out.printf(studentName, student2.getStudentName());  //print student2's Name
        System.out.printf(studentID, student2.getStudentID());  //print student2's ID
        System.out.printf(studentClass, student2.getStudentClass());  //print student2's Class
    }
}
