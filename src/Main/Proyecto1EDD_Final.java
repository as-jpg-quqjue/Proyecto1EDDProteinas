package Main;

import interfaz.InterfazGrafica;
import javax.swing.JFrame;

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
            }
        });
        
    }
}