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
    private int inicio;
    
    public void iniciarDijkstra(Grafo grafo, int inicio){
        int cantidadProteinas = grafo.getCantidadProteinas();
        this.explorados = new boolean[cantidadProteinas];
        this.distancias = new int[cantidadProteinas];
        this.predecesores = new int[cantidadProteinas];
        this.inicio = inicio;
        
        for (int i = 0; i < cantidadProteinas; i++){
        this.explorados[i] = false; 
        this.distancias[i] = 99999; //tuve que cambiar esto de -10 a 99999 porque en dijkstra los numeros negativos joden la logica
        this.predecesores[i] = 99999;
        }
        this.distancias[inicio] = 0; //se define la distancia del nodo de inicio como 0
    } 
    public Grafo algoritmoDijkstra(Grafo grafo, int objetivo)
    {
        int cantidadNodos = grafo.getCantidadProteinas();
        if (cantidadNodos <= 1)
        {
            return null;
        }
        else
        {
            for (int i = 0; i < cantidadNodos; i++) //aqui esta la logica de cada iteracion dijkstra [i = iteraci�n]
            {
                int nodoIteracion = encontrarNodoMasCorto();
            }
            return null;
        }
    }
    
    private int encontrarNodoMasCorto(){
        int distanciaMasCorta = 99999; //se define un valor que sirve como comparaci�n, todos los nodos validos tienen que ser menores o iguales a este valor [n = Nodo]
        int indiceDistanciaMasCorta = -1; //se mantiene grabada el indice del nodo con la conexi�n mas corta
        
        for (int n = 0; n < this.distancias.length; n++) //aqui se va a iterar por todos los nodos, si uno aun no se ha explorado y su valor es menor o igual al valor minimo, se convierte en el valor minimo
        {
            if (this.explorados[n] == false && this.distancias[n] <= distanciaMasCorta)
            {
                distanciaMasCorta = this.distancias[n];
                indiceDistanciaMasCorta = n;
            }
        }
        return indiceDistanciaMasCorta;
    }
}
