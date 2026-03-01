/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;

/**
 *
 * @author josep
 */

import main.java.Primitivas.Grafo;
import main.java.buscadores.BFS;
import main.java.buscadores.CentralidadGrado;
import main.java.rutas.Dijkstra;
import Main.java.Primitivas.Normalizador;
import java.io.File;
import java.io.IOException;
import main.java.Primitivas.Lista;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JDialog;  
import java.awt.Frame;      


public class InterfazGrafica extends javax.swing.JPanel {
    
    private GuardadoCSV gargar = new GuardadoCSV();
    
    private Grafo grafo;
    private GuardadoCSV guardadoCSV;
    private PanelVisualizacionGrafo panelVisualizacion;
    private JDialog dialogVisualizacion;
    
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Actualizar repositorio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("DCP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("RMMC");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Cargar Archivo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Modificar Grafo");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("Mostrar Grafo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setText("Ident. Hubs");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("BioGraph - Analisis de Interacciones Proteicas");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       if (grafo == null || grafo.getCantidadProteinas() == 0) {
            jTextArea1.setText("❌ No hay grafo cargado.");
            return;
        }
        
        String[] opciones = {"Agregar Proteína", "Eliminar Proteína", "Agregar Conexión"};
        int seleccion = JOptionPane.showOptionDialog(this,
            "¿Qué deseas hacer?",
            "Modificar Grafo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
             opciones[0]);
        
