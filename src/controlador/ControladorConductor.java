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
import util.HB;



/**
 *
 * @author LEMUEL
 */
public class ControladorConductor {
    HB h = new HB();
    
    public void mostrarDatos (JTable tabla){
        DefaultTableModel dtm = new DefaultTableModel();
        tabla.setModel(dtm);
        dtm.addColumn("ID");
        dtm.addColumn("NOMBRE");
        dtm.addColumn("APELLIDO PATERNO");
        dtm.addColumn("APELLIDO MATERNO");
        dtm.addColumn("TIPO DE LICENCIA");
        dtm.addColumn("NACIONALIDAD");
        Object[] datos = new Object[6];
        String cadena = "from Conductor";
        List<Conductor> conduc =h.consultaObjetos(cadena);
        for (Conductor c:conduc){
            datos[0] = c.getId();
            datos[1] = c.getNombre();
            datos[2] = c.getApaterno();
            datos[3] = c.getAmaterno();
            datos[4] = c.getTipoLicencia();
            datos[5] = c.getNacionalidad();
            dtm.addRow(datos);
        }
    }  
    
    
  public void colocaConductor (JComboBox cmb){
        List<Conductor> con = h.consultaObjetos("from Conductor");
        cmb.removeAllItems();
        for (Conductor c:con)
            cmb.addItem(c.getNombre());
    }
  
    
    public Conductor buscaConductor (String conduct){
        Conductor condu = new Conductor();
        String consulta = "from Conductor where nombre='"+conduct+"'";
        List<Conductor> dep = h.consultaObjetos(consulta);
        for (Conductor d:dep)
            condu = d;
        return condu;
        
    }
}
