/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignement2;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author dufnill
 */

public class Main {

    //Character
    public static String [] RACE = {"Vampire", "Lycan", "Dragon", "Human", "Blob"};
    public static int [] HP = {10, 15, 20};
    public static float [] STRENGTH = {10,5, 13,4, 100,13, 300,0};
    
    //Student
    public static String [] FIRSTNAME = {"Davide", "Lucia", "Kevin", "Elisa", "Mario"};
    public static String [] LASTNAME = {"Fiorini", "Rossi", "Bianchi", "Verdi", "Quattrini"};
    public static int [] AGE = {18, 19, 20, 21, 22, 23, 24, 25, 26};
    
    //Weapon
    public static String [] NAME = {"Sword", "Knife", "Katana", "Spear", "Wand"};
    public static String [] MATERIAL = {"Wood", "Ivory", "Steel"};
    public static float [] POWER = {4,5, 5,6, 12,4, 13,1, 16,0};
    
    public static int N = 13;
    
    private static final Object [] arr = new Object[N];
    //private static final XMLSerializer s = new XMLSerializer();

    public static void main(String[] args) {
        
        for (int i = 0; i < N; i++){
            if (i%3 == 0)
                arr[i] = new Student (
                        FIRSTNAME[new Random().nextInt(FIRSTNAME.length)],
                        LASTNAME[new Random().nextInt(LASTNAME.length)], 
                        AGE[new Random().nextInt(AGE.length)]);
            else if (i%3 == 1)
                arr[i] = new Character (
                        RACE[new Random().nextInt(RACE.length)],
                        HP[new Random().nextInt(HP.length)], 
                        STRENGTH[new Random().nextInt(STRENGTH.length)]);
            else 
                arr[i] = new Weapon (
                        NAME[new Random().nextInt(NAME.length)],
                        MATERIAL[new Random().nextInt(MATERIAL.length)], 
                        POWER[new Random().nextInt(POWER.length)]);
        }
        
        XMLSerializer.serialize(arr, "XMLFile.xml");
    }
    
    
}
