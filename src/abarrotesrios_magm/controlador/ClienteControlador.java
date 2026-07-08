/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesrios_magm.controlador;

import abarrotesrios_magm.modelo.ClientesPOO;
import abarrotesrios_magm.modelo.ConsultasBD;
import abarrotesrios_magm.vista.ClientesPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author MICHAEL GUERRA
 */
public class ClienteControlador implements ActionListener{
    private ClientesPOO cli;
    private ClientesPanel form;
    private ConsultasBD conBD;

    public ClienteControlador(ClientesPOO cli, ClientesPanel form, ConsultasBD conBD) {
        this.cli = cli;
        this.form = form;
        this.conBD = conBD;

        this.form.botCrear.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == form.botCrear) {
            cli.setCodigo(Integer.parseInt(form.jtfCodigo.getText()));
            cli.setNombre(form.jtfNombre.getText());
            cli.setDireccion(form.jtfDireccion.getText());
            cli.setTelefono(form.jtfTelefono.getText());
            cli.setEstado("ACTIVO");

            if (conBD.crearCliente(cli)) {
                JOptionPane.showMessageDialog(null, "CLIENTE CREADO CORRECTAMENTE - CONTROLADOR");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR CLIENTE - CONTROLADOR");
            }
        }
    }
    
}
