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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MICHAEL GUERRA
 */
public class ClienteControlador implements ActionListener{
    private ClientesPOO cli;
    private ClientesPanel form;
    private ConsultasBD conBD;
    private Object datos[] = new Object[4];
    DefaultTableModel modelo;
    private ImageIcon icono;
    

    public ClienteControlador(ClientesPOO cli, ClientesPanel form, ConsultasBD conBD) {
        this.cli = cli;
        this.form = form;
        this.conBD = conBD;
        
        this.icono = new ImageIcon("src/imgs/sinPerfil.jpg");

        this.form.botCrear.addActionListener(this);
        this.form.botLeer.addActionListener(this);
        this.form.botBuscarCodigo.addActionListener(this);
        this.form.botLimpiar.addActionListener(this);

    }
    
    public void llenarTaba(){
        modelo = (DefaultTableModel)form.tblDatos.getModel();
        int registros = conBD.leerTodos().size();
        for (int i = 0; i< registros; i++){
            datos[0]=conBD.leerTodos().get(i).getCodigo();
            datos[1]=conBD.leerTodos().get(i).getNombre();
            datos[2]=conBD.leerTodos().get(i).getDireccion();
            datos[3]=conBD.leerTodos().get(i).getTelefono();
            modelo.addRow(datos);
            form.tblDatos.setModel(modelo);
        }
    }
    
    public void limpiar(){
        form.jtfCodigo.setText("0");
        form.jtfNombre.setText(null);
        form.jtfDireccion.setText(null);
        form.jtfTelefono.setText(null);
        form.jtfNombre.requestFocus();
        form.jlbFoto.setIcon(icono);
        int fila = form.tblDatos.getRowCount();
        for(int i = fila-1 ; i>0 ; i--){
            modelo.removeRow(i);
        }
        
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
        
        if(e.getSource()==form.botLeer){
            llenarTaba();
        }
        
        //Boton buscar por codigo
        if (e.getSource() == form.botBuscarCodigo) {
            cli.setCodigo(Integer.parseInt(form.jtfCodigo.getText()));
            if (conBD.leerCliente(cli)) {
                   form.jtfNombre.setText(cli.getNombre());
                   form.jtfDireccion.setText(cli.getDireccion());
                   form.jtfTelefono.setText(cli.getTelefono());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO LEER CLIENTE - CONTROL");
            }
    }
        //Boton Limpiar
        if(e.getSource()==form.botLimpiar){
            limpiar();
        }
    
    
   }
    
}
