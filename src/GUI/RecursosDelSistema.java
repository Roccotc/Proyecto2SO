
package GUI;

import Logica.Proceso;
import Logica.Recurso;

public class RecursosDelSistema extends javax.swing.JFrame {

    
    private Proceso VectorDeProcesos[]; 
    private Recurso VectorDeRecursos[];
    private int idRecurso = 0;
    



    
    public RecursosDelSistema(Recurso[] vecRecursos, Proceso[] vecProcesos) {

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ListaNuevosRecursos.removeAllItems();
        this.VectorDeProcesos = vecProcesos;
        this.VectorDeRecursos = vecRecursos;
    }

    private RecursosDelSistema() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CantidadRecurso = new javax.swing.JTextField();
        NombreRecurso = new javax.swing.JTextField();
        ListaNuevosRecursos = new javax.swing.JComboBox();
        AgregarRecurso = new javax.swing.JButton();
        Iniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recursos del Sistema");

        jLabel1.setFont(new java.awt.Font("TI-Nspire Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("Recursos del Sistema");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        AgregarRecurso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        AgregarRecurso.setText("Agregar");
        AgregarRecurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgregarRecursoMouseClicked(evt);
            }
        });

        Iniciar.setBackground(new java.awt.Color(102, 255, 102));
        Iniciar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Iniciar.setText("Iniciar");
        Iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarMouseClicked(evt);
            }
        });

        jLabel4.setText("Lista de Recursos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NombreRecurso)
                                .addComponent(CantidadRecurso, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AgregarRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(ListaNuevosRecursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreRecurso)
                    .addComponent(AgregarRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CantidadRecurso)
                        .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ListaNuevosRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarMouseClicked
        // TODO add your handling code here:
        InterfazPrincipal main = new InterfazPrincipal(VectorDeProcesos,VectorDeRecursos);
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_IniciarMouseClicked

    private void AgregarRecursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarRecursoMouseClicked
        // TODO add your handling code here:
      if(!"".equals(NombreRecurso.getText()) && !"".equals(CantidadRecurso.getText()))
       {
        Recurso r = new Recurso ();
        r.setNombre(NombreRecurso.getText());
        r.setCantRecurso(Integer.parseInt(CantidadRecurso.getText()));
        ListaNuevosRecursos.addItem(NombreRecurso.getText());
        VectorDeRecursos [idRecurso] = r;
        idRecurso++;
        NombreRecurso.setText("");
        CantidadRecurso.setText("");
        
       }
        
        
        
    }//GEN-LAST:event_AgregarRecursoMouseClicked

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
            java.util.logging.Logger.getLogger(RecursosDelSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecursosDelSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecursosDelSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecursosDelSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecursosDelSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarRecurso;
    private javax.swing.JTextField CantidadRecurso;
    private javax.swing.JButton Iniciar;
    private javax.swing.JComboBox ListaNuevosRecursos;
    private javax.swing.JTextField NombreRecurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
