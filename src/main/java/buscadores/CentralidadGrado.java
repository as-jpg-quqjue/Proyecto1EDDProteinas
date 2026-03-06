/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.buscadores;

import main.java.Primitivas.Grafo;
import main.java.Primitivas.Lista;

/**
 *Busca la proteina con mayor cantidad de conexiones.
 * @author cesar
 */
public class CentralidadGrado {
    /**
     * El grafo de referencia.
     */
    private Grafo grafoAux;
    
    /**
     * Se construye la centralidad asignando el grafo.
     * @param grafo El grafo que se va a pasar como el Grafo auxiliar.
     */
    public CentralidadGrado(Grafo grafo) {
        this.grafoAux = grafo;
    }
    /** 
     * Devuelve la posición (int) donde esta la proteina con mayor cantidad de conexiones. 
     * @return Una lista que contiene los indices de las proteinas hubs.
     */
    
    public Lista centralidadPosicion (){
        
        
        int mejorGrado = -1;
        Lista<Integer> mejoresProteinas = new Lista();
        
        for (int i = 0; i < grafoAux.getCantidadProteinas(); i++) {
            int d = grado(i, grafoAux.getCantidadProteinas());
            
            if (d > mejorGrado) {
                mejorGrado = d;
                mejoresProteinas = new Lista<>(); //en el caso donde se encuentra un grado mas grande, se limpia la lista 
                mejoresProteinas.insertar(i);
            }
            
            else if (d == mejorGrado && mejorGrado != -1){
                mejoresProteinas.insertar(i); //esta función se tuvo que modificar para poder añadir mas proteinas que tenga la misma cantidad de conexiones, y que estas ambas sean la mayor
            }
        }
        
        return mejoresProteinas;
    }
    
 /**
  * Esta función busca el nodo central utilizando un nombre y la función centralidadPosicion. Como precondición la lista que se pasa no puede estar vacía.
  * @param indice Un int que es la posición en la lista donde se desea buscar las mejores proteinas.
  * @return Un string que es el nombre de la proteina con mayor cantidad de conexiones.

  */
    public String centralidadNombre (int indice){
        Lista<Integer> mejoresProteinas = this.centralidadPosicion();
        int proteinId = mejoresProteinas.buscarPosición(indice);   
        return grafoAux.getNombres()[proteinId];
    }
    
    /**
     * Esta función recibe el indice de una proteina y el tamaño de proteinas totales, y va contando cuantas conexiones tiene esta proteina.
     * @param i Entero que es el indice de una proteina para buscar el grado del mismo.
     * @param n Entero que es la cantidad de proteinas totales del grafo.
     * @return Un entero que dice cuantas proteinas estan conectadas a i.
     */
    public int grado (int i, int n){
        int d = 0;
        
        if (i < 0 || i >= n) {
            return 0;
        }
        for (int j = 0; j < n; j++) {
            if (grafoAux.estanConectadas(i, j)) {
                d++;  
            }
        }
        return d;
    }
}
