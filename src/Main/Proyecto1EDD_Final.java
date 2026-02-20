package Main;

import interfaz.InterfazGrafica;
import javax.swing.JFrame;

/**
 *
 * @author mipc2
 */
public class Proyecto1EDD_Final {

    public static void main(String[] args) {
        
        // Es una buena práctica de Java iniciar la interfaz gráfica en su propio hilo
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                // 1. Creamos la ventana principal (el marco)
                JFrame ventana = new JFrame("BioGraph - Proyecto 1 EDD");
                
                // 2. Indicamos que el programa debe terminar cuando se cierre la ventana
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                // 3. Instanciamos tu panel (la interfaz que tú diseñaste con los botones)
                InterfazGrafica miPanel = new InterfazGrafica();
                
                // 4. Metemos tu panel dentro de la ventana
                ventana.add(miPanel);
                
                // 5. Ajustamos automáticamente el tamaño de la ventana para que quepa todo tu panel
                ventana.pack();
                
                // 6. Centramos la ventana en el medio de la pantalla
                ventana.setLocationRelativeTo(null);
                
                // 7. Finalmente, hacemos que todo sea visible
                ventana.setVisible(true);
            }
        });
        
    }
}