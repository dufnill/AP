/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eightpuzzle;



import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author dufnill
 */
public class EightBoard extends javax.swing.JFrame implements PropertyChangeListener, Serializable{

    /**
     * Creates new form EightBoard
     */
    public EightBoard() {
        initComponents();
        
        eightTile1.addVetoableChangelistener(eightController1);
        eightTile2.addVetoableChangelistener(eightController1);
        eightTile3.addVetoableChangelistener(eightController1);
        eightTile4.addVetoableChangelistener(eightController1);
        eightTile5.addVetoableChangelistener(eightController1);
        eightTile6.addVetoableChangelistener(eightController1);
        eightTile7.addVetoableChangelistener(eightController1);
        eightTile8.addVetoableChangelistener(eightController1);
        eightTile9.addVetoableChangelistener(eightController1);
        eightTile10.addVetoableChangelistener(eightController1);
        eightTile12.addVetoableChangelistener(eightController1);
        
        /*eightTile1.addPropertyChangelistener(this);
        eightTile2.addPropertyChangelistener(this);
        eightTile3.addPropertyChangelistener(this);
        eightTile4.addPropertyChangelistener(this);
        eightTile5.addPropertyChangelistener(this);
        eightTile6.addPropertyChangelistener(this);
        eightTile7.addPropertyChangelistener(this);
        eightTile8.addPropertyChangelistener(this);
        eightTile9.addPropertyChangelistener(this);
        eightTile10.addPropertyChangelistener(this);
        eightTile12.addPropertyChangelistener(this);*/
        
        eightController1.addPropertyChangelistener(this);

        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eightTile1 = new eightpuzzle.EightTile(1);
        eightTile2 = new eightpuzzle.EightTile(2);
        eightTile3 = new eightpuzzle.EightTile(3);
        eightTile4 = new eightpuzzle.EightTile(4);
        eightTile5 = new eightpuzzle.EightTile(5);
        eightTile6 = new eightpuzzle.EightTile(6);
        eightTile7 = new eightpuzzle.EightTile(7);
        eightTile8 = new eightpuzzle.EightTile(8);
        eightTile9 = new eightpuzzle.EightTile(9);
        eightTile10 = new eightpuzzle.EightTile();
        eightTile12 = new eightpuzzle.EightTile();
        eightController1 = new eightpuzzle.EightController();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(520, 620));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        eightTile1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile1.setLab(arr_new.remove(j));*/
        eightTile1.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile1.setText(Integer.toString(eightTile8.getLab()));
        eightTile1.setContentAreaFilled(false);
        eightTile1.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile1.setOpaque(true);
        eightTile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile1ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile1);
        tiles.add(eightTile1);

        eightTile2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile2.setLab(arr_new.remove(j));*/
        eightTile2.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile2.setText("");
        eightTile2.setContentAreaFilled(false);
        eightTile2.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile2.setOpaque(true);
        eightTile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile2ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile2);
        tiles.add(eightTile2);

        eightTile3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile3.setLab(arr_new.remove(j));*/
        eightTile3.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile3.setText(Integer.toString(eightTile8.getLab()));
        eightTile3.setContentAreaFilled(false);
        eightTile3.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile3.setOpaque(true);
        eightTile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile3ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile3);
        tiles.add(eightTile3);

        eightTile4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile4.setLab(arr_new.remove(j));*/
        eightTile4.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile4.setText(Integer.toString(eightTile8.getLab()));
        eightTile4.setContentAreaFilled(false);
        eightTile4.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile4.setOpaque(true);
        eightTile4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile4ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile4);
        tiles.add(eightTile4);

        eightTile5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile5.setLab(arr_new.remove(j));*/
        eightTile5.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile5.setText(Integer.toString(eightTile8.getLab()));
        eightTile5.setContentAreaFilled(false);
        eightTile5.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile5.setOpaque(true);
        eightTile5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile5ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile5);
        tiles.add(eightTile5);

        eightTile6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile6.setLab(arr_new.remove(j));*/
        eightTile6.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile6.setText(Integer.toString(eightTile8.getLab()));
        eightTile6.setContentAreaFilled(false);
        eightTile6.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile6.setOpaque(true);
        eightTile6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile6ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile6);
        tiles.add(eightTile6);

        eightTile7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile7.setLab(arr_new.remove(j));*/
        eightTile7.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile7.setText(Integer.toString(eightTile8.getLab()));
        eightTile7.setContentAreaFilled(false);
        eightTile7.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile7.setOpaque(true);
        eightTile7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile7ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile7);
        tiles.add(eightTile7);

        eightTile8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile8.setLab(arr_new.remove(j));*/
        eightTile8.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile8.setText(Integer.toString(eightTile8.getLab()));
        eightTile8.setContentAreaFilled(false);
        eightTile8.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile8.setOpaque(true);
        eightTile8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile8ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile8);
        tiles.add(eightTile8);

        eightTile9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        /*j = (int)((Math.random()*arr_new.size()));
        eightTile9.setLab(arr_new.remove(j));*/
        eightTile9.setForeground(java.awt.SystemColor.controlDkShadow);
        eightTile9.setText(Integer.toString(eightTile8.getLab()));
        eightTile9.setContentAreaFilled(false);
        eightTile9.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        eightTile9.setOpaque(true);
        eightTile9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile9ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile9);
        tiles.add(eightTile9);

        eightTile10.setBackground(new java.awt.Color(255, 204, 102));
        eightTile10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        eightTile10.setText("Restart");
        eightTile10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile10ActionPerformed(evt);
            }
        });

        eightTile12.setBackground(new java.awt.Color(153, 255, 204));
        eightTile12.setText("Flip");
        eightTile12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile12ActionPerformed(evt);
            }
        });

        eightController1.setBackground(new java.awt.Color(153, 255, 153));
        eightController1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        eightController1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eightController1.setText("START!");
        eightController1.setToolTipText("");
        eightController1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eightController1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eightTile10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eightController1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eightTile12, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eightTile10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(eightTile12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eightController1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        this.startGame();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eightTile12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile12ActionPerformed
        
        System.out.println("Button pressed");
        eightTile12.flip(eightTile1, eightTile2);
    }//GEN-LAST:event_eightTile12ActionPerformed
   
    private void eightTile10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile10ActionPerformed
        this.startGame();
    }//GEN-LAST:event_eightTile10ActionPerformed

    private void eightTile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile1ActionPerformed
        eightTile1.move();
        
    }//GEN-LAST:event_eightTile1ActionPerformed

    private void eightTile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile2ActionPerformed
       eightTile2.move(); // TODO add your handling code here:
    }//GEN-LAST:event_eightTile2ActionPerformed

    private void eightTile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile3ActionPerformed
        eightTile3.move(); // TODO add your handling code here:
    }//GEN-LAST:event_eightTile3ActionPerformed

    private void eightTile4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile4ActionPerformed
        eightTile4.move();// TODO add your handling code here:
    }//GEN-LAST:event_eightTile4ActionPerformed

    private void eightTile5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile5ActionPerformed
        eightTile5.move();// TODO add your handling code here:
    }//GEN-LAST:event_eightTile5ActionPerformed

    private void eightTile6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile6ActionPerformed
        eightTile6.move();// TODO add your handling code here:
    }//GEN-LAST:event_eightTile6ActionPerformed

    private void eightTile7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile7ActionPerformed
        eightTile7.move();// TODO add your handling code here:
    }//GEN-LAST:event_eightTile7ActionPerformed

    private void eightTile8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile8ActionPerformed
        eightTile8.move();// TODO add your handling code here:
    }//GEN-LAST:event_eightTile8ActionPerformed

    private void eightTile9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile9ActionPerformed
        eightTile9.move();// TODO add your handling code here:
    }//GEN-LAST:event_eightTile9ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EightBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private eightpuzzle.EightController eightController1;
    private eightpuzzle.EightTile eightTile1;
    private eightpuzzle.EightTile eightTile10;
    private eightpuzzle.EightTile eightTile12;
    private eightpuzzle.EightTile eightTile2;
    private eightpuzzle.EightTile eightTile3;
    private eightpuzzle.EightTile eightTile4;
    private eightpuzzle.EightTile eightTile5;
    private eightpuzzle.EightTile eightTile6;
    private eightpuzzle.EightTile eightTile7;
    private eightpuzzle.EightTile eightTile8;
    private eightpuzzle.EightTile eightTile9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private int j;
    int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
    ArrayList<Integer> arr_new = new ArrayList<Integer>();
    ArrayList<EightTile> tiles = new ArrayList<EightTile>();
    
    private void startGame(){
        
        for (int i : arr){
            arr_new.add(i);
        }
        
        for (EightTile e: tiles){
            
            j = (int)((Math.random()*arr_new.size()));
            e.setLab(arr_new.remove(j));
            if (e.getLab() == 9) eightController1.setHole(e);
            
        }        
        eightController1.setBackground(new java.awt.Color(255, 255, 140));
        eightController1.setText("START!");
       
    }
    
    private void switcha(EightTile left, EightTile right){
        
        int sx = left.getLab();
        int dx = right.getLab();
        left.setLab(dx);
        right.setLab(sx);
        
    }

    public void propertyChange(PropertyChangeEvent pce) {
        
        EightTile right = (EightTile) pce.getNewValue();
        EightTile left = (EightTile) pce.getOldValue();
        
        if (pce.getPropertyName().equals("flip")){
            this.switcha(left, right);
        } else if (pce.getPropertyName().equals("move")){
            this.switcha(left, right);
            eightController1.setHole(left);
        }      
    }  
}
