package capaCliente;

import cadaData.ModeloControlador;
import cadaData.VehiculoControlador;
import capaNegocio.Modelo;
import capaNegocio.Vehiculo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmGestionarVehiculo extends javax.swing.JInternalFrame {

    VehiculoControlador vehiculoC = new VehiculoControlador();
    ModeloControlador modeloC = new ModeloControlador();
    int idVehiculo = 0;
    String matricula = "";

    public FrmGestionarVehiculo() {
        initComponents();
        cargarModelos();
        listar();
    }
    
    void cargarModelos(){
        
        cbxModelo.removeAllItems();
        
        List<Modelo> lista = modeloC.listar();
        
        for (Modelo modelo : lista) {
            cbxModelo.addItem(modelo.getNombre());
        }
        
    }

    void listar() {

        String columas[] = {"ID", "MATRICULA", "MARCA", "COLOR", "AÑO", "MODELO"};
        DefaultTableModel modelo = new DefaultTableModel();

        for (String columa : columas) {
            modelo.addColumn(columa);
        }

        List<Vehiculo> lista = vehiculoC.listar();
        Object obj[] = new Object[6];

        for (Vehiculo vehiculo : lista) {
            obj[0] = vehiculo.getVehiculoId();
            obj[1] = vehiculo.getMatricula();
            obj[2] = vehiculo.getMarca();
            obj[3] = vehiculo.getColor();
            obj[4] = vehiculo.getAnio();
            obj[5] = vehiculo.getModelo().getNombre();

            if (vehiculo.getEstado() == 'A') {
                modelo.addRow(obj);
            }

        }

        tblListado.setModel(modelo);

    }

    void limpiarCajas() {
        txtAnio.setText("");
        txtBuscar.setText("");
        txtColor.setText("");
        txtMarca.setText("");
        txtMatricula.setText("");
        cbxModelo.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnDarBaja = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxModelo = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        jLabel1.setText("Matricula:");

        jLabel2.setText("Marca:");

        jLabel3.setText("Color:");

        jLabel4.setText("Año:");

        jLabel5.setText("Buscar:");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnDarBaja.setText("Dar Baja");
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });

        jLabel6.setText("Modelo:");

        cbxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(366, 366, 366))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(35, 35, 35)
                                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegistrar)
                                    .addComponent(btnDarBaja))
                                .addGap(19, 19, 19))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cbxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDarBaja)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (txtMatricula.getText().length() == 0 | txtAnio.getText().length() == 0 | txtMarca.getText().length() == 0 | txtColor.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe llenar los campos");
        } else {

            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setMatricula(txtMatricula.getText());
            vehiculo.setMarca(txtMarca.getText());
            vehiculo.setColor(txtColor.getText());
            vehiculo.setAnio(Short.parseShort(txtAnio.getText()));
            vehiculo.setModelo(modeloC.obtenerdato(cbxModelo.getSelectedItem().toString()));

            try {

                vehiculoC.registrar(vehiculo);
                JOptionPane.showMessageDialog(this, "Vehiculo registrado");
                listar();
                limpiarCajas();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed
        
        if (idVehiculo == 0) {
            JOptionPane.showMessageDialog(this, "Debe selecionar un vehiculo");
        }else{
            
            int r = JOptionPane.showConfirmDialog(this, "¿está seguro de dar de baja a la matrícula "+matricula+"?", "CONFIRMAR", 2);
            
            if (r == 0) {
                vehiculoC.darBaja(idVehiculo);
                listar();
                limpiarCajas();
            }
        }
        
        
    }//GEN-LAST:event_btnDarBajaActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        
        int fila = tblListado.getSelectedRow();
        
        idVehiculo =  Integer.parseInt(tblListado.getValueAt(fila, 0).toString());
        matricula = tblListado.getValueAt(fila, 1).toString();
        
    }//GEN-LAST:event_tblListadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
