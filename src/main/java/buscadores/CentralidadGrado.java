/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.buscadores;

import main.java.Primitivas.Grafo;

/**
 *Busca la proteina con mayor cantidad de conexiones.
 * @author cesar
 */
public class CentralidadGrado {
    private Grafo grafoAux;

    public CentralidadGrado(Grafo grafo) {
        this.grafoAux = grafo;
    }
    /** 
     * Devuelve la posición (int) donde esta la proteina con mayor cantidad de conexiones.
     * @return Un entero que es el indice de la proteina con mayor cantidad de conexiónes.
     */
    
    public int centralidadPosicion (){
        
        
        int mejorProteina = -1;
        int mejorGrado = -1;
        
        for (int i = 0; i < grafoAux.getCantidadProteinas(); i++) {
            int d = grado(i, grafoAux.getCantidadProteinas());
            
            if (d > mejorGrado) {
                mejorGrado = d;
                mejorProteina = i;
            }
        }
        
        return mejorProteina;
    }
    
 /**
  * Esta función busca el nodo central utilizando un nombre y la función centralidadPosicion.
  * @return Un string que es el nombre de la proteina con mayor cantidad de conexiones.

  */
    public String centralidadNombre (){
        return grafoAux.getNombres()[this.centralidadPosicion()];
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
