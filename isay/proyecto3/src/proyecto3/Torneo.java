package proyecto3;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Torneo extends javax.swing.JFrame {
 //Auxiliares
public Equipos[] arreglos;
    
//Inicio
public static Equipos A;
public static Equipos B;
public static Equipos C;
public static Equipos D;
public static Equipos E;
public static Equipos F;
public static Equipos G;
public static Equipos H;

//Semifinal
public static Equipos semi1;
public static Equipos semi2;
public static Equipos semi3;
public static Equipos semi4;

//Final
public static Equipos last1;
public static Equipos last2;

//Ganador
public Equipos winner;
    /**
     * Creates new form Torneo
     */

    public Torneo() {
        Equipos Seoul = new Equipos("Seoul Dynasty", 200, "Seoul.png");
        Equipos Houston = new Equipos("Houston Outlaws", 180, "Houston.png");
        Equipos LAG = new Equipos("LA Gladiator", 210, "LosAngeles.png");
        Equipos NY = new Equipos("New York Excelsior", 240, "New York.png");
        Equipos Phily = new Equipos("Philadelphia Fusion", 230, "Philadelphia.png");
        Equipos Shangai = new Equipos("Shangai Dragons", 190, "Shangai.png");
        Equipos Vanc = new Equipos("Vancouver Titans", 215,"Vancouver.png");
        Equipos Atl = new Equipos("Atlanta Reign", 224, "Atlanta.png");     
        Equipos [] arreglos2 ={Seoul,Houston,LAG, NY, Phily, Shangai, Vanc, Atl};
        this.arreglos = arreglos2;

       initComponents();
               
        ImageIcon imagen = new ImageIcon(getClass().getResource("/proyecto3/king.jpg"));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(Fondo.getWidth(),Fondo.getHeight(),Image.SCALE_DEFAULT));
        Fondo.setIcon(fondo);
        
        acomodarEquipos();

        //Aqui van nuestros diseños de los cuadros
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Overwatch League");
        this.setResizable(false);
    }
    
    
    public void acomodarEquipos(){
        Random obj = new Random(arreglos);
        Equipos [] temp = obj.revuelve();
            A = temp[0];
            B = temp[1];
            C = temp[2];
            D = temp[3];
            E = temp[4];
            F = temp[5];
            G = temp[6];
            H = temp[7];
        ImageIcon imagen2 = new ImageIcon(getClass().getResource(A.getImagen()));
        Icon fondo1 = new ImageIcon(imagen2.getImage().getScaledInstance(Cua1.getWidth(),Cua1.getHeight(),Image.SCALE_DEFAULT));
        Cua1.setIcon(fondo1);
        
        ImageIcon imagen3 = new ImageIcon(getClass().getResource(B.getImagen()));
        Icon fondo2 = new ImageIcon(imagen3.getImage().getScaledInstance(Cua2.getWidth(),Cua2.getHeight(),Image.SCALE_DEFAULT));
        Cua2.setIcon(fondo2);
        
        ImageIcon imagen4 = new ImageIcon(getClass().getResource(C.getImagen()));
        Icon fondo3 = new ImageIcon(imagen4.getImage().getScaledInstance(Cua3.getWidth(),Cua3.getHeight(),Image.SCALE_DEFAULT));
        Cua3.setIcon(fondo3);
        
        ImageIcon imagen5 = new ImageIcon(getClass().getResource(D.getImagen()));
        Icon fondo4 = new ImageIcon(imagen5.getImage().getScaledInstance(Cua4.getWidth(),Cua4.getHeight(),Image.SCALE_DEFAULT));
        Cua4.setIcon(fondo4);
        
        ImageIcon imagen6 = new ImageIcon(getClass().getResource(E.getImagen()));
        Icon fondo5 = new ImageIcon(imagen6.getImage().getScaledInstance(Cua5.getWidth(),Cua5.getHeight(),Image.SCALE_DEFAULT));
        Cua5.setIcon(fondo5);
        
        ImageIcon imagen7 = new ImageIcon(getClass().getResource(F.getImagen()));
        Icon fondo6 = new ImageIcon(imagen7.getImage().getScaledInstance(Cua6.getWidth(),Cua6.getHeight(),Image.SCALE_DEFAULT));
        Cua6.setIcon(fondo6);
        
        ImageIcon imagen8 = new ImageIcon(getClass().getResource(G.getImagen()));
        Icon fondo7 = new ImageIcon(imagen8.getImage().getScaledInstance(Cua7.getWidth(),Cua7.getHeight(),Image.SCALE_DEFAULT));
        Cua7.setIcon(fondo7);
        
        ImageIcon imagen9 = new ImageIcon(getClass().getResource(H.getImagen()));
        Icon fondo8 = new ImageIcon(imagen9.getImage().getScaledInstance(Cua8.getWidth(),Cua8.getHeight(),Image.SCALE_DEFAULT));
        Cua8.setIcon(fondo8);
        
    }

    public void cuartos(){
        Probabilidad prob1 = new Probabilidad(A,B);
        Probabilidad prob2 = new Probabilidad(C,D);
        Probabilidad prob3 = new Probabilidad(E,F);
        Probabilidad prob4 = new Probabilidad(G,H);
        semi1 = prob1.ganador();
        semi2 = prob2.ganador();
        semi3 = prob3.ganador();
        semi4 = prob4.ganador();

         ImageIcon imagen10 = new ImageIcon(getClass().getResource(semi1.getImagen())); 
        Icon fondo9 = new ImageIcon(imagen10.getImage().getScaledInstance(Semi1.getWidth(), Semi1.getHeight(), Image.SCALE_DEFAULT));
        Semi1.setIcon(fondo9);
        
        ImageIcon imagen11 = new ImageIcon(getClass().getResource(semi2.getImagen())); 
        Icon fondo10 = new ImageIcon(imagen11.getImage().getScaledInstance(Semi2.getWidth(), Semi2.getHeight(), Image.SCALE_DEFAULT));
        Semi2.setIcon(fondo10);
        
        ImageIcon imagen12 = new ImageIcon(getClass().getResource(semi3.getImagen())); 
        Icon fondo11 = new ImageIcon(imagen12.getImage().getScaledInstance(Semi3.getWidth(), Semi3.getHeight(), Image.SCALE_DEFAULT));
        Semi3.setIcon(fondo11);
        
        ImageIcon imagen13 = new ImageIcon(getClass().getResource(semi4.getImagen())); 
        Icon fondo12 = new ImageIcon(imagen13.getImage().getScaledInstance(Semi4.getWidth(), Semi4.getHeight(), Image.SCALE_DEFAULT));
        Semi4.setIcon(fondo12);
    }
    
    public void semifinal(){
        Probabilidad prob5 = new Probabilidad(semi1,semi2);
        Probabilidad prob6 = new Probabilidad(semi3,semi4);
        last1 = prob5.ganador();
        last2 = prob6.ganador();
        
        ImageIcon imagen14 = new ImageIcon(getClass().getResource(last1.getImagen())); 
        Icon fondo13 = new ImageIcon(imagen14.getImage().getScaledInstance(Last1.getWidth(), Last1.getHeight(), Image.SCALE_DEFAULT));
        Last1.setIcon(fondo13);
        
        ImageIcon imagen15 = new ImageIcon(getClass().getResource(last2.getImagen())); 
        Icon fondo14 = new ImageIcon(imagen15.getImage().getScaledInstance(Last2.getWidth(), Last2.getHeight(), Image.SCALE_DEFAULT));
        Last2.setIcon(fondo14);
        
        
    }
    
    public void last(){
        Probabilidad prob7 = new Probabilidad(last1,last2);
        winner = prob7.ganador();
        
        ImageIcon imagen16 = new ImageIcon(getClass().getResource(winner.getImagen())); 
        Icon fondo15 = new ImageIcon(imagen16.getImage().getScaledInstance(Winner.getWidth(), Winner.getHeight(), Image.SCALE_DEFAULT));
        Winner.setIcon(fondo15);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cua2 = new javax.swing.JLabel();
        Cua1 = new javax.swing.JLabel();
        Cua3 = new javax.swing.JLabel();
        Cua5 = new javax.swing.JLabel();
        Cua4 = new javax.swing.JLabel();
        Cua6 = new javax.swing.JLabel();
        Cua7 = new javax.swing.JLabel();
        Cua8 = new javax.swing.JLabel();
        Semi1 = new javax.swing.JLabel();
        Semi2 = new javax.swing.JLabel();
        Semi3 = new javax.swing.JLabel();
        Semi4 = new javax.swing.JLabel();
        Last1 = new javax.swing.JLabel();
        Last2 = new javax.swing.JLabel();
        Winner = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setTitle("Torneo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Cua2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 110, 50));
        getContentPane().add(Cua1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 110, 50));
        getContentPane().add(Cua3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 110, 50));
        getContentPane().add(Cua5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, 110, 50));
        getContentPane().add(Cua4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 110, 50));
        getContentPane().add(Cua6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, 110, 50));
        getContentPane().add(Cua7, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 520, 110, 50));
        getContentPane().add(Cua8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 520, 110, 50));
        getContentPane().add(Semi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 110, 50));
        getContentPane().add(Semi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 110, 50));
        getContentPane().add(Semi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 110, 50));
        getContentPane().add(Semi4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 380, 110, 50));
        getContentPane().add(Last1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 110, 50));
        getContentPane().add(Last2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 110, 50));
        getContentPane().add(Winner, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 110, 50));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto3/king.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Torneo().setVisible(true);
            }
        });
        //Agregando
        
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cua1;
    private javax.swing.JLabel Cua2;
    private javax.swing.JLabel Cua3;
    private javax.swing.JLabel Cua4;
    private javax.swing.JLabel Cua5;
    private javax.swing.JLabel Cua6;
    private javax.swing.JLabel Cua7;
    private javax.swing.JLabel Cua8;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Last1;
    private javax.swing.JLabel Last2;
    private javax.swing.JLabel Semi1;
    private javax.swing.JLabel Semi2;
    private javax.swing.JLabel Semi3;
    private javax.swing.JLabel Semi4;
    private javax.swing.JLabel Winner;
    // End of variables declaration//GEN-END:variables
}
