
package cadaData;

import capaNegocio.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloControlador {
    
    Conexion estado = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = "";
    
    public List listar() {
        
        List lista = new ArrayList();
        sql = "SELECT * FROM modelo";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setModeloId(rs.getByte(1));
                modelo.setNombre(rs.getString(2));
                lista.add(modelo);
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
    
    public Modelo obtenerdato(int id) {
        
        Modelo modelo = new Modelo();
        sql = "SELECT * FROM modelo WHERE modelo_id = "+id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                modelo.setModeloId(rs.getInt(1));
                modelo.setNombre(rs.getString(2));
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

        return modelo;
    }
    
    public Modelo obtenerdato(String nombre) {
        
        Modelo modelo = new Modelo();
        sql = "SELECT * FROM modelo WHERE nombre = '"+nombre+"'";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                modelo.setModeloId(rs.getInt(1));
                modelo.setNombre(rs.getString(2));
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

        return modelo;
    }
}
