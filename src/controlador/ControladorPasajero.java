/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Pasajero;
import util.HB;


/**
 *
 * @author LEMUEL
 */
public class ControladorPasajero {
      HB h = new HB();
    
    public void mostrarDatos (JTable tabla){
        DefaultTableModel dtm = new DefaultTableModel();
        tabla.setModel(dtm);
        dtm.addColumn("ID");
        dtm.addColumn("NOMBRE");
        dtm.addColumn("APELLIDO PATERNO");
        dtm.addColumn("APELLIDO MATERNO");
        dtm.addColumn("NACIONALIDAD");
        Object[] datos = new Object[5];
        String cadena = "from Pasajero";
        List<Pasajero> pasje =h.consultaObjetos(cadena);
        for (Pasajero p:pasje){
            datos[0] = p.getId();
            datos[1] = p.getNombre();
            datos[2] = p.getApaterno();
            datos[3] = p.getAmaterno();
            datos[4] = p.getNacionalidad();
            dtm.addRow(datos);
        }
       
    }
    
  public void colocaPasajero (JComboBox cmb){
        List<Pasajero> pas = h.consultaObjetos("from Pasajero");
        cmb.removeAllItems();
        for (Pasajero p:pas)
            cmb.addItem(p.getNombre());
    }
  
    public Pasajero buscaPasajero (String pasjer){
        Pasajero pasj = new Pasajero();
        String consulta = "from Pasajero where nombre='"+pasjer+"'";
        List<Pasajero> dep = h.consultaObjetos(consulta);
        for (Pasajero d:dep)
            pasj = d;
        return pasj;
        
    }
}
