/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement2;

/**
 *
 * @author dufnill
 */

public class Student {
    
    public String firstName;
    
    public String lastName;
    
    private int age;
    
    public Student(){}
    public Student(String fn, String ln, int age) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = age;
    }
}
