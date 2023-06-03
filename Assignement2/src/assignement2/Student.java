/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement2;

/**
 *
 * @author dufnill
 */
@XMLable 
public class Student {
    
    @XMLfield(type = "String")
    public String firstName;
    
    @XMLfield(type = "String", name = "surname")
    public String lastName;
    
    @XMLfield(type = "int")
    private int age;
    
    public Student(){}
    public Student(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }
}
