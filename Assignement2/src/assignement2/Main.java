/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignement2;

import java.util.ArrayList;


/**
 *
 * @author dufnill
 */
public class Main {

    private static final Object [] arr = new Object[5];
    private static final XMLSerializer s = new XMLSerializer();

    public static void main(String[] args) {
        
        for (int i = 0; i < 5; i++)
            arr[i] = new Student ("Davide", "Fiorini", 25);
        s.serialize(arr);
    }
    
    
}
