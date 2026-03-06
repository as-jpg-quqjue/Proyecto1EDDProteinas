package Main;

import interfaz.InterfazGrafica;
import javax.swing.JFrame;
import interfaz.GuardadoCSV;
import java.io.File;
import java.io.IOException;
import Primitivas.Grafo;
import javax.swing.JOptionPane;



/**
 *
 * @author mipc2
 */
public class Proyecto1EDD_Final {

    public static void main(String[] args) {
        
        //insertamos la interfaz en su propio proceso para evitar comportamiento no deseado y optimizar
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                //creamos el JFrame, luego un InterfazGrafico y lo insertamos al JFrame
                JFrame ventana = new JFrame("BioGraph - Proyecto 1 EDD");
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                InterfazGrafica miPanel = new InterfazGrafica();
                ventana.add(miPanel);
                
                // ajustamos el tamaño para que todo quepe en la ventana, y luego lo centramos en el medio de la pantalla, finalmente haciendolo visible
                ventana.pack();
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
                
                //ahora cargamos el maestro.csv
                GuardadoCSV guarda = new GuardadoCSV();
                File archivo = new File("test/maestro.csv");
                try {
                    Grafo defaultGrafo = guarda.cargarGrafo(archivo);
                    miPanel.setGrafoInterfaz(defaultGrafo);
                    JOptionPane.showMessageDialog(ventana, 
                "✅ Archivo de prueba cargado.", 
                "Carga Exitosa", 
                JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    System.getLogger(Proyecto1EDD_Final.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        });
        
    }
}