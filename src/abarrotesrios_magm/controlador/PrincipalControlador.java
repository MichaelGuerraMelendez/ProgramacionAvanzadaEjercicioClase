/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesrios_magm.controlador;

import abarrotesrios_magm.vista.ClientesPanel;
import abarrotesrios_magm.vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MICHAEL GUERRA
 */
public class PrincipalControlador implements ActionListener{
    private Principal formPrincipal;
    private ClientesPanel formCliente;

    public PrincipalControlador(Principal formPrincipal, ClientesPanel formCliente) {
        this.formPrincipal = formPrincipal;
        this.formCliente = formCliente;
        this.formPrincipal.btnClientes.addActionListener(this);
    }
    
    public void iniciar(){
        formPrincipal.setLocationRelativeTo(null);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==formPrincipal.btnClientes){
            formPrincipal.pnlContenedor.removeAll();
            formCliente.setBounds(0, 0, formPrincipal.pnlContenedor.getWidth(), formPrincipal.pnlContenedor.getHeight());
            formPrincipal.pnlContenedor.add(formCliente);
            formPrincipal.pnlContenedor.revalidate();
            formPrincipal.pnlContenedor.repaint();
        }
    }
    
}
