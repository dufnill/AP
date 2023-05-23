/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement2;

import java.lang.Class;
import java.lang.reflect.*;

import java.io.File;
import java.io.IOException; 

/**
 *
 * @author dufnill
 */
public class XMLSerializer {
    
    private FileHandler fh = new FileHandler("students.txt");
    
    public static void XMLSerializer(){}
    
    public void serialize(Object [] arr/*, String filename*/){
        
        for (Object obj : arr){
            //takes the object's class
            Class objClass = obj.getClass(); 
            String classInfo = this.getClassInfo(objClass); //takes info about the class
            
            //takes the class fields info
            Field [] fieldsArray = objClass.getDeclaredFields();
            String fieldsInfo = this.getFieldsInfo(fieldsArray);
            
            //takes the class methods info
            Method [] methodsArray = objClass.getDeclaredMethods(); 
            String methodsInfo = this.getMethodsInfo(methodsArray);
            
            // takess the class constructors info
            Constructor [] constructorsArray = objClass.getDeclaredConstructors();
            String constructorsInfo = this.getConstructorsInfo(constructorsArray);
            
            this.WriteXMLFile(classInfo, fieldsInfo, methodsInfo, constructorsInfo);

        }
    }
    
    private void WriteXMLFile(){
        
    }
    
    private String getClassInfo(Class aClass){
        
        String info = aClass.isInterface() ? "interface " : "class "; //get the flavor of the instance
        info = info + aClass.getName(); //get the class name
        
        //get the superclass name
        Class parent = aClass.getSuperclass();
        if (parent != null) info = info + " extends " + parent.getName();
        
        Class [] interfaces = aClass.getInterfaces();
        for (Class i : interfaces) info = info + " implements " + i.getName();
        
        return info;
    }
    
    private String getFieldsInfo(Field [] aFields){
        String info = "";
        for (Field field : aFields) 
            info = info + "Field: " + field.getName() + " of type " + field.getType() + "\n";
        return info;
    }
    
    private String getMethodsInfo(Method [] aMethods){
        String info = "";
        for (Method method : aMethods){
            Class [] parameters = method.getParameterTypes();
            info = info + "Method: " + method.getName() + " of type " + method.getReturnType() + "(";
            for (Class parameter : parameters)
                info = info + parameter.getName() + " ";
            info = info + ")\n";
        } 
        
        return info;
    }
    
    private String getConstructorsInfo(Constructor [] aConstructors){
        String info = "";
        for (Constructor constructor : aConstructors) {
            info = info + "Constructor (";
            Class [] parameters = constructor.getParameterTypes();
            for (Class parameter : parameters)
                info = info + parameter.getName() + " ";
            info = info + ")\n";  
        } 
        return info;
        
    }
        
}
