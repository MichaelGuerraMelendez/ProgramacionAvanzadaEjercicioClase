/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesrios_magm.controlador;

import abarrotesrios_magm.modelo.ClientesPOO;
import abarrotesrios_magm.modelo.ConsultasBD;
import abarrotesrios_magm.modelo.ProveedorPOO;
import abarrotesrios_magm.vista.ClientesPanel;
import abarrotesrios_magm.vista.ProveedoresPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ProveedorControlador implements ActionListener{
    
    private ProveedorPOO prov;
    private ProveedoresPanel form;
    private ConsultasBD conBD;
    private Object datos[] = new Object[4];
    DefaultTableModel modelo;
    private ImageIcon icono;
    
    public ProveedorControlador(ProveedorPOO prov, ProveedoresPanel form, ConsultasBD conBD) {
        this.prov = prov;
        this.form = form;
        this.conBD = conBD;
        
        this.form.botCrear.addActionListener(this);
        
    }
    
    public void llenarTaba(){
        modelo = (DefaultTableModel)form.tblDatos.getModel();
        int registros = conBD.leerProveedor().size();
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
        //form.jlbFoto.setIcon(icono);
        int fila = form.tblDatos.getRowCount();
        for(int i = fila-1 ; i>0 ; i--){
            modelo.removeRow(i);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == form.botCrear) {
            prov.setCodigo(Integer.parseInt(form.jtfCodigo.getText()));
            prov.setNombre(form.jtfNombre.getText());
            prov.setDireccion(form.jtfDireccion.getText());
            prov.setTelefono(form.jtfTelefono.getText());
            prov.setEstado("ACTIVO");

            if (conBD.crearProveedor(prov)) {
                JOptionPane.showMessageDialog(null, "CLIENTE CREADO CORRECTAMENTE - CONTROLADOR");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR CLIENTE - CONTROLADOR");
            }
        }
        
        if(e.getSource()==form.botLeer){
            llenarTaba();
        }
    }

    
}