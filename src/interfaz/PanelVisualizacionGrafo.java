/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.PanelVizualizacionGrafo to edit this template
 */
package interfaz;

import main.java.Primitivas.Grafo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;

import javax.swing.*;
import java.awt.*;

/**
 * Panel para visualización del grafo con GraphStream.
 * Muestra nodos (proteínas) y aristas (interacciones) de forma visual.
 * @author Equipo BioGraph
 */
public class PanelVisualizacionGrafo extends JPanel {
    
    private Graph grafoVisual;
    private SwingViewer viewer;
    
    /**
     * Constructor del panel de visualización.
     */
    public PanelVisualizacionGrafo() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
    }
    
    /**
     * Configura y muestra el grafo visualmente usando GraphStream.
     * @param grafo El grafo de proteínas a visualizar
     */
    public void visualizarGrafo(Grafo grafo) {
        if (grafo == null || grafo.getCantidadProteinas() == 0) {
            JOptionPane.showMessageDialog(this, 
                "No hay grafo cargado.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            // Limpiar grafo visual anterior
            if (grafoVisual != null) {
                grafoVisual.clear();
            }
            
            // Crear nuevo grafo visual de GraphStream
            grafoVisual = new SingleGraph("BioGraph");
            
            // Estilos CSS para el grafo
            grafoVisual.setAttribute("ui.stylesheet", 
                "node { fill-color: rgb(100,150,255); size: 20px; text-color: white; text-size: 12; } " +
                "edge { fill-color: rgb(200,200,200); text-size: 10; text-color: rgb(100,100,100); } " +
                "graph { background-color: white; padding: 20px; }");
            
            String[] nombres = grafo.getNombres();
            boolean[] activas = grafo.getActivas();
            int[][] matriz = grafo.getMatrizPeso();
            int n = grafo.getCantidadProteinas();
            
            // Agregar nodos (solo proteínas activas)
            for (int i = 0; i < n; i++) {
                if (activas[i] && nombres[i] != null) {
                    org.graphstream.graph.Node nodo = grafoVisual.addNode(nombres[i]);
                    nodo.setAttribute("ui.label", nombres[i]);
                    
                    // Resaltar Hubs (≥5 conexiones) en rojo
                    if (calcularGrado(i, n, matriz, activas) >= 5) {
                        nodo.setAttribute("ui.style", 
                            "fill-color: rgb(255,100,100); size: 25px;");
                    }
                }
            }
            
            // Agregar aristas (evitando duplicados con j = i + 1)
            for (int i = 0; i < n; i++) {
                if (!activas[i]) continue;
                for (int j = i + 1; j < n; j++) {
                    if (!activas[j]) continue;
                    if (grafo.estanConectadas(i, j)) {
                        String idArista = nombres[i] + "-" + nombres[j];
                        grafoVisual.addEdge(idArista, nombres[i], nombres[j], true)
                               .setAttribute("ui.label", String.valueOf(matriz[i][j]));
                    }
                }
            }
            
            // Crear viewer en thread separado
            viewer = new SwingViewer(grafoVisual, SwingViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
            viewer.enableAutoLayout();
            
            grafoVisual.setAttribute("ui.stylesheet", 
    "graph { background-color: white; padding: 20px; } " +
    "node { fill-color: rgb(100,150,255); size: 20px; text-color: white; text-size: 12; } " +
    "edge { fill-color: rgb(200,200,200); text-size: 10; text-color: rgb(100,100,100); }");
            
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, 
                "✅ Grafo visualizado en ventana emergente.\n" +
                "• Nodos azules: Proteínas normales\n" +
                "• Nodos rojos: Hubs (≥5 conexiones)\n" +
                "Cierra la ventana del grafo para continuar.",
                "Visualización Exitosa", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al visualizar: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    /**
     * Calcula el grado de un nodo (cantidad de conexiones activas).
     * @param i Índice del nodo
     * @param n Cantidad total de proteínas
     * @param matriz Matriz de pesos del grafo
     * @param activas Array de proteínas activas
     * @return Número de conexiones del nodo
     */
    private int calcularGrado(int i, int n, int[][] matriz, boolean[] activas) {
        int grado = 0;
        for (int j = 0; j < n; j++) {
            if (i != j && activas[j] && matriz[i][j] != 9999) {
                grado++;
            }
        }
        return grado;
    }
    
    /**
     * Libera recursos del viewer al cerrar.
     */
    public void liberarRecursos() {
        if (viewer != null) {
            viewer.close();
        }
    }
}

/**
 * @author josep
 */