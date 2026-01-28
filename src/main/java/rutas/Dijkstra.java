/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rutas;

import primitivas.Grafo;

/**
 *
 * @author mipc2
 */
public class Dijkstra {
    private boolean[] explorados; //este array mantendra cuenta de los nodos explorados y no explorados segun el indice que se coloque
    private int[] distancias; //este array mantendra la distancias entre los arrays desde el nodo de inicio segun el indice que se coloque
    private int[] predecesores; //este array mantendra cuenta de los predecesores segun el indice que se le coloque
    
    public void iniciarDijkstra(Grafo grafo, int inicio){
        int cantidadProteinas = grafo.getCantidadProteinas();
        this.explorados = new boolean[cantidadProteinas];
        this.distancias = new int[cantidadProteinas];
        this.predecesores = new int[cantidadProteinas];
        
        for (int i = 0; i < cantidadProteinas; i++){
        this.explorados[i] = false; 
        this.distancias[i] = -10;
        this.predecesores[i] = -10;
        }
        this.distancias[inicio] = 0; //se define la distancia del nodo de inicio como 0
    } 
}
