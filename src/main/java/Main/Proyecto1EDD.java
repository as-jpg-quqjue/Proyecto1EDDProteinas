/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import buscadores.CentralidadGrado;
import primitivas.Grafo;

/**
 *
 * @author mipc2
 */
public class Proyecto1EDD {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Grafo grafo = new Grafo(5);
                
        grafo.agregarProteina("b1");
        grafo.agregarProteina("c1");
        grafo.agregarProteina("a1");
        grafo.agregarProteina("d1");
        
        grafo.agregarConexión(3, 1, 20);
        grafo.agregarConexión(3, 2, 30);
        grafo.agregarConexión (3, 4, 16);
        grafo.agregarConexión(2, 4, 25);
        
        grafo.imprimirMatrizPeso();
        
        System.out.println(new CentralidadGrado(grafo).centralidad());
    }
}