        switch (seleccion) { //cambie esto de un if a un switch para optimizar
            case 0:
                {
                    // Agregar Proteína
                    String nombre = JOptionPane.showInputDialog(this, "Nombre de la nueva proteína:");
                    if (nombre != null && !nombre.trim().isEmpty()) {
                            if (grafo.indexOf(nombre) == -1)
                            {
                            String nombreF = Normalizador.NormalizarTexto(nombre);
                            grafo.agregarProteina(nombreF.trim());
                            jTextArea1.setText("✅ Proteína '" + nombreF + "' agregada con éxito.");
                            } 
                            else { //este else es el caso donde la proteina ya existe
                            jTextArea1.setText("❌ Error: Esa proteina ya existe dentro del grafo."); 
                            JOptionPane.showMessageDialog(this,
                                "Esa proteina ya existe dentro del grafo.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                         }
                    break;
                    }
                    
                    else { //este else es el caso donde el nombre es nulo
                       jTextArea1.setText("❌ Error: No se puede insertar una proteina sin nombre."); 
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
                        if (grafo.indexOf(nombre) != -1)
                        {
                            grafo.removerProteina(nombre.trim());
                            jTextArea1.setText("✅ Proteína '" + nombre + "' ha sido desactivada.");
                        }
                        else
                        {//este else es el caso donde la proteina no existe
                        jTextArea1.setText("❌ Error: Esa proteina no existe."); 
                        JOptionPane.showMessageDialog(this,
                                "Esa proteina no existe.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                            
                        }
                        break;
                    }       
                    else //este es el caso donde el nombre insertado es vacio
                    {
                        jTextArea1.setText("❌ Error: No se puede eliminar una proteina sin nombre."); 
                            JOptionPane.showMessageDialog(this,
                                "No se puede eliminar una proteina sin nombre.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            case 2:
                // Agregar Conexión
                String origen = JOptionPane.showInputDialog(this, "Proteína Origen:");
                String destino = JOptionPane.showInputDialog(this, "Proteína Destino:");
                String pesoStr = JOptionPane.showInputDialog(this, "Peso/Costo de la conexión:");
                if (origen != null && destino != null && pesoStr != null && !origen.equals(destino)) {
                    try {
                        int peso = Integer.parseInt(pesoStr.trim());
                        grafo.agregarConexión(origen.trim(), destino.trim(), peso);
                        jTextArea1.setText("✅ Conexión agregada: " + origen + " ↔ " + destino +
                                " (peso: " + peso + ")");
                    } catch (NumberFormatException e) {
                        jTextArea1.setText("❌ Error: El peso debe ser un número entero.");
                        JOptionPane.showMessageDialog(this,
                                "El peso debe ser un número válido.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                else //este else se encarga de errores cuando intentas poner el destino igual al origen
                {
                    jTextArea1.setText("❌ Error: No puedes crear una conexión de una proteina a si misma.");
                    JOptionPane.showMessageDialog(this,
                            "No puedes crear una conexión de una proteina a si misma.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }   break;
            default:
                break;
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (grafo != null && grafo.getCantidadProteinas() > 0) {
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Deseas guardar los cambios antes de cargar un nuevo archivo?",
            "Guardar Cambios",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            jButton1ActionPerformed(evt); // Llamar al método de guardar
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
            // Cargar el grafo
            grafo = gargar.cargarGrafo(archivoSeleccionado);
            
            // ✅ Mostrar mensaje de éxito en la interfaz
            jTextArea1.setText("✅ Archivo cargado exitosamente:\n" + 
                             archivoSeleccionado.getName() + "\n\n" +
                             "Proteínas cargadas: " + grafo.getCantidadProteinas() + "\n" +
                             "Ubicación: " + archivoSeleccionado.getAbsolutePath());
            
            JOptionPane.showMessageDialog(this, 
                "✅ Archivo cargado: " + archivoSeleccionado.getName() + 
                "\nProteínas: " + grafo.getCantidadProteinas(), 
                "Carga Exitosa", 
                JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
            // ✅ Mostrar error visible al usuario
            jTextArea1.setText("❌ Error al cargar el archivo:\n" + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error al cargar: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            // ✅ Capturar cualquier otro error inesperado
            jTextArea1.setText("❌ Error inesperado: " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error inesperado: " + ex.getMessage(),
                "Error Crítico",
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if (grafo == null || grafo.getCantidadProteinas() == 0) {
            jTextArea1.setText("❌ No hay grafo en memoria para guardar.");
            JOptionPane.showMessageDialog(this,
                "No hay datos para guardar.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            String mensaje = guardadoCSV.guardar(grafo);
            jTextArea1.setText("✅ " + mensaje);
            JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            jTextArea1.setText("❌ Error al guardar: " + ex.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error al guardar: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     if (grafo == null || grafo.getCantidadProteinas() == 0) {
            jTextArea1.setText("❌ No hay grafo cargado. Carga un archivo primero.");
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
        
        jTextArea1.setText("✅ Grafo visualizado correctamente.\n" +
                         "Proteínas activas: " + grafo.getCantidadProteinas() + "\n" +
                         "Los nodos rojos representan Hubs (≥5 conexiones)");
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (grafo == null || grafo.getCantidadProteinas() == 0) {
            jTextArea1.setText("❌ El grafo está vacío. Carga un archivo primero.");
            return;
        }
        
        String nombreInicio = JOptionPane.showInputDialog(this,
            "Nombre de la proteína para iniciar BFS:");
        
        if (nombreInicio == null || nombreInicio.trim().isEmpty()) {
            return;
        }
        
        int inicio = grafo.indexOf(nombreInicio.trim());
        
        if (inicio == -1) {
            jTextArea1.setText("❌ La proteína '" + nombreInicio + "' no existe en el grafo.");
            JOptionPane.showMessageDialog(this,
                "Proteína no encontrada.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
            }
        
        BFS buscador = new BFS();
        int[] resultado = buscador.bfsComponente(inicio, grafo);
        
        jTextArea1.setText("🔍 Complejos Proteicos Detectados (BFS)\n");
        jTextArea1.append("========================================\n");
        jTextArea1.append("Proteína inicial: " + nombreInicio + "\n");
        jTextArea1.append("Proteínas en el componente: " + resultado.length + "\n\n");
        
        for (int i = 0; i < resultado.length; i++) {
            jTextArea1.append((i+1) + ". " + grafo.getNombres()[resultado[i]] + "\n");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (grafo == null || grafo.getCantidadProteinas() < 2) {
            jTextArea1.setText("❌ No hay suficientes proteínas para calcular rutas.");
            return;
        }
        
        String origen = JOptionPane.showInputDialog(this, "Nombre de la Proteína de Origen:");
        String destino = JOptionPane.showInputDialog(this, "Nombre de la Proteína de Destino:");
        
        if (origen == null || destino == null || origen.trim().isEmpty() || destino.trim().isEmpty()) {
            jTextArea1.setText("❌ Entrada inválida.");
            return;
        }
        int inicio = grafo.indexOf(origen.trim());
        int fin = grafo.indexOf(destino.trim());
        
        if (inicio == -1 || fin == -1) {
            jTextArea1.setText("❌ Una o ambas proteínas no existen en el grafo.");
            JOptionPane.showMessageDialog(this,
                "Proteína no encontrada.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (inicio == fin) {
            jTextArea1.setText("❌ El origen y destino son la misma proteína.");
            return;
        }
        try {
            Dijkstra dijkstra = new Dijkstra(grafo, inicio);
            dijkstra.algoritmoDijkstra(grafo, fin);
            Lista<Integer> ruta = dijkstra.obtenerCamino(fin);
            
            jTextArea1.setText("🛤️ Ruta Metabólica Más Corta\n");
            jTextArea1.append("========================================\n");
            jTextArea1.append("Origen: " + origen + " → Destino: " + destino + "\n");
            jTextArea1.append("Costo total: " + dijkstra.getDistancia(fin) + "\n\n");
            jTextArea1.append("Secuencia de proteínas:\n");
            
            // La lista viene en orden inverso (destino → origen), hay que invertirla
            for (int i = ruta.getiN() - 1; i >= 0; i--) {
                int nodo = ruta.buscarPosición(i);
                jTextArea1.append("   → " + grafo.getNombres()[nodo] + "\n");
            }
            } catch (Exception e) {
            jTextArea1.setText("❌ Error al calcular ruta: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
            
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     if (grafo == null || grafo.getCantidadProteinas() == 0) {
            jTextArea1.setText("❌ El grafo está vacío.");
            return;
        }
        
        CentralidadGrado cg = new CentralidadGrado(grafo);
        int mejorProteinaIndex = cg.centralidadPosicion();
        
        if (mejorProteinaIndex != -1) {
            String nombreMejor = grafo.getNombres()[mejorProteinaIndex];
            int cantidadConexiones = cg.grado(mejorProteinaIndex, grafo.getCantidadProteinas());
            
            jTextArea1.setText("🎯 Identificación de Hubs (Centralidad de Grado)\n");
            jTextArea1.append("========================================\n");
            jTextArea1.append("Proteína más esencial (Hub): " + nombreMejor + "\n");
            jTextArea1.append("Cantidad de interacciones: " + cantidadConexiones + "\n");
            jTextArea1.append("Índice en memoria: " + mejorProteinaIndex + "\n\n");
            jTextArea1.append("💡 Esta proteína es una diana terapéutica primaria.\n");
            jTextArea1.append("   Si es anulada, podría mitigar el efecto del patógeno.");
            
            JOptionPane.showMessageDialog(this,
                "Hub identificado: " + nombreMejor + "\n" +
                "Conexiones: " + cantidadConexiones,
                "Hub Detectado",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            jTextArea1.setText("❌ No se pudo identificar ningún Hub.");
        }
        
    
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}