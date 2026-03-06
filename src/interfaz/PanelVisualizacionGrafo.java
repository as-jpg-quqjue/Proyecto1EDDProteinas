/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.PanelVizualizacionGrafo to edit this template
 */
package interfaz;

import main.java.Primitivas.Grafo;
import main.java.buscadores.CentralidadGrado;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;

import javax.swing.*;
import java.awt.*;

/**
 * Panel para visualización del grafo con GraphStream.
 * Muestra nodos (proteínas) y aristas (interacciones) de forma visual.
 * @author jossep
 */
public class PanelVisualizacionGrafo extends JPanel {
    
    /**
     * El grafo de GraphStream para visualizar.
     */
    private Graph grafoVisual;
    
    /**
     * Esta es una constante de infinito para utilizar cuando no hay conexiones entre proteinas. Se realiza un entero maximo entre dos para evitar problemas de overflow.
     */
    private int infinito = Integer.MAX_VALUE / 2;
    
    /**
     * El SwingViewer de GraphStream.
     */
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
                "node { fill-color: rgb(100,150,255); size: 20px; text-color: black; text-style: bold; text-size: 12; } " + //cambie el color de texto de blanco a negro aqui
                "edge { fill-color: rgb(200,200,200); text-size: 10; text-color: rgb(100,100,100); arrow-shape: none; } " +
                "graph { canvas-color: white; padding: 20px; fill-mode: plain; }");
            
            String[] nombres = grafo.getNombres();
            boolean[] activas = grafo.getActivas();
            int[][] matriz = grafo.getMatrizPeso();
            int n = grafo.getCantidadProteinas();
            CentralidadGrado centralidad = new CentralidadGrado(grafo);
            
            // Agregar nodos (solo proteínas activas)
            for (int i = 0; i < n; i++) {
                if (nombres[i] != null && activas[i]) {
                    org.graphstream.graph.Node nodo = grafoVisual.addNode(nombres[i]);
                    nodo.setAttribute("ui.label", nombres[i]);
                    
                    // Resaltar Hubs (≥5 conexiones) en rojo
                    if (centralidad.grado(i, n) >= 5) {
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
            System.setProperty("org.graphstream.ui", "swing"); //hay que decirle explicitamente al graphstream que use el renderer que necesitamos, en este caso swing
            //se crea esto en un thread separado
            viewer = new SwingViewer(grafoVisual, SwingViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
            viewer.enableAutoLayout();
            
            org.graphstream.ui.swing_viewer.ViewPanel viewPanel = (org.graphstream.ui.swing_viewer.ViewPanel) viewer.addDefaultView(false); //esta linea crea el viewer para renderizar el grafo
            this.removeAll(); //esta linea limpia toda la data que el PanelVisualizacionGrafo aun puede tener
            this.add(viewPanel, BorderLayout.CENTER); //esto linea añade el viewer al JPanel, que en este caso es PanelVisualizacionGrafo
            this.revalidate(); 
            this.repaint(); //estas dos lineas aseguran que la ventana se esta poniendo en display de forma correcta
            viewPanel.requestFocusInWindow();
            
            JOptionPane.showMessageDialog(this, 
                "✅ Grafo visualizado en ventana emergente.\n" +
                "- Nodos azules: Proteínas normales\n" +
                "- Nodos rojos: Hubs (≥5 conexiones)\n" +
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
     * Este procedimiento libera recursos del viewer al cerrar.
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