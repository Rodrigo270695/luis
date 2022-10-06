package capaCliente;

import cadaData.VehiculoControlador;
import capaNegocio.Vehiculo;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FrmGestionarVehiculo extends javax.swing.JInternalFrame {

    VehiculoControlador vehiculoC = new VehiculoControlador();

    public FrmGestionarVehiculo() {
        initComponents();
        listar();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(tblListado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    // End of variables declaration//GEN-END:variables
}
