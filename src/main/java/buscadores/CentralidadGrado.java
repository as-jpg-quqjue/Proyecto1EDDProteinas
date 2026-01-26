/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscadores;

import primitivas.Grafo;

/**
 *
 * @author cesar
 */
public class CentralidadGrado {
    private Grafo grafoAux;

    public CentralidadGrado(Grafo grafo) {
        this.grafoAux = grafo;
    }
    
    public int centralidad (){
        
        
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
    
    public int grado (int i, int n){
        int d = 0;
        
        if (i < 0 || i >= n) {
            return 0;
        }
        for (int j = 0; j < n; j++) {
            if (grafoAux.estanConectadas(i, j)) {
                System.out.println(i + " " + j);
                d++;  
            }
        }
        return d;
    }
}
