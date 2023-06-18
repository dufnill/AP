/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package eightpuzzle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JButton;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author dufnill
 */
public class EightTile extends JButton implements Serializable {
    
    private int position;
    private int label;
    private VetoableChangeSupport vetos = new VetoableChangeSupport(this);
    
    

    public EightTile(int position) {
        this.position = position;
    }

    public EightTile() {}
    
  
    //////////////////////////////////////////////////////////////////
    public void addVetoableChangelistener(VetoableChangeListener l){ 
        vetos.addVetoableChangeListener(l);
    }
    
    public void removeVetoableChangelistener(VetoableChangeListener l){ 
        vetos.removeVetoableChangeListener(l);
    }
    
    /////////////////////////////////////////////////////////////////////
    
    
    public void setLab(int i){
        this.label = i;
        this.setText(Integer.toString(label));
        if (label == 9) {
            this.setBackground(new Color(200, 200, 200));
            this.setText("");
        }
        else if (label == position) this.setBackground(new Color(175, 230, 140));
        else this.setBackground(new Color(255, 255, 140));
    }  
    
    public int getPosition(){
        return this.position;
    }    
    
    public int getLab(){
        return this.label;
    }  
    
    public void blink(EightTile button){
        Timer blinkTimer = new Timer( 500, new ActionListener() {
            private int count = 0;
            private int maxCount = 4;
            private boolean on = false;
            private Color c;
            private Color r = new Color (255, 45, 45);
            public void actionPerformed(ActionEvent e) {
                
                if (button.getLab() == button.getPosition()) c = new Color(175, 230, 140);
                else if (button.getLab() == 9) c = new Color(200, 200, 200);
                else c = new Color(255, 255, 140);
                
                if (count >= maxCount) {
                    button.setBackground(c);
                    ((Timer) e.getSource()).stop();
                } else {
                    if (on) button.setBackground(r);
                    else button.setBackground(c);
                    on = !on;
                    count++;
                }
            }
        });
        blinkTimer.start();
    }
    
    public void flip(EightTile left, EightTile right){
        try {
            vetos.fireVetoableChange("flip", left, right);
        } catch(PropertyVetoException e){}
    }
    
    public void move(){
        try {
            vetos.fireVetoableChange("move", this, null);
        } catch(PropertyVetoException e){
            this.blink(this);
        }
    }

   
}
