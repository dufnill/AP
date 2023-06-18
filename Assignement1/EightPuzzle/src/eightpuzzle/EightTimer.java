/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eightpuzzle;

import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
 *
 * @author dufnill
 */
public class EightTimer extends Timer{
    
    public EightTimer(EightTile button, int delay, ActionListener listener) {
        super(delay, listener);
    }
    
    public EightTimer(int delay, ActionListener listener) {
        super(delay, listener);
    }
    
    
   
    
}
