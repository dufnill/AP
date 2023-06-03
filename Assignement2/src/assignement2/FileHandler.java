/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement2;

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException; 
/**
 *
 * @author dufnill
 */
public class FileHandler {
    
    private String dir = System.getProperty("user.dir");
    private String fileName;
    
    public FileHandler(String fileName){
        this.fileName = dir + "/" + fileName;
        System.out.println(this.fileName);
        try {
          File myFile = new File(this.fileName);
          if (myFile.createNewFile()){
            FileWriter w = new FileWriter(this.fileName);
            w.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            w.close();
          }
          
        } catch (IOException e) {
          System.out.println("An error occurred.");
        }    
    }
    public void XMLWrite(String payload){
        try {
            FileWriter w = new FileWriter(this.fileName, true);
            w.write(payload);
            w.close();
        } catch (IOException e) {
          System.out.println("An error occurred.");
        }    
    }
    
}
