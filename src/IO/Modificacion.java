/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import DAO.CoberturaDAO;
import DAO.ProvinciaDAO;
import Entity.Cober;
import Entity.Cobertura;
import Entity.Provincia;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Sebastian
 */
public class Modificacion extends javax.swing.JDialog {
private Cobertura cobertura;
LinkedList l;
int Selec;
int dias;
String nroRamo;
    /**
     * Creates new form Modificacion
     */
    public Modificacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public Modificacion(LinkedList lista,int seleccionado,int dias,String nroRamo,javax.swing.JFrame f,boolean b) {
        super(f,b);
        initComponents();
        l=lista;
        int seleccion=0;
        this.dias=dias;
        Selec=seleccionado;
        DecimalFormat df=new DecimalFormat("#.##");
        this.cobertura=(Cobertura)lista.get(seleccionado);
        this.txtTasa.setText(String.valueOf(df.format(this.cobertura.getTasa()).replace(",", ".")));
        this.txtSumaAsegurada.setText(String.valueOf(df.format(this.cobertura.getSumaAsegurada()).replace(",", ".")));
        
        CoberturaDAO cDAO=new CoberturaDAO();
        DefaultComboBoxModel v =new DefaultComboBoxModel();
        this.cmbCobertura.setModel(v);
    try {
        List <Cober> lcober = cDAO.ObtenerCobertura(nroRamo);
        
        for (int i=0;i<lcober.size();i++){
        if(lcober.get(i).getNombre().equals(this.cobertura.getNombre())){
        seleccion=i;
        }
        v.addElement(lcober.get(i));
       
        }
    } catch (Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    ProvinciaDAO pDAO=new ProvinciaDAO();
        DefaultComboBoxModel pv =new DefaultComboBoxModel();
        this.cmbProvincia.setModel(pv);
        int pSeleccionada=0;
        int j=0;
    try {
        List <Provincia> lProvincia = pDAO.ObtenerProvincia();
        
        for (int i=0;i<lProvincia.size();i++){
        
        pv.addElement(lProvincia.get(i));
       if(lProvincia.get(i).getId().equals(this.cobertura.getProvincia().getId())){
           pSeleccionada=j;
       }
       j++;
        }
    } catch (Exception ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
    
    
    
    
    
       this.cmbCobertura.setSelectedIndex(seleccion);
       this.cmbProvincia.setSelectedIndex(pSeleccionada);
       if (this.cobertura.getAjusteTasa().equals("Sin ajuste")){
       this.cmbAjustedeTasa.setSelectedIndex(0);
       
       }
       else if (this.cobertura.getAjusteTasa().equals("1%")){
           
           this.cmbAjustedeTasa.setSelectedIndex(1);
           
           
       DefaultComboBoxModel value=new DefaultComboBoxModel();
       this.cmbAjusteMensual.setModel(value);
       value.addElement("2,51%");
       value.addElement("5,67%");
       if(this.cobertura.getAjusteMensual().equals("2,51%")){
       this.cmbAjusteMensual.setSelectedIndex(0);
       }
       else{
       this.cmbAjusteMensual.setSelectedIndex(1);
       }
       }
       else{
       
       this.cmbAjustedeTasa.setSelectedIndex(2);
       
       DefaultComboBoxModel value=new DefaultComboBoxModel();
       this.cmbAjusteMensual.setModel(value);
       value.addElement("5,09%");
       value.addElement("11,75%");
       if(this.cobertura.getAjusteMensual().equals("5,09%")){
       this.cmbAjusteMensual.setSelectedIndex(0);
       }
       else{
       this.cmbAjusteMensual.setSelectedIndex(1);
       }
       
       }
       
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        cmbAjustedeTasa = new javax.swing.JComboBox();
        cmbCobertura = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbAjusteMensual = new javax.swing.JComboBox();
        txtTasa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSumaAsegurada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbProvincia = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Modificar");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        cmbAjustedeTasa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin ajuste", "1%", "2%" }));
        cmbAjustedeTasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAjustedeTasaActionPerformed(evt);
            }
        });

        cmbCobertura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel8.setText("Suma asegurada");

        jLabel7.setText("Ajuste de tasa");

        cmbAjusteMensual.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No aplica" }));
        cmbAjusteMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAjusteMensualActionPerformed(evt);
            }
        });

        jLabel9.setText("Tasa");

        txtSumaAsegurada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSumaAseguradaActionPerformed(evt);
            }
        });

        jLabel4.setText("Cobertura");

        jLabel6.setText("Ajuste mensual");

        jLabel2.setText("Provincia");

        cmbProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cmbAjusteMensual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbAjustedeTasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSumaAsegurada, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTasa, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(cmbProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSumaAsegurada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbAjustedeTasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAjusteMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        
        
        double Tasa;
        if(this.cmbAjustedeTasa.getSelectedIndex()==0){
        Tasa=Double.parseDouble(this.txtTasa.getText());
        }
        else{
        double ajuste=Double.parseDouble(String.valueOf(this.cmbAjusteMensual.getSelectedItem()).replace("%", "").replace(",", "."));
        Tasa=Double.parseDouble(this.txtTasa.getText())*((ajuste/100)+1);
        }
        double prima=((Double.parseDouble(this.txtSumaAsegurada.getText())*((Tasa/(double)1000)))/(double)365)*(dias);
        Cobertura c =new Cobertura(String.valueOf(this.cmbCobertura.getSelectedItem()), Double.parseDouble(this.txtSumaAsegurada.getText()), Double.parseDouble(this.txtTasa.getText()), String.valueOf(this.cmbAjustedeTasa.getSelectedItem()), prima,((Cober)this.cmbCobertura.getSelectedItem()).getClausulas(), String.valueOf(this.cmbAjusteMensual.getSelectedItem()),(Provincia)this.cmbProvincia.getSelectedItem());
        l.remove(Selec);
        l.add(Selec, c);
        Principal.setListaCoberturas(l);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbAjustedeTasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAjustedeTasaActionPerformed
        // TODO add your handling code here:
        if (this.cmbAjustedeTasa.getSelectedIndex()==0){
            DefaultComboBoxModel value=new DefaultComboBoxModel();
            this.cmbAjusteMensual.setModel(value);
            value.addElement("No aplica");
        }
        else if (this.cmbAjustedeTasa.getSelectedIndex()==1){
            DefaultComboBoxModel value=new DefaultComboBoxModel();
            this.cmbAjusteMensual.setModel(value);
            value.addElement("2,51%");
       value.addElement("5,67%");
       }
       else{
       DefaultComboBoxModel value=new DefaultComboBoxModel();
       this.cmbAjusteMensual.setModel(value);
       value.addElement("5,09%");
       value.addElement("11,75%");
       }
    }//GEN-LAST:event_cmbAjustedeTasaActionPerformed

    private void cmbAjusteMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAjusteMensualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAjusteMensualActionPerformed

    private void txtSumaAseguradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumaAseguradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumaAseguradaActionPerformed

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
            java.util.logging.Logger.getLogger(Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Modificacion dialog = new Modificacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbAjusteMensual;
    private javax.swing.JComboBox cmbAjustedeTasa;
    private javax.swing.JComboBox cmbCobertura;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtSumaAsegurada;
    private javax.swing.JTextField txtTasa;
    // End of variables declaration//GEN-END:variables
}
