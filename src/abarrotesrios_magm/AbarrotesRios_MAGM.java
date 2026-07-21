/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesrios_magm;
import abarrotesrios_magm.controlador.ClienteControlador;
import abarrotesrios_magm.controlador.PrincipalControlador;
import abarrotesrios_magm.controlador.ProveedorControlador;
import abarrotesrios_magm.modelo.ClientesPOO;
import abarrotesrios_magm.modelo.ConsultasBD;
import abarrotesrios_magm.modelo.ProveedorPOO;
import abarrotesrios_magm.vista.ClientesPanel;
import abarrotesrios_magm.vista.Principal;
import abarrotesrios_magm.vista.ProveedoresPanel;
import abarrotesrios_magm.vista.ProductosPanel;
    
/**
 *
 * @author MICHAEL GUERRA
 */
public class AbarrotesRios_MAGM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal pri = new Principal("Michael GM");
        
        //Clientes
        ClientesPanel cli = new ClientesPanel();
        ClientesPOO cliPOO = new ClientesPOO();
        ConsultasBD conBD = new ConsultasBD();
        
        //Proveedor
        ProveedoresPanel prov = new ProveedoresPanel();
        ProveedorPOO provPOO = new ProveedorPOO();
        
        
        //Productos
        ProductosPanel produc = new ProductosPanel();
        
        //Ventana Principal
        PrincipalControlador conPrin = new PrincipalControlador(pri, cli, prov, produc);
        
        ClienteControlador conCli = new ClienteControlador(cliPOO, cli, conBD);
        ProveedorControlador conProv = new ProveedorControlador(provPOO, prov, conBD);
        conPrin.iniciar();
        pri.setVisible(true);
        
    }
    
}
