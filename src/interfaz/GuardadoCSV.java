package interfaz;

import main.java.Primitivas.Grafo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import main.java.Primitivas.Normalizador;
/**
 * 
 * @author cesar
 */
public class GuardadoCSV {
    
    private static File archivoActual = null;
    
    /**
     * Carga un grafo desde un archivo CSV.
     *
     * @param archivo El archivo CSV a cargar
     * @return El grafo cargado en memoria
     * @throws IOException Si hay error al leer el archivo
     */
    public Grafo cargarGrafo(File archivo) throws IOException {
        Grafo grafo = new Grafo(100); 
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {
                // Saltar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

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
            if ("(!)".equals(dato2)) {//Si la proteina dato1 apunta a (!), entonces solo se agrega dato1
                dato1 = Normalizador.NormalizarTexto(dato1);
                grafo.agregarProteina(dato1); //añadi estas normalizaciones para evitar que se cargen archivos con diacriticos o letras minusculas
            }else{
                dato1 = Normalizador.NormalizarTexto(dato1);
                dato2 = Normalizador.NormalizarTexto(dato2);
                grafo.agregarConexión(dato1, dato2, dato3);//Dentro de agregar conexción tambien se agrega la proteina
            }
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
                boolean aislada = true;//Esta variable ayudará con las proteinas que estan aisladas y lo agregarán al archivo
                
                for (int j = i + 1; j < n; j++) { // j = i + 1 evita duplicados
                    if (!activas[j] || nombres[j] == null) continue;
                    
                    if (grafo.estanConectadas(i, j)) {
                        pw.println(nombres[i] + "," + nombres[j] + "," + matrizPeso[i][j]);
                        conexionesGuardadas++;
                        aislada = false;
                    }
                }
                if (aislada) {
                    pw.println(nombres[i] + "," + "(!)" + "," + 0);//(!) representará vacio.
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

    public void setArchivoActual(File archivoActual) {
        GuardadoCSV.archivoActual = archivoActual;
    }
    
    /**
     * Crea un archivo nuevo en caso de que no haya uno.
     * @param grafo El grafo que se va a utilizar para el nuevo archivo.
     * @return Un string que confirma si la creación de archivo fue exitosa.
     */
    public String crearNuevoArchivo(Grafo grafo) {
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Crear nuevo archivo CSV para el grafo");
        
        //Filtro para CSV
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo CSV (*.csv)", "csv");
        selector.setFileFilter(filtro);

        int resultado = selector.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = selector.getSelectedFile();
            String ruta = archivoSeleccionado.getAbsolutePath();

            //Si el usuario no escribió ".csv", se lo agrega
            if (!ruta.toLowerCase().endsWith(".csv")) {
                archivoSeleccionado = new File(ruta + ".csv");
            }

            try {
                //Se crea el archivo físicamente
                //Si ya existe, lo vacía. Si no existe, lo crea.
                FileWriter fw = new FileWriter(archivoSeleccionado);
                fw.close();

                //Se actualiza el archivoActual
                archivoActual = archivoSeleccionado;
                
                JOptionPane.showMessageDialog(null, "Archivo creado: " + archivoActual.getName());
                return this.guardar(grafo);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage());
            }
        }
        return "Guardado cancelado.";
    }
}
