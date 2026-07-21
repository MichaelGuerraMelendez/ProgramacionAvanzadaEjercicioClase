/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesrios_magm.modelo;
import abarrotesrios_magm.vista.ClientesPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MICHAEL GUERRA
 */
public class ConsultasBD extends Conexion{
    PreparedStatement ps =null;
    ResultSet rs = null;
    String sentenciaSQL;
    Connection con = null;
    ClientesPOO cli;
    
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
    
    //LEER CLIENTES
    public ArrayList<ClientesPOO> leerTodos() {
        ArrayList clientes = new ArrayList();
        con = getConexion();
        sentenciaSQL = "SELECT * FROM clientes";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli = new ClientesPOO();
                cli.setCodigo(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setDireccion(rs.getString(3));
                cli.setTelefono(rs.getString(4));
                clientes.add(cli);
            }
        con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo leer los datos" + ex.getMessage());
        }
        return clientes;
    }
    
    
    //LEER CLIENTE POR CODIGO
        public boolean leerCliente(ClientesPOO clie) {
        con = getConexion();
        sentenciaSQL = "SELECT * FROM clientes WHERE codigo = ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, clie.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {
                clie.setCodigo(rs.getInt(1));
                clie.setNombre(rs.getString(2));
                clie.setDireccion(rs.getString(3));
                clie.setTelefono(rs.getString(4));
                return true;
            }

            return false;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER CLIENTE - CONS: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
      
    public boolean modificarClientes(ClientesPOO clie){
        con = getConexion();
        sentenciaSQL = "UPDATE clientes SET nombre =? , direccion =? , telefono =? WHERE codigo =? ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            
            ps.setString(1, clie.getNombre());
            ps.setString(2, clie.getDireccion());
            ps.setString(3, clie.getTelefono());
            ps.setInt(4, clie.getCodigo());

            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE - CONS");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL CLIENTE - CONS"+ ex.getMessage());
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
    
    //EliminarCliente
    public boolean eliminarClientes(ClientesPOO clie){
        con = getConexion();
        sentenciaSQL = "DELETE FROM clientes WHERE codigo =? ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            
            ps.setInt(1, clie.getCodigo());

            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS CORRECTAMENTE - CONS");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL CLIENTE - CONS"+ ex.getMessage());
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
    
    
    public boolean crearProveedor(ProveedorPOO prov) {
        con = getConexion();
        sentenciaSQL = "INSERT INTO proveedores(Codigo, Nombre, Direccion, Telefono, Estado) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, prov.getCodigo());
            ps.setString(2, prov.getNombre());
            ps.setString(3, prov.getDireccion());
            ps.setString(4, prov.getTelefono());
            ps.setString(5, prov.getEstado());
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE - CONS");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR PROVEEDOR - CONS " + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
            }
        }
    }
    
    // LEER PROVEEDORES
    public ArrayList<ProveedorPOO> leerTodosProveedores() {
        ArrayList<ProveedorPOO> proveedores = new ArrayList<>();
        con = getConexion();
        sentenciaSQL = "SELECT * FROM proveedores";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProveedorPOO prov = new ProveedorPOO();
                prov.setCodigo(rs.getInt(1));
                prov.setNombre(rs.getString(2));
                prov.setDireccion(rs.getString(3));
                prov.setTelefono(rs.getString(4));
                proveedores.add(prov);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo leer los datos: " + ex.getMessage());
        }
        return proveedores;
    }
    
    // LEER PROVEEDOR POR CODIGO
    public boolean leerProveedor(ProveedorPOO prov) {
        con = getConexion();
        sentenciaSQL = "SELECT * FROM proveedores WHERE codigo = ?";

        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, prov.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {
                prov.setCodigo(rs.getInt(1));
                prov.setNombre(rs.getString(2));
                prov.setDireccion(rs.getString(3));
                prov.setTelefono(rs.getString(4));
                return true;
            }

            return false;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO LEER PROVEEDOR - CONS: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
      
    public boolean modificarProveedor(ProveedorPOO prov) {
        con = getConexion();
        sentenciaSQL = "UPDATE proveedores SET nombre =? , direccion =? , telefono =? WHERE codigo =? ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            
            ps.setString(1, prov.getNombre());
            ps.setString(2, prov.getDireccion());
            ps.setString(3, prov.getTelefono());
            ps.setInt(4, prov.getCodigo());

            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE - CONS");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL PROVEEDOR - CONS " + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
            }
        }
    }
    
    // EliminarProveedor
    public boolean eliminarProveedor(ProveedorPOO prov) {
        con = getConexion();
        sentenciaSQL = "DELETE FROM proveedores WHERE codigo =? ";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            
            ps.setInt(1, prov.getCodigo());

            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS CORRECTAMENTE - CONS");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL PROVEEDOR - CONS " + ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
            }
        }
    }
    
    //LEER PROVEEDOR
    public ArrayList<ProveedorPOO> leerProveedor() {
        ArrayList clientes = new ArrayList();
        con = getConexion();
        sentenciaSQL = "SELECT * FROM proveedores";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli = new ClientesPOO();
                cli.setCodigo(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setDireccion(rs.getString(3));
                cli.setTelefono(rs.getString(4));
                clientes.add(cli);
            }
        con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo leer los datos" + ex.getMessage());
        }
        return clientes;
    }
    

}
