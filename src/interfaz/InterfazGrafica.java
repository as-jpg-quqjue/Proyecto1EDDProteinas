/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;

/**
 * Esta clase es la interfaz gráfica del programa, es el unico método de interacción con el programa.
 * @author josep
 */

import main.java.Primitivas.Grafo;
import main.java.buscadores.BFS;
import main.java.buscadores.CentralidadGrado;
import main.java.rutas.Dijkstra;
import main.java.Primitivas.Normalizador;
import java.io.File;
import java.io.IOException;
import main.java.Primitivas.Lista;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JDialog;  
import java.awt.Frame;
import main.java.buscadores.DFS;


public class InterfazGrafica extends javax.swing.JPanel {
    
    /**
     * La clase de guardado del sistema.
     */
    private GuardadoCSV gargar = new GuardadoCSV();
    
    /**
     * Grafo del sistema.
     */
    private Grafo grafo;
    
    /**
     * Otra clase de guardado del sistema.
     */
    private GuardadoCSV guardadoCSV;
    
    /**
     * El panel de visualización del grafo.
     */
    private PanelVisualizacionGrafo panelVisualizacion;
    
    /**
     * La ventana del programa JDialog.
     */
    private JDialog dialogVisualizacion;
    
    /**
     * Inicializamos la interfaz con un nuevo grafo, guardadoCSV e interfaz grafica, luego definiendo el tamaño especifico de la ventana y centrarlo.
     */
    public InterfazGrafica() {
        initComponents();
        // Inicializamos un grafo vacío por defecto
        grafo = new Grafo(2);
        guardadoCSV = new GuardadoCSV();
        panelVisualizacion = new PanelVisualizacionGrafo();
        
        // Configurar dialog para visualización
        dialogVisualizacion = new JDialog((Frame) null, "Visualización del Grafo", true);
        dialogVisualizacion.setSize(800, 600);
        dialogVisualizacion.setLocationRelativeTo(this);
        dialogVisualizacion.add(panelVisualizacion);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ActualizarRepositorio = new javax.swing.JButton();
        DCP = new javax.swing.JButton();
        RMMC = new javax.swing.JButton();
        CargarArchivo = new javax.swing.JButton();
        ModificarGrafo = new javax.swing.JButton();
        MostrarGrafo = new javax.swing.JButton();
        Hubs = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        GrafoNuevo = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 69, 69));

        ActualizarRepositorio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ActualizarRepositorio.setText("Guardar");
        ActualizarRepositorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarRepositorioActionPerformed(evt);
            }
        });

        DCP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DCP.setText("Complejos");
        DCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DCPActionPerformed(evt);
            }
        });

        RMMC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RMMC.setText("Rutas");
        RMMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RMMCActionPerformed(evt);
            }
        });

        CargarArchivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CargarArchivo.setText("Cargar Archivo");
        CargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarArchivoActionPerformed(evt);
            }
        });

        ModificarGrafo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ModificarGrafo.setText("Modificar Grafo");
        ModificarGrafo.setToolTipText("");
        ModificarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarGrafoActionPerformed(evt);
            }
        });

        MostrarGrafo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MostrarGrafo.setText("Mostrar Grafo");
        MostrarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarGrafoActionPerformed(evt);
            }
        });

        Hubs.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Hubs.setText("Ident. Hubs");
        Hubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HubsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BioGraph");

        output.setEditable(false);
        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logobiologicogenerico.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Analisis de Interacciones Proteicas");

        GrafoNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GrafoNuevo.setText("Grafo Nuevo");
        GrafoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrafoNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 314, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ModificarGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(MostrarGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Hubs, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RMMC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(DCP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ActualizarRepositorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CargarArchivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrafoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CargarArchivo)
                        .addGap(18, 18, 18)
                        .addComponent(ActualizarRepositorio)
                        .addGap(18, 18, 18)
                        .addComponent(GrafoNuevo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ModificarGrafo)
                        .addGap(18, 18, 18)
                        .addComponent(MostrarGrafo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DCP)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Hubs)
                        .addComponent(RMMC)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Este procedimiento cicla por cuatro opciónes para modificar el grafo, que incluyen añadir o eliminar una proteina o una conexión.
     * @param evt 
     */
    private void ModificarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarGrafoActionPerformed
        String[] opciones = {"Agregar Proteína", "Eliminar Proteína", "Agregar Conexión", "Eliminar conexión"};
        int seleccion = JOptionPane.showOptionDialog(this,
            "¿Qué deseas hacer?",
            "Modificar Grafo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
             opciones[0]);
        
        String origen;
        String destino;
        
        switch (seleccion) { //cambie esto de un if a un switch para optimizar
            case 0:
                {
                    // Agregar Proteína
                    String nombre = JOptionPane.showInputDialog(this, "Nombre de la nueva proteína:");
                    if (nombre != null && !nombre.trim().isEmpty()) {
                        nombre = Normalizador.NormalizarTexto(nombre); //añadi esta normalización para facilitar la busqueda
                            if (grafo.indexOf(nombre) == -1)
                            {
                            String nombreF = Normalizador.NormalizarTexto(nombre);
                            grafo.agregarProteina(nombreF.trim());
                            output.setText("✅ Proteína '" + nombreF + "' agregada con éxito.");
                            } 
                            else { //este else es el caso donde la proteina ya existe
                            output.setText("❌ Error: Esa proteina ya existe dentro del grafo."); 
                            JOptionPane.showMessageDialog(this,
                                "Esa proteina ya existe dentro del grafo.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                         }
                    break;
                    }
                    
                    else { //este else es el caso donde el nombre es nulo
                       output.setText("❌ Error: No se puede insertar una proteina sin nombre."); 
                            JOptionPane.showMessageDialog(this,
                                "No se puede insertar una proteina sin nombre.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE); 
                            break;
                    }
                }
            case 1:
                {
                    // Eliminar Proteína
                    String nombre = JOptionPane.showInputDialog(this, "Nombre de la proteína a eliminar:");
                    if (nombre != null && !nombre.trim().isEmpty()) {
                        nombre = Normalizador.NormalizarTexto(nombre); //añadi esta normalización para facilitar la busqueda
                        if (grafo.indexOf(nombre) != -1)
                        {
                            grafo.removerProteina(nombre.trim());
                            output.setText("✅ Proteína '" + nombre + "' ha sido desactivada.");
                        }
                        else
                        {//este else es el caso donde la proteina no existe
                        output.setText("❌ Error: Esa proteina no existe."); 
                        JOptionPane.showMessageDialog(this,
                                "Esa proteina no existe.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                            
                        }
                        break;
                    }       
                    else //este es el caso donde el nombre insertado es vacio
                    {
                        output.setText("❌ Error: No se puede eliminar una proteina sin nombre."); 
                            JOptionPane.showMessageDialog(this,
                                "No se puede eliminar una proteina sin nombre.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            case 2:
                // Agregar Conexión
                origen = JOptionPane.showInputDialog(this, "Proteína Origen:");
                destino = JOptionPane.showInputDialog(this, "Proteína Destino:");
                String pesoStr = JOptionPane.showInputDialog(this, "Peso/Costo de la conexión:");
                if (origen != null && destino != null && pesoStr != null && !origen.equals(destino)) {
                    try {
                        int peso = Integer.parseInt(pesoStr.trim());
                        if (peso >= 0){
                            String origenF = Normalizador.NormalizarTexto(origen); //normalizamos estos dos nombres si no existen
                            String destinoF = Normalizador.NormalizarTexto(destino);
                            grafo.agregarConexión(origenF.trim(), destinoF.trim(), peso);
                            output.setText("✅ Conexión agregada: " + origenF + " ↔ " + destinoF +
                                " (peso: " + peso + ")");
                        }
                        else { //este else cubre el caso donde el peso es negativo
                            output.setText("❌ Error: No puedes crear una conexión entre proteinas negativas.");
                    JOptionPane.showMessageDialog(this,
                            "No puedes crear una conexión entre proteinas negativa.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                        }
                            
                    } catch (NumberFormatException e) {
                        output.setText("❌ Error: El peso debe ser un número entero.");
                        JOptionPane.showMessageDialog(this,
                                "El peso debe ser un número válido.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                else //este else se encarga de errores cuando intentas poner el destino igual al origen
                {
                    output.setText("❌ Error: No puedes crear una conexión de una proteina a si misma.");
                    JOptionPane.showMessageDialog(this,
                            "No puedes crear una conexión de una proteina a si misma.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 3:
                origen = JOptionPane.showInputDialog(this, "Proteína Origen:");
                destino = JOptionPane.showInputDialog(this, "Proteína Destino:");
                if (origen != null && destino != null && !origen.equals(destino)) {
                    String origenF = Normalizador.NormalizarTexto(origen); //normalizamos estos dos nombres si no existen
                    String destinoF = Normalizador.NormalizarTexto(destino);
                    boolean eliminación = grafo.eliminarConexión(origenF.trim(), destinoF.trim());

                    if (eliminación) {
                        output.setText("✅ Conexión eliminada: " + origenF + " ↔ " + destinoF);
                    } else {
                        output.setText("❌ Conexión no encontrada: " + origenF + " ↔ " + destinoF);
                    }
                }
                else //este else se encarga de errores cuando intentas poner el destino igual al origen
                {
                    output.setText("❌ Error: No puedes crear una conexión de una proteina a si misma.");
                    JOptionPane.showMessageDialog(this,
                            "No puedes crear una conexión de una proteina a si misma.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
                
            default:
                break;
        }
        
    }//GEN-LAST:event_ModificarGrafoActionPerformed
    /**
     * Este procedimiento llama para cargar un archivo .csv que guarda los datos de un grafo.
     * @param evt 
     */
    private void CargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarArchivoActionPerformed
        if (grafo != null && grafo.getCantidadProteinas() > 0) {
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Deseas guardar los cambios antes de cargar un nuevo archivo?",
            "Guardar Cambios",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            ActualizarRepositorioActionPerformed(evt); // Llamar al método de guardar
        } else if (confirmacion == JOptionPane.CANCEL_OPTION) {
            return; // Cancelar la carga
        }
    }
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV o TXT", "csv", "txt"));
    fileChooser.setAcceptAllFileFilterUsed(false);
    
    int seleccion = fileChooser.showOpenDialog(this);
    
    if (seleccion == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
        
            try {
            grafo = gargar.cargarGrafo(archivoSeleccionado);
            output.setText("✅ Archivo cargado exitosamente:\n" + 
                             archivoSeleccionado.getName() + "\n\n" +
                             "Proteínas cargadas: " + grafo.getCantidadProteinas() + "\n" +
                             "Ubicación: " + archivoSeleccionado.getAbsolutePath());
            
            JOptionPane.showMessageDialog(this, 
                "✅ Archivo cargado: " + archivoSeleccionado.getName() + 
                "\nProteínas: " + grafo.getCantidadProteinas(), 
                "Carga Exitosa", 
                JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
            output.setText("❌ Error al cargar el archivo:\n" + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error al cargar: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            //para errores no esperados
            output.setText("❌ Error inesperado: " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error inesperado: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    }//GEN-LAST:event_CargarArchivoActionPerformed
    
    /**
     * Este procedimiento llama para guardar el grafo actual en el archivo cargado.
     * @param evt 
     */
    private void ActualizarRepositorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarRepositorioActionPerformed
      if (grafo == null || grafo.getCantidadProteinas() == 0) {
            output.setText("❌ No hay grafo en memoria para guardar.");
            JOptionPane.showMessageDialog(this,
                "No hay datos para guardar.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            String mensaje = null;
            if (guardadoCSV.getArchivoActual() == null) {
                mensaje = guardadoCSV.crearNuevoArchivo(grafo);
            }else{
                mensaje = guardadoCSV.guardar(grafo);
            }
          
            
            output.setText("✅ " + mensaje);
            JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            output.setText("❌ Error al guardar: " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error al guardar: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ActualizarRepositorioActionPerformed
    
    /**
     * Este procedimiento carga el grafo por GraphStream y luego lo pone en display.
     * @param evt 
     */
    private void MostrarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarGrafoActionPerformed
     if (grafo == null || grafo.getCantidadProteinas() == 0) {
            output.setText("❌ No hay grafo cargado. Carga un archivo primero.");
            JOptionPane.showMessageDialog(this,
                "No hay grafo cargado.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Limpiar panel anterior
        panelVisualizacion.liberarRecursos();
        panelVisualizacion.removeAll();
        
        // Visualizar nuevo grafo
        panelVisualizacion.visualizarGrafo(grafo);
        
        // Mostrar dialog
        dialogVisualizacion.setVisible(true);
        
        output.setText("✅ Grafo visualizado correctamente.\n" +
                         "Proteínas activas: " + grafo.getCantidadProteinas() + "\n" +
                         "Los nodos rojos representan Hubs (≥5 conexiones)");
        
    }//GEN-LAST:event_MostrarGrafoActionPerformed
    
    /**
     * Este procedimiento le pregunta al usuario sobre el nombre de una proteina y luego le pregunta si quiere buscar cuantas proteinas tiene el componente por DFS o BFS.
     * @param evt 
     */
    private void DCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DCPActionPerformed
       if (grafo == null || grafo.getCantidadProteinas() == 0) {
            output.setText("❌ El grafo está vacío. Carga un archivo primero.");
            return;
        }
        
        String nombreInicio = JOptionPane.showInputDialog(this,
            "Nombre de la proteína para iniciar:");
        
        if (nombreInicio == null || nombreInicio.trim().isEmpty()) {
            return;
        }
        //añadi esto para normalizar el texto en la busqueda
        nombreInicio = Normalizador.NormalizarTexto(nombreInicio);
        int inicio = grafo.indexOf(nombreInicio.trim());
        
        if (inicio == -1) {
            output.setText("❌ La proteína '" + nombreInicio + "' no existe en el grafo.");
            JOptionPane.showMessageDialog(this,
                "Proteína no encontrada.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
            }
        
        String[] opciones = {"BFS", "DFS"};
        int seleccion = JOptionPane.showOptionDialog(this,
            "¿Qué deseas usar para la ruta?",
            "Ruta Metabolica Más Corta",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
             opciones[0]);
        
        int [] resultado = null;
        switch (seleccion) {
            case 0:
                BFS buscadorB = new BFS();
                resultado = buscadorB.bfsComponente(inicio, grafo);
                break;
            case 1:
                DFS buscadorD = new DFS();
                resultado = buscadorD.dfsComponente(inicio, grafo);
                break;
        }
        output.setText("Complejos Proteicos Detectados\n");
        output.append("========================================\n");
        output.append("Proteína inicial: " + nombreInicio + "\n");
        output.append("Proteínas en el componente: " + resultado.length + "\n\n");

        for (int i = 0; i < resultado.length; i++) {
            output.append((i + 1) + ". " + grafo.getNombres()[resultado[i]] + "\n");
        }
        
    }//GEN-LAST:event_DCPActionPerformed
    
    /**
     * Este procedimiento le pregunta al usuario por dos nombres de proteinas para luego  llamar una clase Djikstra y encontrar la ruta mas corta.
     * @param evt 
     */
    private void RMMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RMMCActionPerformed
        if (grafo == null || grafo.getCantidadProteinas() < 2) {
            output.setText("❌ No hay suficientes proteínas para calcular rutas.");
            return;
        }
        
        String origen = JOptionPane.showInputDialog(this, "Nombre de la Proteína de Origen:");
        String destino = JOptionPane.showInputDialog(this, "Nombre de la Proteína de Destino:");
        
        //añadi estas lineas para normalizar la busqueda
        origen = Normalizador.NormalizarTexto(origen);
        destino = Normalizador.NormalizarTexto(destino);
        
        if (origen == null || destino == null || origen.trim().isEmpty() || destino.trim().isEmpty()) {
            output.setText("❌ Entrada inválida.");
            return;
        }
        int inicio = grafo.indexOf(origen.trim());
        int fin = grafo.indexOf(destino.trim());
        
        if (inicio == -1 || fin == -1) {
            output.setText("❌ Una o ambas proteínas no existen en el grafo.");
            JOptionPane.showMessageDialog(this,
                "Proteína no encontrada.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (inicio == fin) {
            output.setText("❌ El origen y destino son la misma proteína.");
            return;
        }
        try {
            Dijkstra dijkstra = new Dijkstra(grafo, inicio);
            dijkstra.algoritmoDijkstra(grafo, fin);
            Lista<Integer> ruta = dijkstra.obtenerCamino(fin);
            
            output.setText("Ruta Metabólica Más Corta\n");
            output.append("========================================\n");
            output.append("Origen: " + origen + " → Destino: " + destino + "\n");
            output.append("Costo total: " + dijkstra.getDistancia(fin) + "\n\n");
            output.append("Secuencia de proteínas:\n");
            
            // La lista viene en orden inverso (destino → origen), hay que invertirla
            for (int i = ruta.getiN() - 1; i >= 0; i--) {
                int nodo = ruta.buscarPosición(i);
                output.append("   → " + grafo.getNombres()[nodo] + "\n");
            }
            if (dijkstra.getDistancia(fin) == 1073741823) {
                output.setText("❌ No hay rutas disponibles.");
            }
            } catch (Exception e) {
            output.setText("❌ Error al calcular ruta: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            

        }
            
    
    }//GEN-LAST:event_RMMCActionPerformed
    
    /**
     * Este procedimiento busca la centralidad del grafo para encontrar la proteina (o proteinas si hay varias de misma cantidad) con la mayor cantidad de conexiones.
     * @param evt 
     */
    private void HubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HubsActionPerformed
     if (grafo == null || grafo.getCantidadProteinas() == 0) {
            output.setText("❌ El grafo está vacío.");
            return;
        }
        
        CentralidadGrado cg = new CentralidadGrado(grafo);
        Lista<Integer> mejorProteinaLista = cg.centralidadPosicion();
        output.setText("Identificación de Hubs (Centralidad de Grado)\n");
        output.append("========================================\n"); 
        
        if (mejorProteinaLista.getiN() != 0) { //Modifique esta función para iterar por todas las proteinas de mayor tamaño.
            for (int i = 0; i < mejorProteinaLista.getiN(); i++) {
                  int iDProteina = mejorProteinaLista.buscarPosición(i);
                  String nombreMejor = grafo.getNombres()[iDProteina];
                  int cantidadConexiones = cg.grado(iDProteina, grafo.getCantidadProteinas());
                output.append("Proteína más esencial (Hub): " + nombreMejor + "\n");
                output.append("Cantidad de interacciones: " + cantidadConexiones + "\n");
                output.append("Índice en memoria: " + grafo.indexOf(nombreMejor)+ "\n\n");
                output.append("========================================\n"); 

                JOptionPane.showMessageDialog(this,
                    "Hub identificado: " + nombreMejor + "\n" +
                    "Conexiones: " + cantidadConexiones,
                    "Hub Detectado",
                    JOptionPane.INFORMATION_MESSAGE);  
            }
            output.append(" Esta proteína es una diana terapéutica primaria.\n");
            output.append(" Si es anulada, podría mitigar el efecto del patógeno.");
        } else {
            output.setText("❌ No se pudo identificar ningún Hub.");
        }
        
    
    }//GEN-LAST:event_HubsActionPerformed
    /**
     * Este procedimiento le pregunta al usuario si quiere crear un nuevo grafo, si el usuario pone si, se crea un nuevo grafo.
     * @param evt 
     */
    private void GrafoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrafoNuevoActionPerformed
        String[] opciones = {"Sí", "No", "Cancelar"};
        int seleccion = JOptionPane.showOptionDialog(this,
            "¿Desea guardar el grafo actual antes de crear un nuevo grafo?",
            "Nuevo Grafo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
             opciones[0]);
        switch (seleccion) {
            case 0: 
                ActualizarRepositorioActionPerformed(evt);
                grafo = new Grafo(2);
                guardadoCSV.setArchivoActual(null);
                output.setText("Nuevo grafo vacio creado.");
                break;
            case 1:
                grafo = new Grafo(2);
                guardadoCSV.setArchivoActual(null);
                output.setText("Nuevo grafo vacio creado.");
                break;
                
            case 2:
                output.setText("❌ Nuevo grafo cancelado.");
                break;
                        
        }
    }//GEN-LAST:event_GrafoNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarRepositorio;
    private javax.swing.JButton CargarArchivo;
    private javax.swing.JButton DCP;
    private javax.swing.JButton GrafoNuevo;
    private javax.swing.JButton Hubs;
    private javax.swing.JButton ModificarGrafo;
    private javax.swing.JButton MostrarGrafo;
    private javax.swing.JButton RMMC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea output;
    // End of variables declaration//GEN-END:variables
}