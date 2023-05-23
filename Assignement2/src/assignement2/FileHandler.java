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
    
    private File myFile;
    private FileWriter w;
    
    public FileHandler(String filename){
        try {
          this.myFile= new File(filename);
          if (this.myFile.createNewFile()) { //file was created
              this.w = new FileWriter(filename);
              w.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
              w.close();
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
        }    
    }
    
}
