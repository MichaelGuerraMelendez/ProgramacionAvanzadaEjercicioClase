package abarrotesrios_magm.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private final String db = "bd_abarroteria_rios_magm";
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/" + db;
    private Connection c = null;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("CONEXION REALIZADA CORRECTAMENTE");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: No se encontró el driver - " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: No se pudo conectar a la BD - " + ex.getMessage());
        }
        
        return c;
    }
    
    public static void main(String[] args){
        Conexion con = new Conexion();
        con.getConexion();
    }       
}