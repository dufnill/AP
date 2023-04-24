/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package eightpuzzle;

import java.awt.Color;
import java.beans.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author dufnill
 */
public class EightController extends JLabel implements VetoableChangeListener {
    
    private EightTile hole;
    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public EightController() {}
    
    public void addPropertyChangelistener(PropertyChangeListener l){ 
        changes.addPropertyChangeListener(l);
    }
    
    public void setHole(EightTile h){
        this.hole = h;
        
    }
    
    public void KO(){
        this.setText("KO");
        this.setBackground(new java.awt.Color(255, 45, 45));
    }
    
    public void OK(){
        this.setText("OK");
        this.setBackground(new java.awt.Color(255, 255, 140));
    }
    
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        System.out.println("I'm inside vetoable change");
        int h = this.hole.getPosition();
        
        if (evt.getPropertyName().equals("flip")){
            if (h == 9){
                System.out.println("The hole is in the right position");
                this.OK();
                changes.firePropertyChange("flip", (EightTile) evt.getNewValue(), (EightTile) evt.getOldValue());
            }
            else {                    
                this.KO();
                throw new PropertyVetoException("The hole must be in the 9th position", evt);
            }
            
        } else if (evt.getPropertyName().equals("move")){
            
            EightTile toSwitch = (EightTile) evt.getOldValue();
            int pos = toSwitch.getPosition();
            
            System.out.println(toSwitch.getPosition());
            
            switch (pos) {
                case 1:
                    if (h == 2 || h == 4) {
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break;
                case 2:
                    if (h == 1 || h == 3 || h == 5){
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break;
                case 3:
                    if (h == 2 || h == 6){
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break;
                case 4:
                    if (h == 1 || h == 5 || h == 7){
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break;
                case 5:
                    if (h == 2 || h == 4 || h == 6 || h == 8){
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break;
                case 6:
                    if (h == 3 || h == 5 || h == 9){
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break;
                case 7:
                    if (h == 4 || h == 8){
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break;
                case 8:
                    if (h == 5 || h == 7 || h == 9){
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break;
                default:
                    if (h == 6 || h == 8){
                        this.OK();
                        changes.firePropertyChange("move", toSwitch, hole);
                    } else {
                        this.KO();
                        throw new PropertyVetoException("Not legal!", evt);
                    }   break; 
            }
        }
    }
}
