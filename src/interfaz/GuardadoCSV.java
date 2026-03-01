package interfaz;

import main.java.Primitivas.Grafo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 * 
 * @author josep
 */
public class GuardadoCSV {
    
    private static File archivoActual = null;
    
    /**
 * Carga un grafo desde un archivo CSV.
 * @param archivo El archivo CSV a cargar
 * @return El grafo cargado en memoria
 * @throws IOException Si hay error al leer el archivo
 */
public Grafo cargarGrafo(File archivo) throws IOException {
    Grafo grafo = new Grafo(100); // ✅ Capacidad inicial mayor para evitar redimensionamientos
    String linea;
    String separador = ",";
    
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        while ((linea = br.readLine()) != null) {
            // Saltar líneas vacías
            if (linea.trim().isEmpty()) continue;
            
            // Dividir la línea por comas
            String[] columnas = linea.split(separador);
            
            // Validar que tenga al menos 3 columnas
            if (columnas.length < 3) {
                continue; // Saltar líneas inválidas
            }
            
            // Extraer y limpiar datos
            String dato1 = columnas[0].trim();
            String dato2 = columnas[1].trim();
            int dato3 = Integer.parseInt(columnas[2].trim());
            
            // Agregar conexión (agregarProteina se encarga de evitar duplicados)
            grafo.agregarConexión(dato1, dato2, dato3);
        }
    } catch (NumberFormatException e) {
    throw new IOException("Error: El peso debe ser un número entero válido. Verifique el formato del archivo CSV.", e);
    } catch (ArrayIndexOutOfBoundsException e) {
        throw new IOException("Error: Formato de archivo inválido. Se esperaban 3 columnas por línea.", e);
    }
    
    // Guardar referencia al archivo actual para poder guardar cambios después
    archivoActual = archivo;
    
    return grafo;
}
    
    /**
     * Guarda el grafo en un archivo CSV (solo proteínas activas y conexiones).
     * @param grafo El grafo a guardar
     * @return Mensaje de confirmación o error
     * @throws IOException Si hay error al escribir
     */
    public String guardar(Grafo grafo) throws IOException {
        if (archivoActual == null) {
            // Si no hay archivo, abrir JFileChooser para guardar como
            JFileChooser selector = new JFileChooser();
            selector.setFileFilter(new FileNameExtensionFilter("Archivos CSV", "csv", "txt"));
            selector.setAcceptAllFileFilterUsed(false);
            
            int seleccion = selector.showSaveDialog(null);
            if (seleccion != JFileChooser.APPROVE_OPTION) {
                return "Guardado cancelado.";
            }
            
            archivoActual = selector.getSelectedFile();
            if (!archivoActual.getName().toLowerCase().endsWith(".csv") && 
                !archivoActual.getName().toLowerCase().endsWith(".txt")) {
                archivoActual = new File(archivoActual.getAbsolutePath() + ".csv");
            }
        }
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoActual))) {
            int[][] matrizPeso = grafo.getMatrizPeso();
            String[] nombres = grafo.getNombres();
            boolean[] activas = grafo.getActivas();
            int n = grafo.getCantidadProteinas();
            int conexionesGuardadas = 0;
            
            for (int i = 0; i < n; i++) {
                if (!activas[i] || nombres[i] == null) continue;
                
                for (int j = i + 1; j < n; j++) { // j = i + 1 evita duplicados
                    if (!activas[j] || nombres[j] == null) continue;
                    
                    if (grafo.estanConectadas(i, j)) {
                        pw.println(nombres[i] + "," + nombres[j] + "," + matrizPeso[i][j]);
                        conexionesGuardadas++;
                    }
                }
            }
            
            return "Archivo guardado exitosamente en: " + archivoActual.getName() + 
                   "\nConexiones guardadas: " + conexionesGuardadas;
        }
    }
    
    /**
     * Obtiene la ruta del archivo actual.
     * @return La ruta del archivo o null si no hay ninguno
     */
    public String getArchivoActual() {
        return archivoActual != null ? archivoActual.getAbsolutePath() : null;
    }
}