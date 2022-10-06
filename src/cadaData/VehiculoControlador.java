package cadaData;

import capaNegocio.Modelo;
import capaNegocio.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.postgresql.util.PSQLException;

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

    public void registrar(Vehiculo vehiculo) throws Exception {

        sql = "insert into vehiculo(matricula,marca,color,anio,modelo_id) values(?,?,?,?,?)";

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getMatricula());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getColor());
            ps.setInt(4, vehiculo.getAnio());
            ps.setInt(5, vehiculo.getModelo().getModeloId());
            ps.executeUpdate();

        } catch (PSQLException pe) {
            throw new Exception("Ya existe el vehiculo");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

    }

    public void darBaja(int id) {

        sql = "UPDATE vehiculo SET estado = 'I' WHERE vehiculo_id = " + id;

        try {

            con = estado.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
            }
        }

    }

    public List buscar(String texto) {

        List lista = new ArrayList();
        sql = "select * from vehiculo where matricula like '%"+texto+"%' \n"
                + "or marca like '%"+texto+"%'\n"
                + "or color like '%"+texto+"%'";

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
