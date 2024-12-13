/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Conductor;
import modelo.Boleto;
import modelo.Autobus;
import util.HB;


/**
 *
 * @author LEMUEL
 */
public class ControladorBoleto {
      HB h = new HB();
    
    public void mostrarDatos (JTable tabla){
        DefaultTableModel dtm = new DefaultTableModel();
        tabla.setModel(dtm);
        dtm.addColumn("ID");
        dtm.addColumn("ORIGEN");
        dtm.addColumn("DESTINO");
        dtm.addColumn("FECHA DE SALIDA");
        dtm.addColumn("PRECIO");
        dtm.addColumn("AUTOBUS");
        dtm.addColumn("PASAJERO");
        Object[] datos = new Object[7];
        String cadena = "from Boleto";
        List<Boleto> bol =h.consultaObjetos(cadena);
        for (Boleto b:bol){
            datos[0] = b.getId();
            datos[1] = b.getOrigen();
            datos[2] = b.getDestino();
            datos[3] = b.getFechaSalida();
            datos[4] = b.getPrecio();
            datos[5] = b.getAutobus().getMarca();
            datos[6] = b.getPasajero().getNombre();
            dtm.addRow(datos);
        }
        
                            
    }
}
