/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscadores;

import primitivas.Grafo;

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
    * Devuelve el nombre de la proteina con mayor cantidad de conexiones.
    */
    public String centralidadNombre (){
        return grafoAux.getNombres()[this.centralidadPosicion()];
    }
    
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
