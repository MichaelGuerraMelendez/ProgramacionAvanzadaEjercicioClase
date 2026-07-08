/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesrios_magm.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MICHAEL GUERRA
 */
public class ConsultasBD extends Conexion{
    PreparedStatement ps =null;
    String sentenciaSQL;
    Connection con = null;
    
    public boolean crearCliente(ClientesPOO clie){
        con = getConexion();
        sentenciaSQL = "INSERT INTO clientes(Codigo, Nombre, Direccion, Telefono, Estado) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, clie.getCodigo());
            ps.setString(2, clie.getNombre());
            ps.setString(3, clie.getDireccion());
            ps.setString(4, clie.getTelefono());
            ps.setString(5, clie.getEstado());
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE - CONS");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR CLIENTE - CONS"+ ex.getMessage());
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
            }
        }
    }
    
    
}
