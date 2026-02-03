/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import buscadores.CentralidadGrado;
import java.util.Arrays;
import primitivas.Grafo;
import rutas.Dijkstra;

/**
 *
 * @author mipc2
 */
public class Proyecto1EDD {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Grafo grafo = new Grafo(5);
        grafo.iniciarMatriz(0, 5);
        
        grafo.agregarProteina("b1");
        grafo.agregarProteina("c1");
        grafo.agregarProteina("a1");
        grafo.agregarProteina("d1");
        
        grafo.agregarConexión(3, 1, 20);
        grafo.agregarConexión(3, 2, 30);
        grafo.agregarConexión (3, 4, 16);
        grafo.agregarConexión(2, 4, 25);
        
        //grafo.imprimirMatrizPeso();
        //grafo.getActivas();
        
        //System.out.println(new CentralidadGrado(grafo).centralidad());
        System.out.println(grafo.indexOf("d1"));
        
        
        Dijkstra algoritmo = new Dijkstra (grafo, 0);
        Grafo prueba = algoritmo.algoritmoDijkstra(grafo, 3);
        
        if (prueba != null) {
            System.out.println("--- RUTA MÁS CORTA ENCONTRADA ---");
            imprimirResumenRuta(prueba);
        }
        
        //System.out.println(Arrays.toString(grafo.getMatrizPeso()));
        
    }
    
    public static void imprimirResumenRuta(Grafo g) { //esto me lo dio chatgpt para revisar que el dijkstra esta funcionando bien
    String[] nombres = g.getNombres();
    int[][] pesos = g.getMatrizPeso();
    // Usamos la longitud del arreglo para no saltarnos nada
    int n = nombres.length; 

    System.out.println("Detalle de la trayectoria:");
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            // Verificamos que los nombres existan y el peso sea válido
            if (nombres[i] != null && nombres[j] != null && pesos[i][j] != 9999) {
                System.out.println(nombres[i] + " <---(" + pesos[i][j] + ")---> " + nombres[j]);
            }
        }
    }
}
}
