/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesrios_magm;
import abarrotesrios_magm.controlador.ClienteControlador;
import abarrotesrios_magm.controlador.PrincipalControlador;
import abarrotesrios_magm.modelo.ClientesPOO;
import abarrotesrios_magm.modelo.ConsultasBD;
import abarrotesrios_magm.vista.ClientesPanel;
import abarrotesrios_magm.vista.Principal;
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
        ClientesPanel cli = new ClientesPanel();
        ClientesPOO cliPOO = new ClientesPOO();
        ConsultasBD conBD = new ConsultasBD();
        PrincipalControlador conPrin = new PrincipalControlador(pri, cli);
        ClienteControlador conCli = new ClienteControlador(cliPOO, cli, conBD);
        conPrin.iniciar();
        pri.setVisible(true);
        
    }
    
}
