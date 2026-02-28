/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import main.java.Primitivas.Grafo;

/**
 *
 * @author cesar
 */
public class GuardadoCSV {
    JFileChooser selector = new JFileChooser();
    private static File archivoActual = null;

    public GuardadoCSV() {
    }
    
     /** 
    Tomar en cuenta que este cargado tambien guardará la dirección file.
    */
    public Grafo cargarGrafo(File archivo) throws FileNotFoundException, IOException {
        Grafo grafo = new Grafo(2);
        String linea;
        String separador = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {
                // Dividimos la línea en partes
                String[] columnas = linea.split(separador);

                //Columna 1 Proteina
                String dato1 = columnas[0].trim();
                grafo.agregarProteina(dato1);

                //Columna 2 Proteina tambien
                String dato2 = columnas[1].trim();
                grafo.agregarProteina(dato2);//Nota: El agregarProteina, esta adaptado para evitar que se agregen dos veces
            }
        }
        //Se reinicia el br para la siguiente fase de conectar las proteinas
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        
        while ((linea = br.readLine()) != null) {
            //Dividimos la línea en partes
            String[] columnas = linea.split(separador);

            //Columna 1 Proteina
            String dato1 = columnas[0].trim();

            //Columna 2 Proteina tambien
            String dato2 = columnas[1].trim();
            
            //Columna 3 Peso
            int dato3 = Integer.parseInt(columnas[2].trim());
            
            grafo.agregarConexión(dato1, dato2, dato3);
        }}
        archivoActual = archivo;
        grafo.imprimirMatrizPeso();
        
        return grafo;
    }
    
    public String guardar(Grafo grafo) throws IOException {
        if (archivoActual == null) {
            return "No hay un archivo abierto para guardar.";
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoActual))) {
            int[][] matrizPeso = grafo.getMatrizPeso();
            String[] nombres = grafo.getNombres();

            for (int i = 0; i < nombres.length; i++) {
                //j = i evita duplicados en grafos simétricos
                for (int j = i; j < nombres.length; j++) {
                    if (grafo.estanConectadas(i, j)) {

                        pw.println(nombres[i] + "," + nombres[j] + "," + matrizPeso[i][j]);
                    }
                }
            }
            return "Archivo guardado exitosamente en: " + archivoActual.getName();

        } catch (IOException e) {
            return "Error al escribir en el archivo: " + e.getMessage();
        }
    }
}
