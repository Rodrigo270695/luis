
package cadaData;

import capaNegocio.Modelo;
import capaNegocio.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class VehiculoControlador {
    
    ModeloControlador modeloc = new ModeloControlador();
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";
    
    public List listar() {
        
        List lista = new ArrayList();
        sql = "SELECT * FROM vehiculo";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setVehiculoId(rs.getInt(1));
                vehiculo.setMatricula(rs.getString(2));
                vehiculo.setMarca(rs.getString(3)); 
                vehiculo.setColor(rs.getString(4)); 
                vehiculo.setAnio(rs.getShort(5));
                vehiculo.setModelo((Modelo) modeloc.obtenerdato(rs.getInt(6)));
                vehiculo.setEstado(rs.getString(7).charAt(0));
                lista.add(vehiculo);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

        return lista;
        
    }
    
}
