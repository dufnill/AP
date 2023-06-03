/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement2;

import java.lang.Class;
import java.lang.reflect.*;

import java.io.File;
import java.io.IOException; 
import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 *
 * @author dufnill
 */
public class XMLSerializer {
    
    // File handler class is used to create XML files
    private static FileHandler fh;
    
    // ArrayLists used to keep track of the reflected classes
    private static final ArrayList<Class> classes = new ArrayList<>();
    private static final ArrayList<Field[]> fields = new ArrayList<>();
    private static final ArrayList<Annotation> classAnnotations = new ArrayList<>();
    private static final ArrayList<Annotation[]> fieldAnnotations = new ArrayList<>();
    
    //file's body
    public static String fileBody;
    
    public static void serialize(Object [] arr, String filename){
        
        fh = new FileHandler(filename);
        fileBody = "";
        
        // variables that will contan introspected information about the object
        int index;
        Field [] f;
        Annotation ca;
        Annotation [] fa;
        
        for (Object obj : arr){
            
            //retrieve class info
            Class objClass = obj.getClass(); 
            
            //introspect step is done just once: if the class has not been analyzed yet, save informations
            if (!classes.contains(objClass)){ 
                
                System.out.println("ADDED");
                f = objClass.getDeclaredFields();
                ca = (XMLable) objClass.getAnnotation(XMLable.class);
                fa = getFieldAnnotations(f);
                
                classes.add(objClass);
                fields.add(f);
                classAnnotations.add(ca);
                fieldAnnotations.add(fa);
            } 
              
            //infos has been saved yet -> start serializing it
            
            index = classes.indexOf(objClass);
            f = fields.get(index);
            ca = classAnnotations.get(index);
            fa = fieldAnnotations.get(index);

            
            if (ca != null){
                
                fileBody =  fileBody +
                            "<" + objClass.getName() + ">\n" +
                            getFieldsInfo(f, fa, obj) +
                            "</" +  objClass.getName() + ">\n";                
                
            } else {
                fileBody = fileBody + "<notXMLable />\n";
            }

        }
        fh.XMLWrite(fileBody);
        //System.out.println(fileBody);
    }
/**
 * this method retrieves annotation to the fields 
 */
    private static Annotation [] getFieldAnnotations(Field [] f){ 
        Annotation [] a = new Annotation[f.length];
        for (int i = 0; i < f.length; i++){
            f[i].setAccessible(true);
            a[i] = f[i].getAnnotation(XMLfield.class);
        }
        return a;
    }
    
/**
 * this method returns a string XML-like 
 */
    private static String getFieldsInfo(Field [] fields, Annotation [] annotations, Object obj){
        String info = "";
        String fieldName;
        for (int i = 0; i < fields.length; i++){
            
            Field field = fields[i]; 
            XMLfield x = (XMLfield) annotations[i];
            
            if (x != null){
                if (!x.name().equals(""))
                    fieldName = x.name();
                else 
                    fieldName = field.getName();
                try{
                    info =  info + "    <" +
                            fieldName +
                            " type=\"" + x.type() + "\">" + 
                            field.get(obj) +
                            "</" + fieldName + ">\n";
                } catch(IllegalAccessException e){}
                
            }
        }
        return info;
    }
    
}
