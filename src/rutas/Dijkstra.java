/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rutas;

import java.util.ArrayList;
import java.util.List;
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
    public void algoritmoDijkstra(Grafo grafo, int inicio) {
    iniciarDijkstra(grafo, inicio);
    int cantidadNodos = grafo.getCantidadProteinas();
    
    for (int iter = 0; iter < cantidadNodos; iter++) {
        int u = encontrarNodoMasCorto();
        if (u == -1 || distancias[u] == 99999) break; // Sin más nodos alcanzables
        
        explorados[u] = true;
        
        // Relajar aristas desde u
        for (int v = 0; v < cantidadNodos; v++) {
            if (grafo.estanConectadas(u, v) && !explorados[v]) {
                int peso = grafo.getMatrizPeso()[u][v];
                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    predecesores[v] = u; // ✅ Usar -1 para "sin predecesor"
                }
            }
        }
    }
}

// Método auxiliar para obtener la ruta (opcional)
public List<Integer> obtenerRuta(int destino) {
    List<Integer> ruta = new ArrayList<>();
    for (int v = destino; v != -1 && v != inicio; v = predecesores[v]) {
        ruta.add(0, v); // Insertar al inicio
    }
    if (predecesores[destino] != -1) ruta.add(0, inicio);
    return ruta;
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
