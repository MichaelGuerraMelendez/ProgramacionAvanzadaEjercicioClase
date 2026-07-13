/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesrios_magm.controlador;

import abarrotesrios_magm.vista.ClientesPanel;
import abarrotesrios_magm.vista.Principal;
import abarrotesrios_magm.vista.ProveedoresPanel;
import abarrotesrios_magm.vista.ProductosPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author MICHAEL GUERRA
 */
public class PrincipalControlador implements ActionListener{
    private Principal formPrincipal;
    private ClientesPanel formCliente;
    private ProveedoresPanel formProveedor;
    private ProductosPanel formProducto;


    public PrincipalControlador(Principal formPrincipal, ClientesPanel formCliente, ProveedoresPanel frmProveedor, ProductosPanel frmProducto) {
        this.formPrincipal = formPrincipal;
        this.formCliente = formCliente;
        this.formProveedor = frmProveedor;
        this.formProducto = frmProducto;
        
        this.formPrincipal.btnClientes.addActionListener(this);
        this.formPrincipal.btnProveedor.addActionListener(this);
        this.formPrincipal.btnProductos.addActionListener(this);
        
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
        
        if(e.getSource()==formPrincipal.btnProveedor){
            formPrincipal.pnlContenedor.removeAll();
            formProveedor.setBounds(0, 0, formPrincipal.pnlContenedor.getWidth(), formPrincipal.pnlContenedor.getHeight());
            formPrincipal.pnlContenedor.add(formProveedor);
            formPrincipal.pnlContenedor.revalidate();
            formPrincipal.pnlContenedor.repaint();
        }
        
        if(e.getSource()==formPrincipal.btnProductos){
            formPrincipal.pnlContenedor.removeAll();
            formProducto.setBounds(0, 0, formPrincipal.pnlContenedor.getWidth(), formPrincipal.pnlContenedor.getHeight());
            formPrincipal.pnlContenedor.add(formProducto);
            formPrincipal.pnlContenedor.revalidate();
            formPrincipal.pnlContenedor.repaint();
        }
        
    }
    
}
