/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JOptionPane;
import modelo.Conductor;
import util.HB;

/**
 *
 * @author LEMUEL
 */
public class FrmGestionConductor extends javax.swing.JDialog {

        Conductor c = new Conductor();
    HB h = new HB();
    private int accion = -1;
    private int id = -1;

    /**
     * Creates new form FrmGestionConductor
     */
    public FrmGestionConductor(java.awt.Frame parent, boolean modal, int accion, int id) {
        super(parent, modal);
        initComponents();this.accion = accion;
        this.id = id;
        if (accion!=HB.AGREGAR){
            c = (Conductor) h.consultaRegisro(Conductor.class, id);
            coloca(c);
        }
        String cadena = "";
        switch (accion){
            case HB.AGREGAR : cadena = "Alta ";
                              habilita(true);
                                       break;
            case HB.ACTUALIZAR: cadena = "Edita ";
                               habilita(true);
                                        break;
            case HB.ELIMINAR: cadena = "Elimina ";
                              habilita(false);
                              break;
            case HB.CONSULTAR: cadena = "Consulta ";
                               habilita(false);
                                         break;
        }
        cadena = cadena +"a un conductor";
        lblTitulo.setText(cadena);
        setTitle("Conductor");
        setLocationRelativeTo (parent);
        setResizable(false);
        setVisible(true);
    }

    
    private void coloca(Conductor c){
        txtNombre.setText(c.getNombre());
        txtApaterno.setText(c.getApaterno());
        txtAmaterno.setText(c.getAmaterno());
        txtTipoLicencia.setText(c.getTipoLicencia());
        txtNacionalidad.setText(c.getNacionalidad());
    }
    
    
    private void habilita (boolean b){
        txtNombre.setEnabled(b);
        txtApaterno.setEnabled(b);
        txtAmaterno.setEnabled(b);
        txtTipoLicencia.setEnabled(b);
        txtNacionalidad.setEnabled(b);
    }
    
    
    private boolean validar (){
        boolean bnd = false;
        if ("".equals(txtNombre.getText())){
            mensaje ("Falta escribir el nombre del pasajero");
            txtNombre.requestFocus();
        }else if ("".equals(txtApaterno.getText())){
            mensaje ("Falta escribir el apellido paterno del pasajero");
            txtApaterno.requestFocus();
        }else if ("".equals(txtAmaterno.getText())){
            mensaje ("Falta escribir el apellido  materno del pasajero");
            txtAmaterno.requestFocus();
        }else if ("".equals(txtTipoLicencia.getText())){
            mensaje ("Falta escribir la nacionalidad del pasajero");
            txtTipoLicencia.requestFocus();
        }else if ("".equals(txtNacionalidad.getText())){
            mensaje ("Falta escribir la nacionalidad del pasajero");
            txtNacionalidad.requestFocus();
        }else bnd = true;
        return bnd;
    }
    
    
    private void asigna(){
        c.setId(id);   
        c.setNombre(txtNombre.getText());
        c.setApaterno(txtApaterno.getText());
        c.setAmaterno(txtAmaterno.getText());
        c.setTipoLicencia(txtTipoLicencia.getText());
        c.setNacionalidad(txtNacionalidad.getText());
        
    }
    
     
    private void procesa(){
        if(validar()){
            asigna();
            if (h.ejecutaTx(c, Conductor.class, accion)){
                mensaje ("Se ejecutó la transacción correctamente");
                this.dispose();
            }
        
        }
    }
    
    private void mensaje (String cadena){
        JOptionPane.showMessageDialog(this, cadena);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApaterno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAmaterno = new javax.swing.JTextField();
        txtTipoLicencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNacionalidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Aceptar.png"))); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("jLabel1");
        lblTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido paterno");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApaternoKeyTyped(evt);
            }
        });

        jLabel1.setText("Apellido materno:");

        jLabel4.setText("Tipo de Licencia:");

        txtAmaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmaternoKeyTyped(evt);
            }
        });

        txtTipoLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoLicenciaActionPerformed(evt);
            }
        });
        txtTipoLicencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoLicenciaKeyTyped(evt);
            }
        });

        jLabel5.setText("Nacionalidad:");

        txtNacionalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNacionalidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtApaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(txtAmaterno)
                    .addComponent(txtTipoLicencia)
                    .addComponent(txtNacionalidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAmaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        procesa();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtTipoLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoLicenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoLicenciaActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(Character.isLetter(c) || (Character.isWhitespace(c))){
            
        }else{
            getToolkit().beep();
            evt.consume();
        }
        int n = 10;
        if(txtNombre.getText().length()>=n){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApaternoKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(Character.isLetter(c) || (Character.isWhitespace(c))){
            
        }else{
            getToolkit().beep();
            evt.consume();
        }
        int n = 10;
        if(txtApaterno.getText().length()>=n){
            evt.consume();
        }
    }//GEN-LAST:event_txtApaternoKeyTyped

    private void txtAmaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmaternoKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(Character.isLetter(c) || (Character.isWhitespace(c))){
            
        }else{
            getToolkit().beep();
            evt.consume();
        }
        int n = 10;
        if(txtAmaterno.getText().length()>=n){
            evt.consume();
        }
    }//GEN-LAST:event_txtAmaternoKeyTyped

    private void txtTipoLicenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoLicenciaKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(Character.isLetter(c) || (Character.isWhitespace(c))){
            
        }else{
            getToolkit().beep();
            evt.consume();
        }
        int n = 10;
        if(txtTipoLicencia.getText().length()>=n){
            evt.consume();
        }
    }//GEN-LAST:event_txtTipoLicenciaKeyTyped

    private void txtNacionalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNacionalidadKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(Character.isLetter(c) || (Character.isWhitespace(c))){
            
        }else{
            getToolkit().beep();
            evt.consume();
        }
        int n = 10;
        if(txtNacionalidad.getText().length()>=n){
            evt.consume();
        }
    }//GEN-LAST:event_txtNacionalidadKeyTyped

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtAmaterno;
    private javax.swing.JTextField txtApaterno;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTipoLicencia;
    // End of variables declaration//GEN-END:variables
}