
package cadaData;

import java.sql.*;

public class Conexion {
    
    private final String URL ="jdbc:mysql://localhost:3308/bd_caritas";
    private final String USUARIO ="root";
    private final String PASSWORD ="admin";
    
    public Connection conectar(){
        
        Connection con = null;
        
        try {
            
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexión Exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar");
            e.printStackTrace(System.err);
        }
        
        return con;
    }
    
}
