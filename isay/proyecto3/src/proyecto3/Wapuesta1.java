/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author isayd
 */
public class Wapuesta1 extends javax.swing.JFrame {

    /**
     * Creates new form Wapuesta1
     */
    public Wapuesta1(Equipos A, Equipos B) {
        initComponents();
        
        ImageIcon imagen1 = new ImageIcon(getClass().getResource(A.getImagen())); 
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(EquipoA.getWidth(), EquipoA.getHeight(), Image.SCALE_DEFAULT));
        EquipoA.setIcon(fondo1);
       
        ImageIcon imagen2 = new ImageIcon(getClass().getResource(B.getImagen()));
        Icon fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(EquipoB.getWidth(),EquipoB.getHeight(),Image.SCALE_DEFAULT));
        EquipoB.setIcon(fondo2);
        
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/proyecto3/Fondillo.jpg"));
        Icon fondo3 = new ImageIcon(imagen3.getImage().getScaledInstance(Fondo.getWidth(),Fondo.getHeight(),Image.SCALE_DEFAULT));
        Fondo.setIcon(fondo3);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Proyecto 3");
        this.setResizable(false);
        
        EquipoA.setContentAreaFilled(false);
        EquipoB.setContentAreaFilled(false);
         TextPrompt placeholder = new TextPrompt("$0.00", Apostado);
         placeholder.changeAlpha(0.75f);
         placeholder.changeStyle(Font.ITALIC);
         
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        EquipoB = new javax.swing.JButton();
        EquipoA = new javax.swing.JButton();
        Apostado = new javax.swing.JTextField();
        Fondo = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EquipoB.setText("jButton1");
        getContentPane().add(EquipoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 240, 260));

        EquipoA.setText("jButton1");
        EquipoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipoAActionPerformed(evt);
            }
        });
        getContentPane().add(EquipoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 260));
        getContentPane().add(Apostado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 240, 40));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 575, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EquipoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipoAActionPerformed
        String dato;
        dato = this.Apostado.getText();
        if(isNumeric(dato) == true){
            //Guardamos en el de apuestas y esperamos
        }else{
            JOptionPane.showMessageDialog(null, "No es un valor valido");
        }
        
    }//GEN-LAST:event_EquipoAActionPerformed
    
    private void EquipoBActionPerformed(java.awt.event.ActionEvent evt){
        String dato;
        dato = this.Apostado.getText();
        if(isNumeric(dato) == true){
            //Guardamos en el de apuestas y esperamos
        }else{
            JOptionPane.showMessageDialog(null, "No es un valor valido");
        }
    
    }
    
    public boolean isNumeric(String cadena){
        try{
            Double.parseDouble(cadena);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Equipos Atl = new Equipos("Atlanta Reign", 200, "Atlanta.png");
        Equipos Seoul = new Equipos("Seoul Dynasty", 210, "Seoul.png");
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
            java.util.logging.Logger.getLogger(Wapuesta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wapuesta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wapuesta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wapuesta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wapuesta1(Atl, Seoul).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apostado;
    private javax.swing.JButton EquipoA;
    private javax.swing.JButton EquipoB;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
