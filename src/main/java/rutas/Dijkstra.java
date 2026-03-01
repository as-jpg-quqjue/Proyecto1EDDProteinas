package main.java.rutas;

import main.java.Primitivas.Grafo;
import main.java.Primitivas.Lista;

/**
 * Implementa el algoritmo de Dijkstra para encontrar la ruta más corta.
 * @author mipc2
 */
public class Dijkstra {
    
    private boolean[] explorados;
    private int[] distancias;
    private int[] predecesores;
    private int inicio;
    private int infinito = Integer.MAX_VALUE / 2;
    
    public Dijkstra(Grafo grafo, int inicio) {
        int cantidadProteinas = grafo.getCantidadProteinas();
        this.explorados = new boolean[cantidadProteinas];
        this.distancias = new int[cantidadProteinas];
        this.predecesores = new int[cantidadProteinas];
        this.inicio = inicio;
        
        for (int i = 0; i < cantidadProteinas; i++) {
            this.explorados[i] = false;
            this.distancias[i] = infinito;
            this.predecesores[i] = -1;
        }
        this.distancias[inicio] = 0;
    }
    
    /**
     * Ejecuta el algoritmo de Dijkstra desde el nodo inicio hasta el objetivo.
     * @param grafo El grafo a recorrer
     * @param objetivo Índice del nodo destino
     * @return Grafo con la ruta más corta o null si no hay ruta
     */
    public Grafo algoritmoDijkstra(Grafo grafo, int objetivo) {
        int cantidadNodos = grafo.getCantidadProteinas();
        
        if (cantidadNodos <= 1) {
            return null;
        }
        
        for (int i = 0; i < cantidadNodos; i++) {
            int nodoIteracion = encontrarNodoMasCorto();
            
            if (nodoIteracion == -1) {
                break;
            }
            
            this.explorados[nodoIteracion] = true;
            
            for (int j = 0; j < cantidadNodos; j++) {
                if (!this.explorados[j] && grafo.getMatrizPeso()[nodoIteracion][j] != 9999) {
                    int distanciaNueva = this.distancias[nodoIteracion] + 
                                        grafo.getMatrizPeso()[nodoIteracion][j];
                    
                    if (distanciaNueva < this.distancias[j]) {
                        this.distancias[j] = distanciaNueva;
                        this.predecesores[j] = nodoIteracion;
                    }
                }
            }
        }
        
        if (this.distancias[objetivo] >= infinito) {
            return null;
        }
        
        // Construir grafo de ruta
        Grafo ruta = new Grafo(cantidadNodos);
        ruta.iniciarMatriz(0, cantidadNodos);
        
        int nodoActual = objetivo;
        while (nodoActual != inicio && nodoActual != -1) {
            int anterior = predecesores[nodoActual];
            if (anterior == -1) break;
            
            int indiceNodoActual = ruta.agregarProteina(grafo.getNombres()[nodoActual]);
            int indiceAnterior = ruta.agregarProteina(grafo.getNombres()[anterior]);
            int peso = grafo.getMatrizPeso()[nodoActual][anterior];
            
            ruta.agregarConexiónInt(indiceNodoActual + 1, indiceAnterior + 1, peso);
            nodoActual = anterior;
        }
        
        return ruta;
    }
    
    /**
     * Encuentra el nodo no explorado con la distancia más corta.
     * @return Índice del nodo o -1 si no hay más nodos
     */
    private int encontrarNodoMasCorto() {
        int distanciaMasCorta = infinito;
        int indiceDistanciaMasCorta = -1;
        
        for (int n = 0; n < this.distancias.length; n++) {
            if (!this.explorados[n] && this.distancias[n] <= distanciaMasCorta) {
                distanciaMasCorta = this.distancias[n];
                indiceDistanciaMasCorta = n;
            }
        }
        
        // ✅ ELIMINADO: System.out.println(indiceDistanciaMasCorta);
        return indiceDistanciaMasCorta;
    }
    
    /**
     * Obtiene el camino como lista de índices desde inicio hasta objetivo.
     * @param objetivo Índice del nodo destino
     * @return Lista con los índices del camino
     */
    public Lista<Integer> obtenerCamino(int objetivo) {
        Lista<Integer> camino = new Lista<>();
        
        if (this.distancias[objetivo] >= infinito) {
            return camino;
        }
        
        int nodoActual = objetivo;
        while (nodoActual != -1) {
            camino.insertar(nodoActual);
            nodoActual = predecesores[nodoActual];
        }
        
        return camino;
    }
    
    /**
     * Obtiene la distancia total hasta un nodo.
     * @param nodo Índice del nodo
     * @return La distancia o infinito si no hay ruta
     */
    public int getDistancia(int nodo) {
        return distancias[nodo];
    }
    
}
