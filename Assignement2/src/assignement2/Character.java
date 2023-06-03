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
public class Character {
    
    @XMLfield(type = "String", name = "kind")
    public String race;
    
    @XMLfield(type = "int")
    public int hp;
    
    public float strength;
    
    public Character(){}
    public Character(String race, int hp, float strength){
        this.race = race;
        this.hp = hp;
        this.strength = strength;
    }
}
