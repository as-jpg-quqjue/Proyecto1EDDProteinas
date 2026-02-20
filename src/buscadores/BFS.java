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
public class BFS {
    public int[] bfsComponente (int inicio, Grafo grafo){
        if (grafo.getCantidadProteinas() > 0 && inicio > 0 && inicio <= grafo.getCantidadProteinas()) {
            /*Inicio es (0-indexado)*/
            boolean [] visitadas = new boolean [grafo.getCantidadProteinas()];
            int [] arreglo = new int [grafo.getCantidadProteinas()];
            int [] arregloAux = new int [grafo.getCantidadProteinas()];
            int cabeza = 0;
            int cola = 0;
            int k = 0;
            
            visitadas[inicio] = true;
            arreglo[cola++] = inicio;
            
            while (cabeza < cola){
                int i = arreglo[cabeza++];
                arregloAux [k++] = i;
                for (int j = 0; j < grafo.getCantidadProteinas(); j++) {
                    if (!visitadas[j] && grafo.estanConectadas(i, j)) {
                        visitadas[j] = true;
                        arreglo[cola++] = j;
                    } else if (!grafo.getActivas()[j]) {
                        continue;
                    }
                }
            }
            int [] salida = new int [k];
            for (int i = 0; i < k; i++) {
                salida[i] = arregloAux[i];
                
            }
            return salida;
            
        }
        return new int[0];
    }
}
