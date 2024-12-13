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
import modelo.Conductor;
import modelo.Autobus;
import util.HB;



/**
 *
 * @author LEMUEL
 */
public class ControladorAutobus {
     HB h = new HB();
    
    public void mostrarDatos (JTable tabla){
        DefaultTableModel dtm = new DefaultTableModel();
        tabla.setModel(dtm);
        dtm.addColumn("ID");
        dtm.addColumn("MARCA");
        dtm.addColumn("MODELO");
        dtm.addColumn("COLOR");
        dtm.addColumn("CONDUCTOR");
        Object[] datos = new Object[5];
        String cadena = "from Autobus";
        List<Autobus> aut =h.consultaObjetos(cadena);
        for (Autobus a:aut){
            datos[0] = a.getId();
            datos[1] = a.getMarca();
            datos[2] = a.getModelo();
            datos[3] = a.getColor();
            datos[4] = a.getConductor().getNombre();
            dtm.addRow(datos);
        }        
    }
    
      public void colocaAutobus (JComboBox cmb){
        List<Autobus> au = h.consultaObjetos("from Autobus");
        cmb.removeAllItems();
        for (Autobus a:au)
            cmb.addItem(a.getMarca());
    }
  
    
    public Autobus buscaAutobus (String autob){
        Autobus auto = new Autobus();
        String consulta = "from Autobus where marca='"+autob+"'";
        List<Autobus> dep = h.consultaObjetos(consulta);
        for (Autobus d:dep)
            auto = d;
        return auto;
        
    }
}

