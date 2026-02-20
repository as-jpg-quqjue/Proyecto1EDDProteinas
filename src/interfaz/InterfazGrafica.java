/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;

/**
 *
 * @author josep
 */
import primitivas.Grafo;
import buscadores.BFS;
import buscadores.DFS;
import buscadores.CentralidadGrado;
import rutas.Dijkstra;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InterfazGrafica extends javax.swing.JPanel {
    
    // VARIABLE GLOBAL PARA MANTENER EL GRAFO EN MEMORIA
    private Grafo grafo; 

    public InterfazGrafica() {
        initComponents();
        // Inicializamos un grafo vacío por defecto
        grafo = new Grafo(10); 
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
        textArea1 = new java.awt.TextArea();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
       String[] opciones = {"Agregar Proteína", "Eliminar Proteína"};
        int seleccion = JOptionPane.showOptionDialog(this, "¿Qué deseas hacer?", "Modificar Grafo", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        
        if (seleccion == 0) { // Agregar
            String nombre = JOptionPane.showInputDialog("Nombre de la nueva proteína:");
            if(nombre != null && !nombre.trim().isEmpty()){
                grafo.agregarProteina(nombre);
                textArea1.setText("Proteína '" + nombre + "' agregada con éxito.");
            }
        } else if (seleccion == 1) { // Eliminar
            String nombre = JOptionPane.showInputDialog("Nombre de la proteína a eliminar:");
            if(nombre != null && !nombre.trim().isEmpty()){
                grafo.removerProteina(nombre);
                textArea1.setText("Proteína '" + nombre + "' ha sido desactivada/eliminada.");
            }
        }
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(this, "Recuerda guardar los datos actuales en el repositorio antes de cargar un archivo nuevo.", "Aviso", JOptionPane.WARNING_MESSAGE);
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto o CSV", "txt", "csv"));
        
        int seleccion = fileChooser.showOpenDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            textArea1.setText("Archivo seleccionado:\n" + archivoSeleccionado.getAbsolutePath() + "\n\n");
    }//GEN-LAST:event_jButton4ActionPerformed
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      textArea1.setText("Iniciando guardado...\n");
        // Tienes que recorrer la matriz de tu 'grafo', y si hay conexión, escribir en el TXT:
        // Origen, Destino, Peso
        textArea1.append("Debes usar un FileWriter para guardar el grafo de memoria al TXT.");
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       textArea1.setText("Para visualizar el grafo, aquí debes invocar tu código de GraphStream.\n");
        // Aquí deberás crear tu org.graphstream.graph.Graph, pasarle los nodos y aristas 
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (grafo.getCantidadProteinas() == 0) {
            textArea1.setText("El grafo está vacío. Carga un archivo primero.");
            return;
        }
        
        textArea1.setText("--- Detectando Complejos (BFS) ---\n");
        BFS buscador = new BFS();
        
       int[] resultado = buscador.bfsComponente(0, grafo);
        
        textArea1.append("Nodos en el componente partiendo del índice 0:\n");
        for (int i = 0; i < resultado.length; i++) {
            // Buscamos el nombre de la proteína en ese índice
            String nombre = grafo.getNombres()[resultado[i]];
            textArea1.append("- " + nombre + "\n");
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (grafo.getCantidadProteinas() < 2) {
            textArea1.setText("No hay suficientes proteínas para calcular rutas.");
            return;
        }
        // Pedimos los índices (o puedes modificarlo para pedir nombres)
        try {
            String origen = JOptionPane.showInputDialog("Índice o Nombre de la Proteína de Origen:");
            String destino = JOptionPane.showInputDialog("Índice o Nombre de la Proteína de Destino:");
            
            int inicio = Integer.parseInt(origen);
            int fin = Integer.parseInt(destino);
            
            Dijkstra dijkstra = new Dijkstra();
            dijkstra.algoritmoDijkstra(grafo, inicio);
            List<Integer> ruta = dijkstra.obtenerRuta(fin);
            
            textArea1.setText("Ruta más corta desde " + inicio + " hasta " + fin + ":\n");
            for(int nodo : ruta){
                textArea1.append("-> Nodo " + nodo + " (" + grafo.getNombres()[nodo] + ")\n");
            }
        } catch (Exception e) {
            textArea1.setText("Error: Por favor introduce índices válidos.");
        }
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     if (grafo.getCantidadProteinas() == 0) {
            textArea1.setText("El grafo está vacío.");
            return;
        }
        
        CentralidadGrado cg = new CentralidadGrado(grafo);
        int mejorProteinaIndex = cg.centralidad();
        if (mejorProteinaIndex != -1) {
            String nombreMejor = grafo.getNombres()[mejorProteinaIndex];
            int cantidadConexiones = cg.grado(mejorProteinaIndex, grafo.getCantidadProteinas());
            
            textArea1.setText("--- Principal Hub Detectado ---\n");
            textArea1.append("Proteína más esencial: " + nombreMejor + "\n");
            textArea1.append("Cantidad de interacciones: " + cantidadConexiones + "\n");
            textArea1.append("Índice en memoria: " + mejorProteinaIndex);
        } else {
            textArea1.setText("No se pudo identificar ningún Hub.");
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
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
